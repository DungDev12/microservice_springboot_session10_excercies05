package com.exam.inventoryservice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepository medicineRepository;

    @Transactional
    public void updateMedicine(Long id, int quantity){
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow();

        medicine.setStock(medicine.getStock() - quantity);

        medicineRepository.save(medicine);
    }
}
