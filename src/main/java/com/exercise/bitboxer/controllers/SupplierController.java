package com.exercise.bitboxer.controllers;

import com.exercise.bitboxer.dto.SupplierDTO;
import com.exercise.bitboxer.services.SupplierService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bitboxer/v1/")
public class SupplierController {

    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @GetMapping("/getAllSuppliers")
    public ResponseEntity<List<SupplierDTO>> findAllSuppliers() {

        try {
            List<SupplierDTO> suppliersDTO = supplierService.findAllSuppliers();
            return ResponseEntity.ok(suppliersDTO);

        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
