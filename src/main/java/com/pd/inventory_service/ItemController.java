package com.pd.inventory_service;

import com.pd.inventory_service.dto.ItemDto;
import com.pd.inventory_service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {


    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/api/items")
    public List<ItemDto> getItems() {

        return itemService.getAllItems();

    }

    @GetMapping(value = "/api/items/{id}")
    public ItemDto getItems(@PathVariable int id) {

        return itemService.getItem(id);

    }

    @PostMapping(value = "api/items")
    public ItemDto addItem(@RequestBody ItemDto itemDto) {

        return itemService.save(itemDto);
    }

    @PatchMapping(value = "api/items/sold")
    public String soldItem(@RequestBody ItemDto itemDto) {

        return itemService.soldItem(itemDto);
    }
}
