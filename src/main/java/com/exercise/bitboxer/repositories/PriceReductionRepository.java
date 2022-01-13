package com.exercise.bitboxer.repositories;

import com.exercise.bitboxer.entities.PriceReduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceReductionRepository extends JpaRepository<PriceReduction, Long> {
}