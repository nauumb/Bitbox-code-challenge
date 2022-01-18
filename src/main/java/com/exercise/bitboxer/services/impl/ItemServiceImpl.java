package com.exercise.bitboxer.services.impl;

import com.exercise.bitboxer.dto.ItemDTO;
import com.exercise.bitboxer.model.Item;
import com.exercise.bitboxer.repositories.ItemRepository;
import com.exercise.bitboxer.services.ItemService;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ItemServiceImpl (ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void insertItem(ItemDTO itemDTO)  throws DataIntegrityViolationException {

        if(Objects.isNull(itemDTO.getItemCode()) || Objects.isNull(itemDTO.getDescription())) {
            throw new DataIntegrityViolationException("Item code and item description are mandatory fields.");
        }

        Item item = modelMapper.map(itemDTO, Item.class);

        try {
            itemRepository.save(item);
        } catch (HttpServerErrorException | HttpClientErrorException e){
            throw e;
        }
    }

    @Override
    public void updateItem(ItemDTO itemDTO)  throws DataIntegrityViolationException {

        if(itemDTO.getDescription() == null) {
            throw new DataIntegrityViolationException("Description was not provided.");
        }

        Item item = modelMapper.map(itemDTO, Item.class);

        try {
            itemRepository.save(item);

        } catch (HttpServerErrorException | HttpClientErrorException e){
            throw e;
        }
    }

    @Override
    public ItemDTO findItemById(Long id) throws ObjectNotFoundException {

        try {

            Item item = itemRepository.findById(id).orElse(null);

            if(Objects.isNull(item)) {
                throw new ObjectNotFoundException(ItemDTO.class, "Item with identifier" + id + "was not found.");
            }

            return modelMapper.map(item, ItemDTO.class);

        } catch (HttpServerErrorException | HttpClientErrorException e){
            throw e;
        }
    }

    @Override
    public List<ItemDTO> findAllItems() throws ObjectNotFoundException {

        try {
            List<Item> items =  itemRepository.findAll();

            if(items.isEmpty()) {
                throw new ObjectNotFoundException(ItemDTO.class, "No items was found.");
            }

            return items
                    .stream()
                    .map(item -> modelMapper.map(item, ItemDTO.class))
                    .collect(Collectors.toList());

        } catch (HttpServerErrorException | HttpClientErrorException e){
            throw e;
        }
    }
}