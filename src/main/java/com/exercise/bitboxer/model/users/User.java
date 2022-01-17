package com.exercise.bitboxer.model.users;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
}