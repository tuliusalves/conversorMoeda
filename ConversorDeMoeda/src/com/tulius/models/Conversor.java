package com.tulius.models;

import com.google.gson.annotations.SerializedName;
import com.tulius.records.ConversorMoeda;

public class Conversor extends ConversionRates{
    @SerializedName("documentation")
    private String documentation;
    @SerializedName("conversion_rates")
    private ConversionRates conversionRates;


    public Conversor(){}
    public Conversor(ConversorMoeda conversorMoeda){
        this.documentation = conversorMoeda.documentation();
    }

    public String getDocumentation() {
        return documentation;
    }

    public ConversionRates getConversionRates() {

        return conversionRates;
    }

    public double returnToCoinConversor (int coin) {
        if (coin == 1) {
            return conversionRates.getUSD();
        } else if (coin == 2) {
            return conversionRates.getBRL();
        } else if (coin == 3) {
            return conversionRates.getEUR();
        } else if (coin == 4) {
            return conversionRates.getJPY();
        } else if (coin == 5) {
            return conversionRates.getCNY();
        } else if (coin == 6) {
            return conversionRates.getCAD();
        } else {
            return 0;
        }
    }


    @Override
    public String toString() {
        return "{documentation='" + documentation + '\'' +
                " conversion_rates:"+ getConversionRates()+
                '}';
    }

}
