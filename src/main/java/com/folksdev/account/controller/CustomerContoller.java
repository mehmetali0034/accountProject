package com.folksdev.account.controller;


import com.folksdev.account.dto.CustomerDto;
import com.folksdev.account.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
public class CustomerContoller {
    private final CustomerService customerService;
    public CustomerContoller(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String customerId){//@PathVariable parametre için değeri url alammızı sağlar
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/getallcustomers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }
}
