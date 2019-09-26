package com.example.CustomerRest.controllers;

import com.example.CustomerRest.entities.Customer;
import com.example.CustomerRest.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("customer/{id}")
    public Customer getOneCustomer(@PathVariable Long id){
        return customerService.getOneCustomer(id);
    }
}
