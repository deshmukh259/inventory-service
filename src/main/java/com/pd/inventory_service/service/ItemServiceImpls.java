package com.pd.inventory_service.service;


import com.pd.inventory_service.dto.ItemDto;
import com.pd.inventory_service.service.entity.ItemDetails;
import com.pd.inventory_service.service.entity.ItemStatus;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemServiceImpls implements ItemService {


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ItemDto> getAllItems() {
        List<ItemDetails> all = itemRepository.findAll();
        return convertToDtoList(all);

    }

    @Override
    public ItemDto save(ItemDto itemDto) {

        ItemDetails itemDetails = modelMapper.map(itemDto, ItemDetails.class);
        itemDetails.setStatus(ItemStatus.ENABLED);
        return modelMapper.map(itemRepository.save(itemDetails), ItemDto.class);
    }

    private List<ItemDto> convertToDtoList(List<ItemDetails> itemDetails) {

        return itemDetails.stream().map(e -> modelMapper.map(e, ItemDto.class)).collect(Collectors.toList());

    }
}
