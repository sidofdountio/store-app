package com.sidof.model;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.sidof.model.enumes.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * @Author sidof
 * @Since 02/08/2023
 * @Version v1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor @Entity
public class Orders {
    @SequenceGenerator(name = "sequence_id_sale",allocationSize = 1,sequenceName = "sequence_id_sale") @GeneratedValue(strategy = SEQUENCE,generator = "sequence_id_sale")
    @Id
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "customer_id",referencedColumnName = "id" ,foreignKey = @ForeignKey(name = "orders_customer"))
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "product_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "orders_product"))
    private Product product ;
    private int quantity;
    private double amount;
    private LocalDate orderAt;
    private Status status;
}
