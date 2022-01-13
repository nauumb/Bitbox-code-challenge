package com.exercise.bitboxer.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "creationdate")
    private LocalDate creationDate;

    @Column(name = "status")
    private Boolean itemStatus;

    @ManyToMany
    private Set<Supplier> supplierSet;

}