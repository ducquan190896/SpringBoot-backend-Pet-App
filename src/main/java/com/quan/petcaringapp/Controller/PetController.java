package com.quan.petcaringapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.quan.petcaringapp.Entity.Pet;
import com.quan.petcaringapp.Service.CustomerService;
import com.quan.petcaringapp.Service.PetService;

import jakarta.validation.Valid;


@ResponseBody
@Controller
@RequestMapping("/api/v1/pets")
public class PetController {
    @Autowired
    PetService petService;


    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getPets() {
        return new ResponseEntity<List<Pet>>(petService.getpets(), HttpStatus.OK);
    }
    @GetMapping("/customerId/{id}")
    public ResponseEntity<List<Pet>> getPetsByCustomer(@PathVariable Long id) {
        return new ResponseEntity<List<Pet>>(petService.getPetsbyCustomerId(id), HttpStatus.OK);
    }
    @GetMapping("/petId/{id}")
    public ResponseEntity<Pet> getPetsById(@PathVariable Long id) {
        return new ResponseEntity<Pet>(petService.getPetById(id), HttpStatus.OK);
    }

    @PostMapping("/customerId/{customerId}")
    public ResponseEntity<HttpStatus> savePet(@PathVariable Long customerId, @Valid @RequestBody Pet pet) {
        petService.savePet(customerId, pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/petId/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return new ResponseEntity<Pet>(petService.updatePet(id, pet), HttpStatus.OK);
    }
}
