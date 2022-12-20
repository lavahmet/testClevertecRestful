package com.example.testclevertecrestful.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CheckResponseDTO {
    private int quantity;
    private String Description;
    private double price;
    private double total;
}
