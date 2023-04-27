package com.acolque.apitest.config;

import com.acolque.apitest.services.FactorialCalculator;
import com.acolque.apitest.services.RecursiveFactorialCalculator;
import com.acolque.apitest.services.StandardFactorialCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FactorialConfig {

    public static final String STANDARD_FACTORIAL = "STANDARD_FACTORIAL";
    public static final String RECURSIVE_FACTORIAL = "RECURSIVE_FACTORIAL";

    @Bean(STANDARD_FACTORIAL)
    @Primary
    public FactorialCalculator getFactorialCalculator() {
        return new StandardFactorialCalculator();
    }

    @Bean(RECURSIVE_FACTORIAL)
    public FactorialCalculator getRecursiveFactorialCalculator() {
        return new RecursiveFactorialCalculator();
    }
}
