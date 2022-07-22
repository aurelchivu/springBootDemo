package com.aurel.springBoot.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        // given
        Customer monique = new Customer(1L, "monique", "monique@gmail.com", "hello" );
        Customer alex = new Customer(3L, "alex", "alex@gmail.com", "hello" );

        customerRepository.saveAll(Arrays.asList(monique, alex));

        // when
        List<Customer> customers = underTest.getCustomers();

        // then
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        // given
        Customer alex = new Customer(1L, "alex", "alex@gmail.com", "hello" );

        customerRepository.save(alex);

        // when
        Customer customer = underTest.getCustomer(1L);

        // then
        assertEquals(1L, customer.getId());
        assertEquals("alex", customer.getName());
        assertEquals("alex@gmail.com", customer.getEmail());
        assertEquals("hello", customer.getPassword());
    }
}
