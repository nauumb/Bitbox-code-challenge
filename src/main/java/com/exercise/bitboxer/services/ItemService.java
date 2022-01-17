package com.exercise.bitboxer.services;

import com.exercise.bitboxer.dto.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

     void insertItem(ItemDTO itemDTO);
     ItemDTO findItemById(Long id);
     List<ItemDTO> findAllItems();
     void updateItem(ItemDTO itemDTO);

}

