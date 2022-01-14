package com.exercise.bitboxer.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pricereduction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceReduction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_reduction_id_seq")
    @SequenceGenerator(name = "price_reduction_id_seq",sequenceName = "price_reduction_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "startdate", nullable = false)
    @NotNull
    private LocalDateTime startDate;

    @Column(name = "enddate", nullable = false)
    @NotNull
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonManagedReference
    private Item item;

}