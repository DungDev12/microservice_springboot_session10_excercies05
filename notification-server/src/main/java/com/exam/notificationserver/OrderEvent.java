package com.exam.notificationserver;

public record OrderEvent(
        Long orderId,
        Long medicineId,
        int quantity
) {
}
