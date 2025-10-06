package com.shopperscluesInventory.shopperscluesInventory.Controller;

import com.shopperscluesInventory.shopperscluesInventory.Entity.Inventory;
import com.shopperscluesInventory.shopperscluesInventory.Service.InventoryService;

import com.shopperscluesInventory.shopperscluesInventory.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/list")
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @PostMapping("/add")
    public Inventory addInventory(@RequestParam String productId,
                                  @RequestParam String name,
                                  @RequestParam Long quantity,
                                  @RequestParam Long vendorId) {
        return inventoryService.addInventory(productId,name, quantity, vendorId);
    }

    @PutMapping("/update/{productId}")
    public Inventory updateQuantity(@PathVariable UUID productId,
                                    @RequestParam Long quantity) {
        return inventoryService.updateQuantityByProductId(productId, quantity);
    }

    @PutMapping("/update/vendor/{vendorId}")
    public List<Inventory> updateQuantityByVendor(@PathVariable Long vendorId,
                                                  @RequestParam Long quantity) {
        return inventoryService.updateQuantityByVendorId(vendorId, quantity);
    }
    @GetMapping("/check")
    public boolean checkAvailability(@RequestParam("productId") UUID productId,
                                     @RequestParam("qty") int qty) {
        return inventoryService.checkAvailability(productId, qty);
    }

    @GetMapping("/{productId}")
    public Inventory getInventoryByProductId(@PathVariable UUID productId) {
        return inventoryService.getInventoryByProductId(productId);
    }

    // ------------------- New Endpoints -------------------

    // Update inventory quantity by productId
    @PutMapping("/updateInventory")
    public Inventory updateInventory(@RequestParam UUID productId,
                                     @RequestParam Long quantity) {
        return inventoryService.updateQuantityByProductId(productId, quantity);
    }

    // Delete inventory by productId
    @DeleteMapping("/deleteInventory")
    public void deleteInventory(@RequestParam UUID productId) {
        inventoryService.deleteInventory(productId);
    }

}
