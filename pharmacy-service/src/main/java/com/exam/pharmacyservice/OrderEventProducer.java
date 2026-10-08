package com.exam.pharmacyservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventProducer {

    private static final String TOPIC = "medicine-stock-events";

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void send(OrderEvent event) {

        String key = event.getOrderId().toString();

        kafkaTemplate.sendDefault(
                event.getMedicineId().toString(),
                event
        ).whenComplete((result, exception) -> {

            if (exception != null) {
                log.error(
                        "Failed to send order event: {}",
                        event.getOrderId(),
                        exception
                );
                return;
            }

            var metadata = result.getRecordMetadata();

            log.info(
                    "Order event sent: topic={}, partition={}, offset={}",
                    metadata.topic(),
                    metadata.partition(),
                    metadata.offset()
            );
        });
    }
}