package com.acolque.apitest.datasource;

import com.acolque.apitest.entities.Prices;
import com.acolque.apitest.entities.CoinDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class CryptoPriceCoinGeckoApi implements CryptoPriceDataSource {

    private final RestTemplate restTemplate;

    public CryptoPriceCoinGeckoApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Cacheable("prices")
    public List<Prices> getPrices() {
        System.out.println("Consumiendo la api de gecko");
        try {
            Map<String, CoinDto> res = restTemplate.exchange(
                    "https://api.coingecko.com/api/v3/simple/price?ids={ids}&vs_currencies={currencies}&precision={precision}",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Map<String, CoinDto>>() {},
                    "bitcoin,ethereum", "usd", "full").getBody();

            return Objects.nonNull(res) ?
                    res.entrySet().stream()
                    .map(e -> Prices.builder().name(e.getKey()).price(e.getValue().usd()).build())
                    .toList()
                    : Collections.emptyList();
        } catch (RestClientException ex) {
            throw new RestClientException("Error en la Api de CoinGecko: " + ex.getMessage(), ex);
        }
    }

    @CacheEvict(value = "prices", allEntries = true)
    @Scheduled(fixedRateString = "${caching.spring.ttl}")
    public void emptyPrices() {
        System.out.println("limpiando cache");
    }
}
