package com.acolque.apitest.datasource;

import com.acolque.apitest.datasource.repositories.PricesRepository;
import com.acolque.apitest.entities.Prices;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CryptoPriceMySQL implements CryptoPriceDataSource {

    private PricesRepository pricesRepository;

    public CryptoPriceMySQL(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public List<Prices> getPrices() {
        return pricesRepository.findAll();
    }
}
