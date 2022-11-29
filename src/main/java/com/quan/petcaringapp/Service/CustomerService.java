package com.quan.petcaringapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quan.petcaringapp.Entity.Customer;


public interface CustomerService {
   public Customer getCustomer(String email);
   public List<Customer> getCustomers();
   public void saveCustomer(Customer customer);
   public Customer updateCustomer(Long id, Customer customer);
   public void deleteCustomer(Long id);

}
