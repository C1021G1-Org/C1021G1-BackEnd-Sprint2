package com.example.carparkingmanagementbe.controller;


import com.example.carparkingmanagementbe.model.Customer;
import com.example.carparkingmanagementbe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import com.example.carparkingmanagementbe.dto.CustomerDto;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.service.ICarService;

import com.example.carparkingmanagementbe.dto.CustomerDtoCheck;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
   private ICustomerService customerService;

    @Autowired
    private ICarService carService;

    //ThangDBX lay danh sach khach hang
    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> getAllCustomer(@RequestParam(defaultValue = "0") int page ){
        Page<Customer> customers = customerService.findAllCustomer(PageRequest.of(page,5));
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //ThangDBX tim kiem full truong
    @GetMapping("search")
    public ResponseEntity<Page<Customer>> searchFull(@RequestParam(defaultValue = "",required = false) String startDate,
                                                     @RequestParam(defaultValue = "",required = false) String endDate,
                                                     @RequestParam(defaultValue = "",required = false) String code,
                                                     @RequestParam(defaultValue = "",required = false) String phone,
                                                     @RequestParam(defaultValue = "",required = false) String id_card,
                                                        @RequestParam(defaultValue = "0") int page){
        Page<Customer> customerList = null;
        if ("".equals(startDate) && "".equals(endDate)){
            customerList = customerService.searchCustomerNoDate(code,phone,id_card, PageRequest.of(page,2));
        }
        if ("".equals(startDate) && !"".equals(endDate)){
            customerList = customerService.searchEndDate(endDate,code,phone,id_card,PageRequest.of(page,2));
        }
        if (!"".equals(startDate) && "".equals(endDate)){
            customerList = customerService.searchStartDate(startDate,code,phone,id_card,PageRequest.of(page,2));
        }
        if (!"".equals(startDate) && !"".equals(endDate)){
            customerList = customerService.searchFullDate(startDate,endDate,code,phone,id_card, PageRequest.of(page,2));
        }


        if (customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerList,HttpStatus.OK);
        }

    }

    //ThangDBX delete customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }


//    Bảo thêm mới
    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        char[] charArray = customerDto.getName().toCharArray();
        boolean foundSpace = true;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                if (foundSpace) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                foundSpace = true;
            }
        }
        customerDto.setName(String.valueOf(charArray));
        customerService.createCustomer(customerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //TrongHD lấy thông tin khách hàng
    @GetMapping("/{id}")
    public ResponseEntity<List<Car>> findByIdCustomer(@PathVariable Long id) {
        List<Car> carList = carService.findByIdCustomer(id);
        if (carList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }


    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateFlight(@PathVariable Long id,@Valid @RequestBody CustomerDtoCheck customerDtoCheck) {
        customerDtoCheck.setId(id);
        customerService.updateCustomer(customerDtoCheck);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    // tronghd validate dữ liệu thêm mới

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

//    Bảo hiển thị
    @GetMapping("/detail/{id}")
    public ResponseEntity<List<Car>> findCustomerById(@PathVariable Long id) {
        List<Car> carList = carService.selectCar(id);
        if (carList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

}
