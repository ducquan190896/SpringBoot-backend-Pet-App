package com.quan.petcaringapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quan.petcaringapp.Entity.Pet;

@Repository
public interface PetRepos extends JpaRepository<Pet, Long>{
    
}
