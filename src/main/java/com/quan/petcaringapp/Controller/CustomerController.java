package com.quan.petcaringapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quan.petcaringapp.Entity.Customer;
import com.quan.petcaringapp.Service.CustomerService;

@Controller
@ResponseBody
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
    }
    // @GetMapping("/all")
    // public ResponseEntity<String> getCustomers() {
        
    //     return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    // }
}
