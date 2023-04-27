package com.acolque.apitest.datasource.repositories;

import com.acolque.apitest.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {
}
