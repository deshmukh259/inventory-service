package com.pd.inventory_service.service;

import com.pd.inventory_service.service.entity.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemDetails, Long> {

    @Query("SELECT e FROM ItemDetails e WHERE e.soldQty < totalQty")
    List<ItemDetails> getAvailableItems();

    @Query("SELECT e FROM ItemDetails e WHERE e.id = :itemId  AND e.soldQty < e.totalQty")
    ItemDetails getAvailableItem(@Param("itemId") Long itemId);

    @Query("SELECT e FROM ItemDetails e WHERE e.itemName = :item  AND e.soldQty < e.totalQty")
    Object getAvailableItemByName(String item);
}
