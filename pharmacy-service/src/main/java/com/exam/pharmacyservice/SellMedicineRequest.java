package com.exam.pharmacyservice;

public record SellMedicineRequest(
        Long orderId,
        Long medicineId,
        int quantity
) {
}
