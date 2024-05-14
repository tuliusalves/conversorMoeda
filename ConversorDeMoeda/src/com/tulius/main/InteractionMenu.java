package com.tulius.main;

import java.util.InputMismatchException;

public class InteractionMenu {

    public void currentCoin(int coin) {
        coin = coin;
        String currentCoin = """
                Digite um dos números para selecionar a moeda atual ou encerrar o programa
                1 => (USD) Dolar Americano
                2 => (BRL) Real Brasileiro
                3 => (EUR) Euro
                4=>  (JPY) Iene Japonês
                5=>  (CNY) Yuan chinês 
                6=>  (CAD) Dolar Canadense
                7=>  Parar o programa
                """;
        System.out.println(currentCoin);

    }

    public void optionConvertion() {
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
        System.out.println(optionConvertion);
    }
}
