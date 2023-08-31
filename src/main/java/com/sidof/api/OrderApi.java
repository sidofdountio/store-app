package com.sidof.api;

import com.sidof.model.Orders;
import com.sidof.repo.OrderRepo;
import com.sidof.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * @Author sidof
 * @Since 04/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@RestController
@RequestMapping("/api/v1/luxelyfe/order")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequiredArgsConstructor
@Slf4j
public class OrderApi {
    private final OrderService  orderService;

    @GetMapping
    public ResponseEntity<List<Orders>>orders(){
        return new ResponseEntity<>(orderService.ORDERS_LIST(), OK);
    }
    @PostMapping("/addOrder")
    public ResponseEntity<List<Orders>>addOrders(@RequestBody List<Orders>  orders){
        return new ResponseEntity<>(orderService.addOrder(orders), CREATED);
    }
}
