import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.tulius.models.Conversor;
import com.tulius.models.FilterCoins;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        String curentReturnFilterCoins;
        int toConvertReturnFilterCoins;
        FilterCoins filterCoins = new FilterCoins();
        HttpRequest request;
        double valueConvert=0;


        int menuResponseInteraction=0;
        do {
            String currentCoin= """
                Selecione a sua moeda atual
                1 => (USD) Dolar Americano
                2 => (BRL) Real Brasileiro
                3 => (EUR) Euro
                4=>  (JPY) Iene Japonês
                5=>  (CNY) Yuan chinês 
                6=>  (CAD) Dolar Canadense
                7=>  Parar o programa
                """;
            System.out.println(currentCoin);
            menuResponseInteraction= read.nextInt();
            if (menuResponseInteraction==7){
                break;
            }
            System.out.println("---------------");
            String optionConvertion = """
                Selecione a moeda que deseja converter!
                1 => (USD) Dolar Americano
                2 => (BRL) Real Brasileiro
                3 => (EUR) Euro
                4=>  (JPY) Iene Japonês
                5=>  (CNY) Yuan chinês 
                6=>  (CAD) Dolar Canadense
                7=>  Parar o programa
                """;
            System.out.println(optionConvertion);
            toConvertReturnFilterCoins = read.nextInt();

            curentReturnFilterCoins =filterCoins.typeCoin(menuResponseInteraction);

            request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/059c5e45ced2397a6b06506b/latest/"
                            +curentReturnFilterCoins))
                    .build();

            System.out.println("Digite o valor que deseja converter");
            valueConvert = read.nextDouble();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
            String json= response.body();

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

    }
}