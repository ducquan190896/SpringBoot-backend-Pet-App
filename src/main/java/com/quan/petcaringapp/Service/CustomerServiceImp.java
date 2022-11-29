package com.quan.petcaringapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quan.petcaringapp.Entity.Customer;
import com.quan.petcaringapp.Exception.EntityNotFoundException;
import com.quan.petcaringapp.Repository.CustomerRepos;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerRepos customerRepos;

    @Override
    public void deleteCustomer(Long id) {
      Optional<Customer> entity = customerRepos.findById(id);
      Customer customer = checkCustomer(entity, id);
      customerRepos.delete(customer);
        
    }

    @Override
    public Customer getCustomer(String email) {
       Optional<Customer> entity = customerRepos.findCustomerByEmail(email);
    //    Customer customer = checkCustomer(entity, 404L);
    Customer customer = entity.get();
       System.out.println(customer);
    
       return customer;
    // return email;
    // System.out.println(new Customer("quan", "0913209809", "quan123@gmail.com", "take care of my pet carfully"));
    // return new Customer("quan", "0913209809", "quan123@gmail.com", "take care of my pet carfully");

    }

    @Override
    public List<Customer> getCustomers() {
        // return customerRepos.findAll();
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("quan", "0913209809", "quan@gmail.com", "take care of my pet carfully"));
        return list;
    }
   

    @Override
    public void saveCustomer(Customer customer) {
        Optional<Customer> entity = customerRepos.findCustomerByEmail(customer.getEmail());
        if(entity.isPresent()) {
            throw new EntityNotFoundException("the customer with email " + customer.getEmail() + " already exists");

        }
        customerRepos.save(customer);
        
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> entity = customerRepos.findById(id);
        Customer customer1 = checkCustomer(entity, id);
        customer1.setEmail(customer.getEmail());
        customer1.setName(customer.getName());
        customer1.setNotes(customer.getNotes());
        customer1.setPhoneNumber(customer.getPhoneNumber());
      return  customerRepos.save(customer1);
    }


    private Customer checkCustomer(Optional<Customer> entity, Long id) {
        if(entity.isPresent()) {
            return entity.get();
        }
     throw new EntityNotFoundException("the customer with id " + id + " not found");   
    }
    
}
