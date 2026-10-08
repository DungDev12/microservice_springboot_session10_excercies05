package com.exam.inventoryservice;

public record OrderEvent(
         Long orderId,
         Long medicineId,
         int quantity
) {
}
