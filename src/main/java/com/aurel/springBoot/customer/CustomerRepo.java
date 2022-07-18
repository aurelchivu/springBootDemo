package com.aurel.springBoot.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo {
    List<Customer> getCustomers();
}
