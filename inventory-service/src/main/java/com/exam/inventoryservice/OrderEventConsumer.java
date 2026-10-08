package com.exam.inventoryservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventConsumer {

    private final MedicineService medicineService;

    @KafkaListener(
            topics = "medicine-stock-events",
            groupId = "inventory-service-group"
    )
    public void consume(OrderEvent orderEvent) {
        medicineService.updateMedicine(orderEvent.orderId(),orderEvent.quantity());
    }
}
