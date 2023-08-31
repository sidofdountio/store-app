package com.sidof.repo;

import com.sidof.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author sidof
 * @Since 03/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Repository
public interface OrderRepo extends JpaRepository<Orders,Long> {
}
