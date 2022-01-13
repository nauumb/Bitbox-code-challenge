package com.exercise.bitboxer.services;

import com.exercise.bitboxer.entities.Item;
import com.exercise.bitboxer.repositories.ItemRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ItemServiceImplTest {

    private ItemService itemService;

    @MockBean
    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImplTest(ItemService itemService){
        this.itemService = itemService;
    }

    @Test
    public void insertarItemTesKO1() {
        Item item = new Item();

        when(itemRepository.save(Mockito.any(Item.class))).thenThrow(HttpServerErrorException.class);

        assertThrows(HttpServerErrorException.class, ()->{
            itemService.insertItem(item);
        });
    }
    @Test
    public void insertarItemTesKO2() {
        Item item = new Item();

        when(itemRepository.save(Mockito.any(Item.class))).thenThrow(HttpClientErrorException.class);

        assertThrows(HttpClientErrorException.class, ()->{
            itemService.insertItem(item);
        });
    }
}
