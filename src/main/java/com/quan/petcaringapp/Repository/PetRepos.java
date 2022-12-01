package com.quan.petcaringapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quan.petcaringapp.Entity.Customer;
import com.quan.petcaringapp.Entity.Pet;

@Repository
public interface PetRepos extends JpaRepository<Pet, Long>{
    @Query(
        value = "select * from pet where name = ?1 and birthdate = ?2",
        nativeQuery = true
    )
    Optional<Pet> findPetByNameAndBirthDate(String name, String birthdate);

    // @Query(
    //     value = "select * from pet where customer_id = ?1",
    //     nativeQuery = true
    // )
    List<Pet> findPetByCustomer(Customer customer);

    // @Query(
    //     value = "select * from pet where id = ?1",
    //     nativeQuery = true
    // )
    // Optional<Pet> findPetById(Long id);
}
