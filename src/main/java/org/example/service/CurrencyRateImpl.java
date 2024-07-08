package org.example.service;

import org.example.model.CurrencyModel;
import org.example.interfRates.ICurrencyRate;

import java.util.Set;

public class CurrencyRateImpl implements ICurrencyRate {
    @Override
    public double getRate(Set<CurrencyModel> rates, String targetCurrency) {
        CurrencyModel cur = rates.stream().filter(s -> s.getName().toLowerCase()
                        .equals(targetCurrency.toLowerCase())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown currency: " + targetCurrency));

        return cur.getPrice();
    }
}
