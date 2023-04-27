package com.acolque.apitest.controllers;

import com.acolque.apitest.entities.Params;
import com.acolque.apitest.entities.Res;
import com.acolque.apitest.services.FactorialCalculator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import static com.acolque.apitest.config.FactorialConfig.RECURSIVE_FACTORIAL;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    private final FactorialCalculator factorialCalculator;

    public CalculatorController(@Qualifier(RECURSIVE_FACTORIAL) FactorialCalculator factorialCalculator) {
        this.factorialCalculator = factorialCalculator;
    }

    @PostMapping("/sum")
    public Res sum(@RequestParam(required = true) int numberOne,
                   @RequestParam(required = true) int numberTwo) {
        int result = numberOne + numberTwo;
        return Res.builder()
                .response(Integer.toString(result))
                .build();
    }

    @PostMapping("/minus")
    public Res minus(@RequestBody Params params) {
        return Res.builder()
                .response(Integer.toString(params.getNumber() - params.getAnother()))
                .build();
    }

    @PostMapping("/divide")
    public Res divide(@RequestBody Params params) {
        int result = params.getNumber() / params.getAnother();
        return Res.builder()
                .response(Double.toString(result))
                .build();
    }

    @PostMapping("/factorial")
    public Res factorial(@RequestBody Params params) {
        return Res.builder()
                .response(Integer.toString(factorialCalculator.factorial(params.getNumber())))
                .build();
    }

}
