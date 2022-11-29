package com.quan.petcaringapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quan.petcaringapp.Entity.Customer;
import com.quan.petcaringapp.Repository.CustomerRepos;

@Service
public class CustomerService {
    @Autowired
    CustomerRepos customerRepos;

    public List<Customer> getCustomers() {
        return customerRepos.findAll();
    }
    // public String getCustomers() {
    //     customerRepos.findAll().stream().forEach(cust -> System.out.println(cust));
    //     System.out.println("hello");
    //     return "hello";
    // }
}
