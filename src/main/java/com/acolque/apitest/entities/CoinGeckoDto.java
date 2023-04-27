package com.acolque.apitest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CoinGeckoDto(CoinDto bitcoin, CoinDto ethereum) {}
