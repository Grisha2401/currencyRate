package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class JsonFileExchangeRateProvider {
    private final ConfigLoader configLoader ;
    ObjectMapper objectMapper = new ObjectMapper();

    public JsonFileExchangeRateProvider(ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    public Set<CurrencyModel> loadRatesFromFile() {
        try {
            var currencyRate = objectMapper.readValue(new File(configLoader.getProperty("exchangeRatesFilePath")), CurrencyDto.class);
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
