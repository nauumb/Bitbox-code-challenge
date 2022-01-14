package com.exercise.bitboxer.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "item", uniqueConstraints = {@UniqueConstraint(columnNames = {"itemcode"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name = "item_id_seq",sequenceName = "item_id_seq")
    @Column(name = "id", nullable = false)
    @NotNull
    private Long id;

    @Column(name="itemcode", nullable = false)
    @NotNull
    private Long itemCode;

    @Column(name = "description", nullable = false)
    @NotNull
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status", columnDefinition = "boolean default true")
    private Boolean itemStatus;

    private LocalDateTime createdDate;

    @ManyToMany
    @JoinTable(
            name = "item_supplier",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private Set<Supplier> suppliers;

    @OneToMany(mappedBy = "item")
    @JsonBackReference
    private Set<PriceReduction> priceReductions;
}