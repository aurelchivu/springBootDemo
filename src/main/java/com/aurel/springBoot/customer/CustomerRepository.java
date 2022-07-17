package com.aurel.springBoot.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

public class CustomerRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        // TODO connect to real db
        return List.of(
            new Customer(1L, "TODO: connect to real db")
        );
    }
}
