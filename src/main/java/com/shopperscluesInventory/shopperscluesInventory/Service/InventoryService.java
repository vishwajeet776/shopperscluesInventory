package com.shopperscluesInventory.shopperscluesInventory.Service;

import com.shopperscluesInventory.shopperscluesInventory.Entity.Inventory;
import com.shopperscluesInventory.shopperscluesInventory.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory addInventory(String pId,String name, Long quantity, Long vendorId) {
        Inventory inventory = Inventory.builder()
                .id(UUID.randomUUID())            // Mongo _id
                .productId(pId)     // separate productId
                .name(name)
                .quantity(quantity)
                .vendorId(vendorId)
                .lastUpdated(Instant.now())
                .build();
        return inventoryRepository.save(inventory);
    }

    public Inventory updateQuantityByProductId(String productId, Long quantity) {
        // use productId (not id)
        Inventory inventory = inventoryRepository.findByProductId(productId);
//                .orElseThrow(() -> new RuntimeException("Product not found with productId: " + productId));
        inventory.setQuantity(quantity);
        inventory.setLastUpdated(Instant.now());
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> updateQuantityByVendorId(Long vendorId, Long quantity) {
        List<Inventory> inventories = inventoryRepository.findByVendorId(vendorId);
        inventories.forEach(inv -> {
            inv.setQuantity(quantity);
            inv.setLastUpdated(Instant.now());
        });
        return inventoryRepository.saveAll(inventories);
    }

    // Check availability of a product
    public boolean checkAvailability(String productId, int qty) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
//                .orElseThrow(() -> new RuntimeException("Product not found in inventory"));
        return inventory.getQuantity() >= qty;
    }

    public Inventory getInventoryByProductId(String productId) {
        return inventoryRepository.findByProductId(productId);
//                .orElseThrow(() -> new RuntimeException("Product not found in inventory"));
    }

    public void deleteInventory(String productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        inventoryRepository.delete(inventory);
    }

}
