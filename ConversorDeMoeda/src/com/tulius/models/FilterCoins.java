package com.tulius.models;

public class FilterCoins {
    ConversionRates conversionRates = new ConversionRates();
    Conversor conversor = new Conversor();


    public String typeCoin(int coin){
       if(coin==1){
           return "USD";
       }else if (coin==2) {
            return "BRL";
        } else if (coin==3) {
           return "EUR";
       } else if (coin==4) {
           return "JPY";
       } else if (coin==5) {
           return "CNY";
       } else if (coin==6) {
            return "CAD";
       }else {
           return "";
       }

    }
    /*
    public double returnToCoinConversor (int coin){
        if(coin==1){
            return conversionRates.getUSD();
        }else if (coin==2) {
            return conversionRates.getBRL();
        } else if (coin==3) {
            return conversionRates.getEUR();
        } else if (coin==4) {
            return conversionRates.getJPY();
        } else if (coin==5) {
            return conversionRates.getCNY();
        } else if (coin==6) {
            return conversionRates.getCAD();
        }else {
            return 0;
        }*/

}
