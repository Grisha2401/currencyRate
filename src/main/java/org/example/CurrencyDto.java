package org.example;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDto {
    private List<CurrencyModel> rates = new ArrayList<>();

    @JsonAnySetter
    public void addRate(String name, double price) {
        rates.add(new CurrencyModel(name, price));
    }

    public List<CurrencyModel> getRates() {
        return rates;
    }

    public void setRates(List<CurrencyModel> rates) {
        this.rates = rates;
    }

    public List getListRate(){
        return rates;
    }
}
