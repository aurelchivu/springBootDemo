package com.aurel.springBoot.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Aurel Chivu", "password"),
                new Customer(2L, "James Bond", "123456")
        );
    }
}
