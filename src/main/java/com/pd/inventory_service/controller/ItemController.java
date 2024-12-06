package com.pd.inventory_service.controller;

import com.pd.inventory_service.dto.ItemDto;
import com.pd.inventory_service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
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

    @PostMapping(value = "/api/items")
    public ItemDto addItem(@RequestBody ItemDto itemDto) {

        return itemService.save(itemDto);
    }

    @PatchMapping(value = "/api/items/sold")
    public String soldItem(@RequestBody ItemDto itemDto) {

        return itemService.soldItem(itemDto);
    }

    @GetMapping(value = "/api/available-items")
    public List<ItemDto> getAvailableItems() {
        return itemService.getAvailableItems();
    }

    @GetMapping(value = "/api/available-items/{itemId}")
    public ItemDto getAvailableItem(@PathVariable Long itemId) {
        System.out.println(itemId);
        return itemService.getAvailableItem(itemId);
    }

    @GetMapping(value = "/api/available-items/name/{item}")
    public ItemDto getAvailableItem(@PathVariable String item) {
        return itemService.getAvailableItem(item);
    }
}
