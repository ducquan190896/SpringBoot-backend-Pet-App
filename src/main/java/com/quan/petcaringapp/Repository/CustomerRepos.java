package com.quan.petcaringapp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quan.petcaringapp.Entity.Customer;

@Repository
public interface CustomerRepos extends JpaRepository<Customer, Long> {
    @Query(
        value = "select * from customer where email = ?1",
        nativeQuery =  true
    )
    Optional<Customer> findCustomerByEmail(String email);
}
