package com.pd.inventory_service.service;


import com.pd.inventory_service.dto.ItemDto;
import com.pd.inventory_service.service.entity.ItemDetails;
import com.pd.inventory_service.service.entity.ItemStatus;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
        ItemDetails save = itemRepository.save(itemDetails);
        return modelMapper.map(save, ItemDto.class);
    }

    @Override
    public ItemDto getItem(int id) {
        ItemDetails itemDetails = itemRepository.findById((long) id).orElseThrow(() -> new RuntimeException("item not present"));
        return modelMapper.map(itemDetails, ItemDto.class);
    }

    @Override
    public String soldItem(ItemDto itemDto) {

        int soldQty = itemDto.getSoldQty();
        if (soldQty <= 0) {
            throw new RuntimeException("sold quantity should be greater than 0");
        }

        ItemDetails byId = itemRepository.findById(itemDto.getItemId())
                .orElseThrow(() -> new RuntimeException("item not present"));

        if (byId.getStatus().name().equals(ItemStatus.DISABLED.name()))
            throw new RuntimeException("this item not available!!");

        int soldQty1 = byId.getSoldQty();
        int totalQty = byId.getTotalQty();
        if (totalQty <= 0 || soldQty1 == totalQty)
            throw new RuntimeException("item already sold!!");

        if (totalQty < (soldQty1 + soldQty)) {
            throw new RuntimeException("cant sold more than available item!!");
        }
        soldQty1 += soldQty;
        byId.setSoldQty(soldQty1);

        itemRepository.save(byId);
        return "Item sold";
    }

    @Override
    public List<ItemDto> getAvailableItems() {
        return convertToDtoList(itemRepository.getAvailableItems());
    }

    @Override
    public ItemDto getAvailableItem(Long itemId) {
        return modelMapper.map(itemRepository.getAvailableItem(itemId), ItemDto.class);
    }

    @Override
    public ItemDto getAvailableItem(String item) {

        return modelMapper.map(itemRepository.getAvailableItemByName(item), ItemDto.class);
    }

    private List<ItemDto> convertToDtoList(List<ItemDetails> itemDetails) {

        return itemDetails.stream().map(e -> modelMapper.map(e, ItemDto.class)).collect(toList());

    }
}
