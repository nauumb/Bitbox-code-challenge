package com.exercise.bitboxer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SupplierDTO implements Serializable {
    private  Long id;
    private  String name;
    private  String country;
}
