package com.acolque.apitest.datasource;

import com.acolque.apitest.entities.Prices;

import java.util.List;

public interface CryptoPriceDataSource {
    List<Prices> getPrices();
}
