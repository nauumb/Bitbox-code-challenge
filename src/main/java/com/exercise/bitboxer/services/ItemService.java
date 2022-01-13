package com.exercise.bitboxer.services;

import com.exercise.bitboxer.entities.Item;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    public void insertItem(Item item);
}

