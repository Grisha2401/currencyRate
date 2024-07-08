package org.example;

import org.example.service.ConfigLoader;
import org.example.service.ConsoleIUserCurrencyInteraction;
import org.example.service.ConvectConverter;
import org.example.service.CurrencyRateImpl;
import org.example.service.FileExchangeRateImplement;

public class Main {
    public static void main(String[] args) {
        CurrencyConverterApp currencyConverterApp = new CurrencyConverterApp(
                new ConsoleIUserCurrencyInteraction(),
                new ConvectConverter(),
                new CurrencyRateImpl(),
                new FileExchangeRateImplement(new ConfigLoader()));

        currencyConverterApp.run();
    }

}