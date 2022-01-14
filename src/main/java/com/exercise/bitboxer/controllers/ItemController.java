package com.exercise.bitboxer.controllers;

import com.exercise.bitboxer.dto.ItemDTO;
import com.exercise.bitboxer.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bitboxer/v1/")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/insertItem")
    public ResponseEntity<String> insertItem(@RequestBody ItemDTO itemDTO){
        return itemService.insertItem(itemDTO);
    }

    @PutMapping("/editItem")
    public ResponseEntity<String> updateItem(ItemDTO itemDTO){
        return itemService.updateItem(itemDTO);
    }

    @GetMapping("/item")
    public ResponseEntity<ItemDTO> findItemById(Long id) {
        return itemService.findItemById(id);
    }

    @GetMapping("/getAllItems")
    public ResponseEntity<List<ItemDTO>> findAllItems() {
        return itemService.findAllItems();
    }
}