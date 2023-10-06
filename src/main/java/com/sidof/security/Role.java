package com.sidof.security;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * @Author sidof
 * @Since 10/2/23
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    @SequenceGenerator(name = "sequence_id_role",allocationSize = 1,sequenceName = "sequence_id_role") @GeneratedValue(strategy = SEQUENCE,generator = "sequence_id_role")
    @Id
    private Long id;
    private String name;
}
