package com.example.CustomerRest.controllers;

import com.example.CustomerRest.entities.Customer;
import com.example.CustomerRest.repositories.CustomerRepository;
import com.example.CustomerRest.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CustomerControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    SimpleDateFormat formatter;
    List<Customer> customers;

    @Before
    public void setup() throws ParseException {
        formatter = new SimpleDateFormat("MM/dd/yyyy");
        customers = new ArrayList();
        customers.add(new Customer("Sally", formatter.parse("01/04/2019")));
        customers.add(new Customer("John", formatter.parse("01/05/2019")));
        customers.add(new Customer("Mary", formatter.parse("01/06/2019")));
        customerRepository.saveAll(customers);
    }
    @Test
    public void getAllCustomers() throws Exception {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Sally"));
    }

    @Test
    public void getOneCustomer() throws Exception{
        Long id = customers.get(0).getId();
        mockMvc.perform(get("/customer/" + id))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.name").value("Sally"));
    }
}
