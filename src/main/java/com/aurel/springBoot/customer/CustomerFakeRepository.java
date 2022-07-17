package com.aurel.springBoot.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Aurel Chivu"),
                new Customer(2L, "James Bond")
        );
    }
}
