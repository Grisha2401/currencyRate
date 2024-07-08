package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.CurrencyDto;
import org.example.model.CurrencyModel;
import org.example.interfRates.IFileRateExchangeRate;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class FileExchangeRateImplement implements IFileRateExchangeRate {
    private final ConfigLoader configLoader;
    private final ObjectMapper objectMapper = new ObjectMapper();


    public FileExchangeRateImplement(ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    @Override
    public Set<CurrencyModel> loadRates() {
        try {
            var currencyRate = objectMapper.readValue(new File(configLoader.getProperty("exchangeRatesFilePath")), CurrencyDto.class);
            return currencyRate.getRates();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать курсы валют из файла.", e);

        }
    }
}
