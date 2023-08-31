package com.sidof.service.interfaceService;

import com.sidof.model.Orders;

import java.util.List;

/**
 * @Author sidof
 * @Since 03/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
public interface OrderServiceDao {
    List<Orders> addOrder(List<Orders> order);
    Orders updateOrders(Orders sale);
    Orders getOrder(Long orderId);
    boolean deleteOrders(Long orderIdToDelete);
    List<Orders> ORDERS_LIST();
}
