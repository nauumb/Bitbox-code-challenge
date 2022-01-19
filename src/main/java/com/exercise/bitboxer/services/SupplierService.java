package com.exercise.bitboxer.services;

import com.exercise.bitboxer.dto.SupplierDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {

    List<SupplierDTO> findAllSuppliers();

}
