package com.pd.inventory_service.service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_details")
public class ItemDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String itemName;
    private int totalQty;
    private int soldQty;
    private int price;
    private String supplierDesc;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;
}
