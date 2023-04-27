package com.acolque.apitest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Prices {
    private String name;
    private Double price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
