package com.exam.pharmacyservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderEventProducer orderEventProducer;

    public String sellMedicine(
            SellMedicineRequest request
    ) {


        OrderEvent event = OrderEvent.builder()
                .orderId(request.orderId())
                .medicineId(request.medicineId())
                .quantity(request.quantity())
                .build();

        orderEventProducer.send(event);

        return "Thanh toán thành công";
    }
}