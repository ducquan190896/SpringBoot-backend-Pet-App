package com.quan.petcaringapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.quan.petcaringapp.Entity.Customer;
import com.quan.petcaringapp.Exception.EntityNotFoundException;
import com.quan.petcaringapp.Repository.CustomerRepos;

import jakarta.validation.Valid;

@Service
public class CustomerService {
    @Autowired
    CustomerRepos customerRepos;

    public List<Customer> getCustomers() {
       
        List<Customer> list = customerRepos.findAll();
       
            return list;
        
    }
    
    public List<Customer> getCustomers1() {

     
        customerRepos.findAll().stream().forEach(cust -> System.out.println(cust));

       

        List<Customer> list = new ArrayList<>();
        Customer customer1 = new Customer("Thoa", "0412456789", "Thoa@gmail.com", "my pet is sick, take it to the hospital");
        list.add(customer1);
        return list;
    }

    public Customer getCustomerbyEmail(String email) {
        Optional<Customer> entity = customerRepos.findCustomerByEmail(email);
        if(entity.isPresent()) {
            Customer customer = entity.get();
            return customer;
        }
        throw new EntityNotFoundException("the customer with email "+ email + " cannot find");

    }
    public void SaveCustomer( Customer customer) {
        Optional<Customer> entity = customerRepos.findCustomerByEmail(customer.getEmail());
         if(entity.isPresent()) {
            throw new EntityNotFoundException("the customer with email "+ customer.getEmail() + " already exists");
         }
         customerRepos.save(customer);
    }
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> entity = customerRepos.findById(id);
        if(!entity.isPresent()) {
            throw new EntityNotFoundException("the customer with id "+ id + " cannot find");
        }
        Customer customer2 = entity.get();
        customer2.setEmail(customer.getEmail());
        customer2.setName(customer.getName());
        customer2.setNotes(customer.getNotes());
        return customerRepos.save(customer2);
    }
}
