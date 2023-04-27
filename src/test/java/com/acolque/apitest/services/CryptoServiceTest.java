package com.acolque.apitest.services;

import com.acolque.apitest.datasource.CryptoPriceDataSource;
import com.acolque.apitest.entities.Prices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CryptoServiceTest {

    @Mock
    private CryptoPriceDataSource cryptoPriceDataSource;

    @InjectMocks
    private CryptoService service;

    private final List<Prices> prices = List.of(
            Prices.builder().name("bitcoin").price(30000D).build(),
            Prices.builder().name("ethereum").price(2000D).build());

    @Test
    public void testGetPricesSuccess(){
        when(cryptoPriceDataSource.getPrices()).thenReturn(prices);

        List<Prices> result = service.getPrices();

        assertEquals(2, result.size());
        assertEquals(prices, result);
    }
}
