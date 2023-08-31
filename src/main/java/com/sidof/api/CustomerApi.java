package com.sidof.api;

import com.sidof.model.Customer;
import com.sidof.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @Author sidof
 * @Since 04/08/2023
 * @Version v1.0
 */
@RestController
@RequestMapping("/api/v1/luxelyfe/customer")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@Slf4j
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        final List<Customer> customers = customerService.CUSTOMERS();
        return new ResponseEntity<>(customers, OK);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> saveProduct(@RequestBody Customer customerToSave) {
        final Customer customer = customerService.addCustomer(customerToSave);
        return new ResponseEntity<>(customer, CREATED);
    }
}
