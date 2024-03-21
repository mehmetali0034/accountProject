package com.folksdev.account.service;

import com.folksdev.account.dto.CustomerDto;
import com.folksdev.account.dto.converter.CustomerDtoConverter;
import com.folksdev.account.exception.CustomerNotFoundException;
import com.folksdev.account.model.Customer;
import com.folksdev.account.repostory.CustomerRepostory;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToStdout;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepostory customerRepostory;
    private final CustomerDtoConverter customerDtoConverter;
    public CustomerService(CustomerRepostory customerRepostroy, CustomerDtoConverter customerDtoConverter){
        this.customerRepostory =customerRepostroy;
        this.customerDtoConverter = customerDtoConverter;
    }

    public Customer findCustomerById(String id){
        return this.customerRepostory.findById(id).orElseThrow(
                ()->new CustomerNotFoundException("Customer could not found by id " + id));
        //Baktığımız zaman findById bana optional bir değer dönüyor.Bu sebeple Null hatası dönemeli biz de orElseThrow yazdık.
    }

    public CustomerDto getCustomerById(String customerId){
        return customerDtoConverter.convert(findCustomerById(customerId));
    }
    public List<CustomerDto> getAllCustomers(){
        List<Customer> customers = this.customerRepostory.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers){
            customerDtos.add(customerDtoConverter.convert(customer));
        }
        return customerDtos;
    }
}
