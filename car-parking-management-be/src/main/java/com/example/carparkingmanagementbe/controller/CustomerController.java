package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.Customer;
import com.example.carparkingmanagementbe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
   private ICustomerService iCustomerService;

    //ThangDBX lay danh sach khach hang
    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> getAllCustomer(@RequestParam(defaultValue = "0") int page ){
        Page<Customer> customers = iCustomerService.findAllCustomer(PageRequest.of(page,5));
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //ThangDBX tim kiem full truong
    @GetMapping("search")
    public ResponseEntity<Page<Customer>> searchFull(@RequestParam(defaultValue = "",required = false) String code,
                                                     @RequestParam(defaultValue = "",required = false) String phone,
                                                     @RequestParam(defaultValue = "",required = false) String id,
                                                     @RequestParam(defaultValue = "",required = false) String start,
                                                     @RequestParam(defaultValue = "",required = false) String end,
                                                        @RequestParam(defaultValue = "0") int page){
        Page<Customer> customerList = null;
        customerList = iCustomerService.searchfullDate(code,phone,id,start,end, PageRequest.of(page,2));

        if (customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerList,HttpStatus.OK);
        }

    }


}
