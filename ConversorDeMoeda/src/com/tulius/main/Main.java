package com.tulius.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.tulius.models.Conversor;
import com.tulius.models.FilterCoins;
import com.tulius.service.API_Consumption;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        API_Consumption api_consumption = new API_Consumption();
        InteractionMenu interaction = new InteractionMenu();
        FilterCoins filterCoins = new FilterCoins();

        String curentReturnFilterCoins;
        int toConvertReturnFilterCoins;
        double valueConvert=0;

        int menuResponseInteraction=0;

        do {

            menuResponseInteraction =interaction.currentCoin();

            if (menuResponseInteraction==7){
                break;
            }

            toConvertReturnFilterCoins = interaction.optionConvertion();

            curentReturnFilterCoins =filterCoins.typeCoin(menuResponseInteraction);


            valueConvert = interaction.valueConvert();

            String json= api_consumption.getData(curentReturnFilterCoins);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            System.out.println("\n ------------");


            try {
                Conversor conversor= gson.fromJson(json,Conversor.class);

                System.out.println("Moeda atual:"+curentReturnFilterCoins);
                System.out.println("Moeda que deseja converter: "+
                        filterCoins.typeCoin(toConvertReturnFilterCoins));
                System.out.printf("Valor a ser convertido %s %.2f \n",interaction.stringCoin(menuResponseInteraction),
                        valueConvert);
                System.out.printf("Valor após a conversão %s %.2f \n",
                        interaction.stringCoin(toConvertReturnFilterCoins),
                        conversor.
                        returnToCoinConversor(toConvertReturnFilterCoins)*valueConvert);
                System.out.println("------------------------------");
            }catch (JsonParseException e){
                System.err.println("Erro ao analisar JSON:"+e.getMessage());
            }

        }while (menuResponseInteraction<7);

    }
}