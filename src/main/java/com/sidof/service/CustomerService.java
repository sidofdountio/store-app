package com.sidof.service;

import com.sidof.model.Customer;
import com.sidof.repo.CustomerRepo;
import com.sidof.service.interfaceService.CustomerServiceDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author sidof
 * @Since 20/05/2023
 * @Version v1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService implements CustomerServiceDao {
    private final CustomerRepo customerRepo;
    @Override
    public Customer addCustomer(Customer customer) {
        if (customer.getPhone() == null) {
            log.error("customer phone can't be empty");
            throw new IllegalStateException("customer phone can't be empty");
        }
        if (customer.getPhone().length() == 9) {
            log.error("customer phone must have nine numbers {}", customer.getPhone());
            throw new IllegalStateException(String.format("customer phone must have nine numbers %s", customer.getPhone()));
        }
        if (customer.getFullName() == null) {
            log.error("customer phone can't be empty");
            throw new IllegalStateException("customer phone can't be empty");
        }

        Optional<Customer> customerByEmail = customerRepo.findByEmail(customer.getEmail());
        if (customerByEmail.isPresent()){
            log.info("customer exist {}", customer);
            return customer;
        }
        customer.getPhone().trim();
        log.info("Add new customer {}", customer);
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepo.findById(customerId).orElseThrow(
                ()-> new IllegalStateException(String.format("customer id {} not found",customerId))
        );
    }

    @Override
    public Boolean DeleteCustomer(Long customerIdToDelete) {
        if (!customerRepo.existsById(customerIdToDelete)) {
            log.error("customer id {} not found", customerIdToDelete);
            throw new IllegalStateException(String.format("customer id %s not found", customerIdToDelete));

        }
        log.info("delete customer with {}",customerIdToDelete);
        customerRepo.deleteById(customerIdToDelete);
        return true;
    }

    @Override
    public List<Customer> CUSTOMERS() {
        log.info("fetching customers");
        return customerRepo.findAll();
    }
}
