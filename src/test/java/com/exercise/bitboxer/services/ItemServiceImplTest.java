package com.exercise.bitboxer.services;

import com.exercise.bitboxer.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ItemServiceImplTest {

//    Revisar como usar de forma correcta Mockbean
    @MockBean
    private ItemRepository itemRepository;


    @Test
    public void findItemByIdTest(){

    }
}
