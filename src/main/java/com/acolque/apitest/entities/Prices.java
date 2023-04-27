package com.acolque.apitest.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Entity
public class Prices {
    private String name;
    private Double price;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
