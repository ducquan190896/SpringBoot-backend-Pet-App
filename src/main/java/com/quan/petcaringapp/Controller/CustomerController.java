package com.quan.petcaringapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quan.petcaringapp.Entity.Customer;
import com.quan.petcaringapp.Service.CustomerService;

import jakarta.validation.Valid;

@Controller
@ResponseBody
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
    }

    @GetMapping("/all1")
    public ResponseEntity<List<Customer>> getCustomers1() {
        
        return new ResponseEntity<List<Customer>>(customerService.getCustomers1(), HttpStatus.OK);
    }
    @GetMapping("/email/{email}")
    public  ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        
        return new ResponseEntity<>(customerService.getCustomerbyEmail(email), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<HttpStatus> saveCustomer(@Valid @RequestBody Customer customer) {
        customerService.SaveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, @PathVariable Long id) {
        
        return new ResponseEntity<>(customerService.updateCustomer(id, customer) ,HttpStatus.CREATED);
    }
}
