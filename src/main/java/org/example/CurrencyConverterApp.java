package org.example;

import org.example.interfRates.IConvectRate;
import org.example.interfRates.ICurrencyRate;
import org.example.interfRates.IFileRateExchangeRate;
import org.example.interfRates.IUserCurrencyInteraction;

public class CurrencyConverterApp {
    private final IUserCurrencyInteraction userInteraction;
    private final IConvectRate currencyConverter;
    private final ICurrencyRate ICurrencyRate;
    private final IFileRateExchangeRate IFileRateExchangeRate;

    public CurrencyConverterApp(IUserCurrencyInteraction userInteraction, IConvectRate currencyConverter, ICurrencyRate ICurrencyRate,
                                IFileRateExchangeRate IFileRateExchangeRate) {
        this.userInteraction = userInteraction;
        this.currencyConverter = currencyConverter;
        this.ICurrencyRate = ICurrencyRate;
        this.IFileRateExchangeRate = IFileRateExchangeRate;
    }

    public void run() {
        while (true) {
            System.out.print("Введите сумму которую хотите поменять: ");

            var amount = userInteraction.askForAmount();

            System.out.print("Введиту валюту Например usd : ");

            var fromCurrency = userInteraction.askForCurrency();

            userInteraction.showResult(amount, fromCurrency, currencyConverter.convectRate(amount, ICurrencyRate.getRate(
                    IFileRateExchangeRate.loadRates(), fromCurrency)));
        }
    }

}
