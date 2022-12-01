package com.quan.petcaringapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quan.petcaringapp.Entity.Customer;
import com.quan.petcaringapp.Entity.Pet;
import com.quan.petcaringapp.Exception.EntityNotFoundException;
import com.quan.petcaringapp.Repository.CustomerRepos;
import com.quan.petcaringapp.Repository.PetRepos;

@Service
public class PetServiceImp implements PetService {
    @Autowired
    PetRepos petRepos;
    @Autowired
    CustomerRepos customerRepos;

    public List<Pet> getpets() {
        return petRepos.findAll();
    }

    @Override
    public List<Pet> getPetsbyCustomerId(Long id) {
        Optional<Customer> entity = customerRepos.findById(id);
        if(!entity.isPresent()) {
            throw new EntityNotFoundException("the customer with id " + id + " not found");
        }
        Customer customer = entity.get();
       return petRepos.findPetByCustomer(customer);
    }

    @Override
    public Pet getPetById(Long id) {
        Optional<Pet> entity = petRepos.findById(id);
        if(!entity.isPresent()) {
            throw new EntityNotFoundException("the pet with id " + id + " not found");
        }
        return entity.get();
        
    }

    @Override
    public void savePet(Long customerId, Pet pet) {
        Optional<Customer> entity = customerRepos.findById(customerId);
        if(!entity.isPresent()) {
            throw new EntityNotFoundException("the customer with customerId " + customerId + " not found");
        }
        Customer customer = entity.get();
        pet.setCustomer(customer);
        petRepos.save(pet);
    }

    @Override
    public Pet updatePet(Long petId, Pet pet) {
        Optional<Pet> entity = petRepos.findById(petId);
        if(!entity.isPresent()) {
            throw new EntityNotFoundException("the pet with petId " + petId + " not found");
        }
        Pet pet1 = entity.get();
        System.out.println(pet1);
        pet1.setName(pet.getName());
        pet1.setNotes(pet.getNotes());
        pet1.setBirthDate(pet.getBirthDate());
        return petRepos.save(pet1);
    }
    
}
