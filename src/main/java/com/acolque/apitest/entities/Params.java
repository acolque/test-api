package com.acolque.apitest.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Params {
    private int number;
    private int another;
}
