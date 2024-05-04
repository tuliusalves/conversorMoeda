package com.tulius.models;

import com.google.gson.annotations.SerializedName;

public class ConversionRates {
    @SerializedName("USD")
    private double USD;
    @SerializedName("BRL")
    private double BRL;
    @SerializedName("EUR")
    private double EUR;
    @SerializedName("JPY")
    private double JPY;
    @SerializedName("CNY")
    private double CNY;
    @SerializedName("CAD")
    private double CAD;

    public ConversionRates(){}

    public ConversionRates(double USD, double BRL, double EUR, double JPY, double CNY, double CAD) {
        this.USD = USD;
        this.BRL = BRL;
        this.EUR = EUR;
        this.JPY = JPY;
        this.CNY = CNY;
        this.CAD = CAD;
    }

    public double getUSD() {
        return USD;
    }

    public double getBRL() {
        return BRL;
    }

    public double getEUR() {
        return EUR;
    }

    public double getJPY() {
        return JPY;
    }

    public double getCNY() {
        return CNY;
    }

    public double getCAD() {
        return CAD;
    }

    @Override
    public String toString() {
        return
                "{USD=" + getUSD() +
                ", BRL=" + getBRL() +
                ", EUR=" + getEUR() +
                ", JPY=" + getJPY() +
                ", CNY=" + getCNY() +
                ", CAD=" + getCAD() +
                '}';
    }
}
