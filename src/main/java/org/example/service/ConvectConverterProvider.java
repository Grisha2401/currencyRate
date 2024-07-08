package org.example.service;

import org.example.provider.ConvectRateProvider;

public class ConvectConverterProvider implements ConvectRateProvider {

    @Override
    public double convectRate(double rateIn, double rateUser) {
        return rateIn / rateUser;
    }
}
