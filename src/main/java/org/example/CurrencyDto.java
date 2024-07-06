package org.example;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashSet;
import java.util.Set;

public class CurrencyDto {
    private Set<CurrencyModel> rates = new HashSet<>();

    @JsonAnySetter
    public void addRate(String name, double price) {
        rates.add(new CurrencyModel(name, price));
    }

    public Set<CurrencyModel> getRates() {
        return rates;
    }

    public void setRates(HashSet<CurrencyModel> rates) {
        this.rates = rates;
    }

    public Set<CurrencyModel> getListRate() {
        return rates;
    }
}
