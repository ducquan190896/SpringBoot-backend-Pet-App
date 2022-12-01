package com.quan.petcaringapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quan.petcaringapp.Entity.Pet;
import com.quan.petcaringapp.Repository.PetRepos;


public interface PetService {
  

    public List<Pet> getpets();
    public List<Pet> getPetsbyCustomerId(Long id);
    public Pet getPetById(Long id);
    public void savePet(Long customerId, Pet pet);
    public Pet updatePet(Long petId, Pet pet);
}
