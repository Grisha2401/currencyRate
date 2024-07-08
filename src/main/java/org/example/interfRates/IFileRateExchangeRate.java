package org.example.interfRates;

import org.example.model.CurrencyModel;

import java.util.Set;

public interface IFileRateExchangeRate {

    Set<CurrencyModel>loadRates();
}
