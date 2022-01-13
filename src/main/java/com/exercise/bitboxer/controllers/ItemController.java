package com.exercise.bitboxer.controllers;

import com.exercise.bitboxer.entities.Item;
import com.exercise.bitboxer.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping("/bitboxer/v1/insertItem")
    public void insertItem(Item item){
        itemService.insertItem(item);
    }
}
