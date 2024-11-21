package com.pd.inventory_service.service;

import com.pd.inventory_service.dto.ItemDto;
import jakarta.transaction.Transactional;

import java.util.List;


public interface ItemService {
    List<ItemDto> getAllItems();

    @Transactional
    ItemDto save(ItemDto itemDto);

    ItemDto getItem(int id);

    String soldItem(ItemDto itemDto);

    List<ItemDto> getAvailableItems();

    ItemDto getAvailableItem(Long itemId);

    ItemDto getAvailableItem(String item);
}
