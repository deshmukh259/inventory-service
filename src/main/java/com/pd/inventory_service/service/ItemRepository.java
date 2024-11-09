package com.pd.inventory_service.service;

import com.pd.inventory_service.service.entity.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemDetails, Long> {
}
