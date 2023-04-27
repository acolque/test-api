package com.acolque.apitest.services;

public class RecursiveFactorialCalculator implements FactorialCalculator {
    @Override
    public int factorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
