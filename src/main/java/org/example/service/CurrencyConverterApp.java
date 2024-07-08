package org.example.service;

import org.example.provider.ConvectRateProvider;
import org.example.provider.CurrencyRateProvider;
import org.example.provider.JsonFileRateExchangeRateProvider;
import org.example.provider.UserInteractionProvider;

public class CurrencyConverterApp {
    private final UserInteractionProvider userInteraction;
    private final ConvectRateProvider currencyConverter;
   private final CurrencyRateProvider currencyRateProvider;
   private final JsonFileRateExchangeRateProvider jsonFileRateExchangeRateProvider;
    public CurrencyConverterApp(UserInteractionProvider userInteraction, ConvectRateProvider currencyConverter, CurrencyRateProvider currencyRateProvider,
                                JsonFileRateExchangeRateProvider jsonFileRateExchangeRateProvider) {
        this.userInteraction = userInteraction;
        this.currencyConverter = currencyConverter;
        this.currencyRateProvider = currencyRateProvider;
        this.jsonFileRateExchangeRateProvider  =jsonFileRateExchangeRateProvider;
    }

    public void run() {
        while (true) {
            System.out.print("Введите сумму которую хотите поменять: ");

            var amount = userInteraction.askForAmount();

            System.out.print("Введиту валюту Например usd : ");

            var fromCurrency = userInteraction.askForCurrency();

            userInteraction.showResult(amount, fromCurrency, currencyConverter.convectRate(amount, currencyRateProvider.getRate(
                    jsonFileRateExchangeRateProvider.loadRates(),fromCurrency)));
        }
    }

}
