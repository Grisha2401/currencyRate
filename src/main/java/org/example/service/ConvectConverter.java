package org.example.service;

import org.example.interfRates.IConvectRate;

public class ConvectConverter implements IConvectRate {

    @Override
    public double convectRate(double rateIn, double rateUser) {
        return rateIn / rateUser;
    }
}
