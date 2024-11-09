package com.pd.inventory_service;

import com.pd.inventory_service.dto.ItemDto;
import com.pd.inventory_service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {


    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/api/items")
    public List<ItemDto> getItems() {

        return itemService.getAllItems();

    }

    @PostMapping(value = "api/items")
    public ItemDto addItem(@RequestBody ItemDto itemDto){

        return itemService.save(itemDto);
    }
}
