package com.exercise.bitboxer.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_id_seq")
    @SequenceGenerator(name = "supplier_id_seq",sequenceName = "supplier_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "country", nullable = false)
    @NotNull
    private String country;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Item> items = new HashSet<>();

}