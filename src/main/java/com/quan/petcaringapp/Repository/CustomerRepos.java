package com.quan.petcaringapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quan.petcaringapp.Entity.Customer;

@Repository
public interface CustomerRepos extends JpaRepository<Customer, Long> {
    
}
