package org.example;

import org.example.service.ConfigLoader;
import org.example.service.ConsoleUserInteraction;
import org.example.service.ConvectConverterProvider;
import org.example.service.CurrencyConverterApp;
import org.example.service.CurrencyRateProviderImpl;
import org.example.service.JsonFileExchangeRateImplement;

public class Main {
    public static void main(String[] args) {
        CurrencyConverterApp currencyConverterApp = new CurrencyConverterApp(new ConsoleUserInteraction(),
                new ConvectConverterProvider(),
                new CurrencyRateProviderImpl()
                ,new JsonFileExchangeRateImplement(new ConfigLoader()));
        currencyConverterApp.run();
    }

}