package com.exercise.bitboxer.controllers;

import com.exercise.bitboxer.dto.ItemDTO;
import com.exercise.bitboxer.services.ItemService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bitboxer/v1/")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController (ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/insertItem")
    public ResponseEntity<String> insertItem(@RequestBody ItemDTO itemDTO){

        try {
            itemService.insertItem(itemDTO);
            return  new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateItem")
    public ResponseEntity<String> updateItem(@RequestBody ItemDTO itemDTO){

        try {
            itemService.updateItem(itemDTO);
            return  new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getItem")
    public ResponseEntity<ItemDTO> findItemById(Long id) {

        try {
            ItemDTO itemDTO = itemService.findItemById(id);
            return ResponseEntity.ok(itemDTO);
        }
        catch (ObjectNotFoundException e ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllItems")
    public ResponseEntity<List<ItemDTO>> findAllItems() {

        try {
            List<ItemDTO> itemsDTO = itemService.findAllItems();
            return ResponseEntity.ok(itemsDTO);

        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}