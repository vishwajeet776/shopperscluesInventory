package com.shopperscluesInventory.shopperscluesInventory.Repository;

import com.shopperscluesInventory.shopperscluesInventory.Entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, UUID> {
    List<Inventory> findByVendorId(Long vendorId);

    Inventory findByProductId(UUID productId);

}
