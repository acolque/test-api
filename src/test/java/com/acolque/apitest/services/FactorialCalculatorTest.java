package com.acolque.apitest.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FactorialCalculatorTest {

    @Autowired
    private FactorialCalculator calculator;

    @Test
    public void testCalculateFactorial() {
        int number = 3;

        int result = calculator.factorial(number);

        assertEquals(6, result);
    }
}
