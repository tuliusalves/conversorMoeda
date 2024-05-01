package com.tulius.models;

import com.google.gson.annotations.SerializedName;
import com.tulius.records.ConversorMoeda;

public class Conversor {
    @SerializedName("documentation")
    private String documentation;
    @SerializedName("conversion_rates")
    private Object conversion;

    public Conversor(){}
    public Conversor(ConversorMoeda conversorMoeda){
        this.documentation = conversorMoeda.documentation();
    }

    public String getDocumentation() {
        return documentation;
    }

    public Object getConversion() {
        return conversion;
    }

    @Override
    public String toString() {
        return "{documentation='" + documentation + '\'' +
                " conversion_rates:"+ getConversion()+
                '}';
    }
}
