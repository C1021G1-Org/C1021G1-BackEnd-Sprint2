package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.CustomerDto;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.service.ICarService;
import com.example.carparkingmanagementbe.model.Customer;
import com.example.carparkingmanagementbe.service.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<Page<Customer>> getAllCustomer(@RequestParam(defaultValue = "0") int page) {
        Page<Customer> customers = customerService.findAllCustomer(PageRequest.of(page, 5));
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    Page<Customer> customerList;

    //ThangDBX tim kiem full truong
    @GetMapping("search")
    public ResponseEntity<Page<Customer>> searchFull(@RequestParam(defaultValue = "", required = false) String startDate,
                                                     @RequestParam(defaultValue = "", required = false) String endDate,
                                                     @RequestParam(defaultValue = "", required = false) String code,
                                                     @RequestParam(defaultValue = "", required = false) String phone,
                                                     @RequestParam(defaultValue = "", required = false) String idCard,
                                                     @RequestParam(defaultValue = "0") int page) {

        if ("".equals(startDate) && "".equals(endDate)) {
            customerList = customerService.searchCustomerNoDate(code, phone, idCard, PageRequest.of(page, 5));
        }

        if ("".equals(startDate) && !"".equals(endDate)) {
            customerList = customerService.searchEndDate(endDate, code, phone, idCard, PageRequest.of(page, 5));
        }
        if (!"".equals(startDate) && "".equals(endDate)) {
            customerList = customerService.searchStartDate(startDate, code, phone, idCard, PageRequest.of(page, 5));
        }
        if (!"".equals(startDate) && !"".equals(endDate)) {
            customerList = customerService.searchFullDate(startDate, endDate, code, phone, idCard, PageRequest.of(page, 5));
        }

        try {
            if (customerList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(customerList, HttpStatus.OK);
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/not-pagination")
    public ResponseEntity<Page<Customer>> getAllCustomerNotPagination() {
        Page<Customer> customers = this.customerService.findAllCustomer(Pageable.unpaged());
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    };


    //ThangDBX delete customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    //ThangDBX tim customer theo ID
    @GetMapping("find/{id}")
    public ResponseEntity<Optional<Customer>> findCustomerByIdToDelte(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }


    //    Bảo thêm mới
    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
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
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            Map<String, Object> response = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            response.put("error", errorMap);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        customerDto.setName(String.valueOf(charArray));
        int code = (int) Math.floor((Math.random() * 899) + 100);
        String codeRandom = String.valueOf(code);
        customerDto.setCode("KH-" + codeRandom);
        customerService.createCustomer(customerDto);
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(customerDto,customer);
//        customer.getWard().setId(customerDto.getWard());
////        customerService.save(customer);
//        carDto.setCustomer(customer.getId());
//        carService.createCar(carDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    //TrongHD lấy thông tin khách hàng
    @GetMapping("/{id}")
    public ResponseEntity<List<Car>> findByIdCustomer(@PathVariable Long id) {
        List<Car> carList = carService.findCarByIdCustomer(id);
        if (carList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }


    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDtoCheck customerDtoCheck,
                                          BindingResult bindingResult) {
        customerDtoCheck.setId(id);
        new CustomerDtoCheck().validate(customerDtoCheck, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            Map<String, Object> response = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            response.put("error", errorMap);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        customerService.updateCustomer(customerDtoCheck);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }



//    Validate thêm mới

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
    public ResponseEntity<Optional<Customer>> findCustomerWithId(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findCustomerById(id);
        return new ResponseEntity<>(customerOptional, HttpStatus.OK);
    }

}
