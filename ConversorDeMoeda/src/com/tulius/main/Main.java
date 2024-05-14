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
            /*
            String currentCoin= """
                Digite um dos números para selecionar a moeda atual ou encerrar o programa
                1 => (USD) Dolar Americano
                2 => (BRL) Real Brasileiro
                3 => (EUR) Euro
                4=>  (JPY) Iene Japonês
                5=>  (CNY) Yuan chinês 
                6=>  (CAD) Dolar Canadense
                7=>  Parar o programa
                """;
            System.out.println(currentCoin);*/
            interaction.currentCoin(menuResponseInteraction);

            menuResponseInteraction= read.nextInt();
            if (menuResponseInteraction==7){
                break;
            }
            /*
            System.out.println("---------------");
            String optionConvertion = """
                Digite um dos números para selecionar qual moeda você deseja converter!
                1 => (USD) Dolar Americano
                2 => (BRL) Real Brasileiro
                3 => (EUR) Euro
                4=>  (JPY) Iene Japonês
                5=>  (CNY) Yuan chinês 
                6=>  (CAD) Dolar Canadense
                7=>  Parar o programa
                """;
            System.out.println(optionConvertion);*/
            interaction.optionConvertion();
            toConvertReturnFilterCoins = read.nextInt();

            curentReturnFilterCoins =filterCoins.typeCoin(menuResponseInteraction);

            System.out.println("Digite o valor que deseja converter");
            valueConvert = read.nextDouble();

            String json= api_consumption.getData(curentReturnFilterCoins);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            System.out.println("\n ------------");


            try {
            /*
            ConversorMoeda conversorMoeda = gson.fromJson(json, ConversorMoeda.class);
            System.out.println("baseCode da moeda: " + conversorMoeda);
            */
                Conversor conversor= gson.fromJson(json,Conversor.class);
                /*
                System.out.println("Após a conversão");
                System.out.println(conversor.getConversionRates().getBRL()*100);
                */
                System.out.println("Moeda atual:"+curentReturnFilterCoins);
                System.out.println("Moeda que deseja converter:"+filterCoins.typeCoin(toConvertReturnFilterCoins));
                System.out.println("Valor a ser convertido:"+valueConvert);
                System.out.println("Valor após a conversão:"+conversor.
                        returnToCoinConversor(toConvertReturnFilterCoins)*valueConvert);
            }catch (JsonParseException e){
                System.err.println("Erro ao analisar JSON:"+e.getMessage());
            }

        }while (menuResponseInteraction<7);

        /*Preciso separar as responsabilidades, criando classes para cada coisa.
        * Criar uma classe contendo os menus*/

    }
}