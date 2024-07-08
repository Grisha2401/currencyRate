package org.example.interfRates;

import org.example.model.CurrencyModel;

import java.util.Set;

public interface ICurrencyRate {

    double getRate(Set<CurrencyModel> rates,String targetCurrency);

}
