package com.sidof.repo;

import com.sidof.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author sidof
 * @Since 03/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Optional<Customer>findByEmail(String email);
}
