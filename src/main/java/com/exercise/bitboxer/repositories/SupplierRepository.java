package com.exercise.bitboxer.repositories;

import com.exercise.bitboxer.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}