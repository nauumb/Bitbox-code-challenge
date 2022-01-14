package com.exercise.bitboxer.services;

import com.exercise.bitboxer.dto.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

     ResponseEntity<String> insertItem(ItemDTO itemDTO);
     ResponseEntity<ItemDTO> findItemById(Long id);
     ResponseEntity<List<ItemDTO>> findAllItems();
     ResponseEntity<String> updateItem(ItemDTO itemDTO);

}

