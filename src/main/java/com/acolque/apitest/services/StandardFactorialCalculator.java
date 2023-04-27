package com.acolque.apitest.services;

public class StandardFactorialCalculator implements FactorialCalculator {
    @Override
    public int factorial(int number) {
        int resultado = 1;
        for (int i = 1; i <= number; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
