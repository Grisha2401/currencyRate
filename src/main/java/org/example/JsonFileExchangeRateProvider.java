package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonFileExchangeRateProvider  {
    ObjectMapper objectMapper = new ObjectMapper();
    List<CurrencyModel> rate = loadRatesFromFile("/Users/alfa/IdeaProjects/currencyRate/src/main/resources/exchange_rates.json");

    public List<CurrencyModel> loadRatesFromFile(String filePath) {
        try {
            var currencyRate = objectMapper.readValue(new File(filePath), CurrencyDto.class);
            return currencyRate.getRates();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать курсы валют из файла.", e);

        }
    }

    public double getRate(String targetCurrency) {
        CurrencyModel cur = rate.stream().filter(s -> s.getName().toLowerCase()
                        .equals(targetCurrency.toLowerCase())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown currency: " + targetCurrency));

        return cur.getPrice();
    }

}
