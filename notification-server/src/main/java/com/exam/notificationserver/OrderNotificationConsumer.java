package com.exam.notificationserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderNotificationConsumer {

    @KafkaListener(
            topics = "medicine-stock-events",
            groupId = "notification-service-group"
    )
    public void consume(OrderEvent event) {

        log.info(
                "Hóa đơn cho đơn hàng {} đã được gửi tới khách hàng",
                event.orderId()
        );
    }
}
