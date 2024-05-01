import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.tulius.models.Conversor;
import com.tulius.records.ConversorMoeda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/059c5e45ced2397a6b06506b/latest/BRL"))
                .build();

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
            System.out.println("Após a conversão");
            System.out.println(conversor);
        }catch (JsonParseException e){
            System.err.println("Erro ao analisar JSON:"+e.getMessage());
        }
    }
}