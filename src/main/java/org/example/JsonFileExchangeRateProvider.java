package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class JsonFileExchangeRateProvider {
    ObjectMapper objectMapper = new ObjectMapper();

    public Set<CurrencyModel> loadRatesFromFile() {
        try {
            var currencyRate = objectMapper.readValue(new File("/Users/alfa/IdeaProjects/currencyRate/src/main/resources/exchange_rates.json"), CurrencyDto.class);
            return currencyRate.getRates();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать курсы валют из файла.", e);

        }
    }

    public double getRate(String targetCurrency) {
        CurrencyModel cur = loadRatesFromFile().stream().filter(s -> s.getName().toLowerCase()
                        .equals(targetCurrency.toLowerCase())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown currency: " + targetCurrency));

        return cur.getPrice();
    }

}
