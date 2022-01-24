package com.exercise.bitboxer.services;

import com.exercise.bitboxer.model.Item;
import com.exercise.bitboxer.repositories.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.HttpServerErrorException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @MockBean
    private ItemRepository itemRepository;

    private AutoCloseable autoCloseable;

    @Autowired
    private ItemService itemService;

    @BeforeEach
    void setUp(){

        autoCloseable = MockitoAnnotations.openMocks(this);

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    @Disabled
    void insertItem() {
    }

    @Test
    @Disabled
    void updateItem() {
    }

    @Test
    public void canGetAnItemById() {

        when(itemRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(createMockItem()));

        assertDoesNotThrow(() ->{
           itemService.findItemById(1L);
        });

    }

    @Test
    public void canGetAnItemByIdKO() {

        when(itemRepository.findById(Mockito.anyLong())).thenThrow(HttpServerErrorException.class);

        assertThrows(HttpServerErrorException.class, () -> {
            itemService.findItemById(1L);
        });
    }

    @Test
    @Disabled
    public void canGetAllItems() {
        //when
        itemService.findAllItems();
        //then
        verify(itemRepository).findAll();
    }

    private Item createMockItem() {

        Item item = new Item();
        item.setId(1L);
        item.setItemCode(1L);
        item.setCreatedDate(LocalDateTime.now());
        item.setPrice(BigDecimal.ONE);

        return item;
    }
}