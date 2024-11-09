package com.pd.inventory_service.service;

import com.pd.inventory_service.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAllItems();

    ItemDto save(ItemDto itemDto);
}
