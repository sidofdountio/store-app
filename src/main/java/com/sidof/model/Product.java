package com.sidof.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * @Author sidof
 * @Since 02/08/2023
 * @Version v1.0
 */
@Data @AllArgsConstructor @NoArgsConstructor @Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UQ_product_code",columnNames = "code"))
public class Product {
    @Id @SequenceGenerator(name = "sequence_id_product",allocationSize = 1,sequenceName = "sequence_id_product") @GeneratedValue(strategy = SEQUENCE,generator = "sequence_id_product")
    private Long id;
    private String name;
    private  String description;
    private double price;
    @Column(unique = true)
    private String code;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Orders>orders = new ArrayList<>();

}
