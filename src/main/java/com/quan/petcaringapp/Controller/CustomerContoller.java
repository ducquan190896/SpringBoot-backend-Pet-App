package com.quan.petcaringapp.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quan.petcaringapp.Entity.Customer;
import com.quan.petcaringapp.Repository.CustomerRepos;
import com.quan.petcaringapp.Service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerContoller {
    @Autowired
    CustomerService customerService;
   

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAll() {
        return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
    }
    // @GetMapping("/all")
    // public ResponseEntity<String> getAll() {
    //     return new ResponseEntity<>("hello", HttpStatus.OK);
    // }
 

    @GetMapping("/email/{email}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String email) {
        return new ResponseEntity<Customer>(customerService.getCustomer(email), HttpStatus.OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PostMapping("/")
    public ResponseEntity<HttpStatus> saveCustomer(@Valid @RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.updateCustomer(id, customer), HttpStatus.OK);
    }
}
