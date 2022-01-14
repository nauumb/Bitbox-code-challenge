package com.exercise.bitboxer.services.impl;

import com.exercise.bitboxer.dto.ItemDTO;
import com.exercise.bitboxer.entities.Item;
import com.exercise.bitboxer.repositories.ItemRepository;
import com.exercise.bitboxer.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<String> insertItem(ItemDTO itemDTO) {

        if(Objects.isNull(itemDTO.getItemCode()) || Objects.isNull(itemDTO.getDescription()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item code and item description are mandatory fields.");

        Item item = modelMapper.map(itemDTO, Item.class);

        item.setCreatedDate(LocalDateTime.now());

        try {
            itemRepository.save(item);
            return ResponseEntity.status(HttpStatus.CREATED).body("Item created.");

        } catch (HttpServerErrorException | HttpClientErrorException e){
            throw e;
        }
    }

    @Override
    public ResponseEntity<String> updateItem(ItemDTO itemDTO) {

        if(Objects.isNull(itemDTO.getItemCode()) || Objects.isNull(itemDTO.getDescription()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item code and item description are mandatory fields.");

        Item item = modelMapper.map(itemDTO, Item.class);

        item.setCreatedDate(LocalDateTime.now());

            try {
                itemRepository.save(item);
                return ResponseEntity.status(HttpStatus.OK).body("Item updated");

            } catch (HttpServerErrorException | HttpClientErrorException e){
                throw e;
            }
    }

    @Override
    public ResponseEntity<ItemDTO> findItemById(Long id) {

        try {
            Item item = itemRepository.findById(id).orElse(null);

            if(Objects.isNull(item))
                return ResponseEntity.notFound().build();

            ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);

            return ResponseEntity.ok(itemDTO);

        } catch (HttpServerErrorException | HttpClientErrorException e){
            throw e;
        }
    }

    @Override
    public ResponseEntity<List<ItemDTO>> findAllItems() {

        try {
            List<Item> items =  itemRepository.findAll();

            if(items.isEmpty())
                return ResponseEntity.noContent().build();

            List<ItemDTO> itemsDTO = items
                    .stream()
                    .map(item -> modelMapper.map(item, ItemDTO.class))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(itemsDTO);

        } catch (HttpServerErrorException | HttpClientErrorException e){
            throw e;
        }
    }
}
