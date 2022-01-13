package com.exercise.bitboxer.services.impl;

import com.exercise.bitboxer.entities.Item;
import com.exercise.bitboxer.services.ItemService;
import com.exercise.bitboxer.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public void insertItem(Item item) {

        try{
            itemRepository.save(item);
        } catch (HttpServerErrorException e){
            throw e;
        } catch(HttpClientErrorException e) {
            throw e;
        }

    }

}
