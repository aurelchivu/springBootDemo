package com.aurel.springBoot.customer;

import com.aurel.springBoot.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    void createCustomer(Customer customer) {
        log.info("createCustomer was called");
        customerRepository.save(customer);
    }

    List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        log.info("getCustomer was called");
        return customerRepository.findById(id)
            .orElseThrow(() -> {
                NotFoundException notFoundException = new NotFoundException(
                    "customer with id " + id + " not found"
                );
                log.error("Error in getting customer {}" , id, notFoundException);
                return notFoundException;
            });
    }

    void updateCustomer(Long id, Customer customer) {
        log.info("updateCustomer was called");
        customerRepository.findById(id);
        customerRepository.save(customer);
    }

    void deleteCustomer(Long id) {
        log.info("deleteCustomer was called");
        if (!customerRepository.existsById(id)) {
            throw new NotFoundException("customer with id " + id + " doesn't exists");
        }
        customerRepository.deleteById(id);
    }
}
