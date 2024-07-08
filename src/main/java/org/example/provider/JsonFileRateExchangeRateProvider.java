package org.example.provider;

import org.example.model.CurrencyModel;

import java.util.Set;

public interface JsonFileRateExchangeRateProvider {

    Set<CurrencyModel>loadRates();
}
