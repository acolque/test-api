package com.acolque.apitest.services;

import com.acolque.apitest.datasource.CryptoPriceDataSource;
import com.acolque.apitest.entities.Prices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.acolque.apitest.config.CryptoPriceDataSourceConfig.*;

@Service
public class CryptoService {
    private final CryptoPriceDataSource cryptoPriceDataSource;

    public CryptoService(@Qualifier(CRYPTO_PRICE_API_SOURCE) CryptoPriceDataSource cryptoPriceDataSource) {
        this.cryptoPriceDataSource = cryptoPriceDataSource;
    }

    public List<Prices> getPrices() {
        return this.cryptoPriceDataSource.getPrices();
    }
}
