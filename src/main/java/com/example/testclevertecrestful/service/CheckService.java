package com.example.testclevertecrestful.service;

import com.example.testclevertecrestful.dto.CheckRequestDTO;
import com.example.testclevertecrestful.entity.Item;
import com.example.testclevertecrestful.exception.ItemNotFoundException;
import com.example.testclevertecrestful.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class CheckService {
    private final ItemRepository itemRepository;

    @Autowired
    public CheckService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public String getCheck(List<CheckRequestDTO> checkRequestDTOS) {
        StringBuilder receipt = new StringBuilder("                    CASH RECEIPT                   \n\n" +
                String.format("%-5s %s %15s %12s\n", "QTY", "DESCRIPTION", "PRICE", "TOTAL") +
                String.format("%-5s %s %15s %12s\n", "----", "-----------", "-----", "-----"));
        double total = 0;
        for (CheckRequestDTO requestDTO : checkRequestDTOS) {
            Item item = itemRepository.findById(requestDTO.getId())
                    .orElseThrow(() -> new ItemNotFoundException("Товара с id: " + requestDTO.getId() + " или файла не существует"));
            total = item.getPrice() * requestDTO.getQuantity();
            receipt.append(String.format("\n%-5s %-21s %s %-10s %s %s", requestDTO.getQuantity(), item.getDescription(), "$", new DecimalFormat(".##")
                    .format(item.getPrice()), "$", total));
        }
        total += total;
        receipt.append("\n\n-----------------------------------------------------");
        receipt.append(String.format("%-42s %s %s", "\n\nTOTAL", "$", total));
        return receipt.toString();
    }
}
