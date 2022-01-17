package com.exercise.bitboxer.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_gen")
    @SequenceGenerator(name = "item_id_gen",sequenceName = "item_id_seq")
    @Column(name = "id", nullable = false)
    @NotNull
    private Long id;

    @Column(name="itemcode", nullable = false, updatable = false, length = 30, unique = true)
    @NotNull
    private Long itemCode;

    @Column(name = "description", nullable = false)
    @NotNull
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @CreationTimestamp
    @Column(name ="created_date", updatable = false)
    private LocalDateTime createdDate;

    @ManyToMany
    @JoinTable(
            name = "item_supplier",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private Set<Supplier> suppliers;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)

    private Set<PriceReduction> priceReductions;

    @PrePersist void preInsertItem(){
        if(this.status == null) {
            this.status = true;
        }
    }
}