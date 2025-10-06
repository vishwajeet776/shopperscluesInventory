package com.shopperscluesInventory.shopperscluesInventory.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Document(collection = "inventory")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    private UUID id;           // MongoDB _id

//    private UUID productId;    // business product ID
    private String productId; // instead of UUID

    private String name;
    private Long quantity;
    private Long vendorId;
    private Instant lastUpdated;


}
