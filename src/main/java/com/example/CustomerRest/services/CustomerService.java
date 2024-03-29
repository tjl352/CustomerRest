package com.example.CustomerRest.services;

import com.example.CustomerRest.entities.Customer;
import com.example.CustomerRest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
       return customerRepository.findAll();
    }

    public Customer getCustomerByDate(Date date){
        return customerRepository.getByDate(date);
    }

    public Customer getCustomerByName(String name){
        return customerRepository.findByName(name);
    }

    public Customer getOneCustomer(Long id) {
        return customerRepository.findById(id).get();
    }

    public void deleteByName(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer editCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
