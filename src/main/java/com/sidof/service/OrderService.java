package com.sidof.service;

import com.sidof.model.Orders;
import com.sidof.model.enumes.Status;
import com.sidof.repo.OrderRepo;
import com.sidof.service.interfaceService.OrderServiceDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sidof.model.enumes.Status.*;
import static java.time.LocalDate.now;

/**
 * @Author sidof
 * @Since 04/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService implements OrderServiceDao {
    private final OrderRepo orderRepo;

    /**
     * @param order
     * @return
     */
    @Override
    public List<Orders> addOrder(List<Orders> orders) {
        for (Orders order : orders) {
            if (order.getAmount() < 1000) {
                log.error("order amount can't be less than 0");
                break;
            }
            order.setOrderAt(now());
            order.setStatus(INPROGRESSE);
        }
        log.info("add new order {}", orders);
        return orderRepo.saveAll(orders);
    }

    /**
     * @param order
     * @return
     */
    @Override
    public Orders updateOrders(Orders order) {
        return orderRepo.save(order);
    }

    /**
     * @param orderId
     * @return
     */
    @Override
    public Orders getOrder(Long orderId) {
        return orderRepo.findById(orderId).orElseThrow(
                () -> new IllegalStateException(String.format("order id %d not found", orderId))
        );
    }

    /**
     * @param orderIdToDelete
     * @return
     */
    @Override
    public boolean deleteOrders(Long orderIdToDelete) {
        if (!orderRepo.existsById(orderIdToDelete)) {
            log.error("order id %d not found", orderIdToDelete);
            throw new IllegalStateException(String.format("order id %d not found", orderIdToDelete));
        }
        orderRepo.deleteById(orderIdToDelete);
        return true;
    }

    /**
     * @return
     */
    @Override
    public List<Orders> ORDERS_LIST() {
        log.info("fetching orders");
        return orderRepo.findAll();
    }
}
