package com.acolque.apitest.config;

import com.acolque.apitest.datasource.CryptoPriceCoinGeckoApi;
import com.acolque.apitest.datasource.CryptoPriceDataSource;
import com.acolque.apitest.datasource.CryptoPriceMongoDB;
import com.acolque.apitest.datasource.CryptoPriceMySQL;
import com.acolque.apitest.datasource.repositories.PricesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CryptoPriceDataSourceConfig {

    public static final String CRYPTO_PRICE_API_SOURCE = "CRYPTO_PRICE_API_SOURCE";
    public static final String CRYPTO_PRICE_MONGO_DB_SOURCE = "CRYPTO_PRICE_MONGO_DB_SOURCE";
    public static final String CRYPTO_PRICE_MY_SQL_SOURCE = "CRYPTO_PRICE_MY_SQL_SOURCE";

    @Bean(CRYPTO_PRICE_API_SOURCE)
    public CryptoPriceDataSource getCryptoPriceApiSource(RestTemplate restTemplate) {
        return new CryptoPriceCoinGeckoApi(restTemplate);
    }

//    @Bean(CRYPTO_PRICE_MONGO_DB_SOURCE)
//    public CryptoPriceDataSource getCryptoPriceMongoDBSource() {
//        return new CryptoPriceMongoDB();
//    }
//
//    @Bean(CRYPTO_PRICE_MY_SQL_SOURCE)
//    public CryptoPriceDataSource getCryptoPriceMySqlSource(PricesRepository pricesRepository) {
//        return new CryptoPriceMySQL(pricesRepository);
//    }
}
