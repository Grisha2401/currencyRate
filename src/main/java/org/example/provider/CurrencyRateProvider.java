package org.example.provider;

import org.example.model.CurrencyModel;

import java.util.Set;

public interface CurrencyRateProvider {

    double getRate(Set<CurrencyModel> rates,String targetCurrency);

}
