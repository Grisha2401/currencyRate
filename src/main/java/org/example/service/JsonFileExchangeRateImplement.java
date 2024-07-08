package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.CurrencyDto;
import org.example.model.CurrencyModel;
import org.example.provider.JsonFileRateExchangeRateProvider;
import org.example.service.ConfigLoader;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class JsonFileExchangeRateImplement implements JsonFileRateExchangeRateProvider {
    private final ConfigLoader configLoader ;
    ObjectMapper objectMapper = new ObjectMapper();


    public JsonFileExchangeRateImplement(ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    @Override
    public Set<CurrencyModel> loadRates() {
        try {
            var currencyRate = objectMapper.readValue(new File(configLoader.getProperty("exchangeRatesFilePath")), CurrencyDto.class);
            return currencyRate.getRates();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать курсы валют из файла.", e);

        }    }
}
