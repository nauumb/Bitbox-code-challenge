package com.exercise.bitboxer.repositories;

import com.exercise.bitboxer.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}