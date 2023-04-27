package com.acolque.apitest.controllers;

import com.acolque.apitest.entities.Prices;
import com.acolque.apitest.services.CryptoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crypto")
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/coins")
    public List<Prices> getCoins() {
        return cryptoService.getPrices();
    }
}
