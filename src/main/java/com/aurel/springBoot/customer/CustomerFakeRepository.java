package com.aurel.springBoot.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Aurel Chivu", "aurel@gmail.com", "password"),
                new Customer(2L, "James Bond", "james@gmail.com", "123456"),
                new Customer(3L, "James Bond", "email@gmail.com", "123456")
        );
    }
}
