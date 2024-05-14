package com.tulius.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InteractionMenu {
    Scanner read = new Scanner(System.in);
    public int currentCoin() {
        int auxCoin=0;
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
        do {
            try {
                auxCoin = read.nextInt();
            } catch (InputMismatchException e) {
                read.nextLine();
                System.out.println("Por favor digite apenas números inteiros");
            }
        } while (auxCoin<1 || auxCoin >7);

        return auxCoin;
    }

    public int optionConvertion() {
        int auxCoin=0;
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
        do {
            try {
                auxCoin = read.nextInt();
            } catch (InputMismatchException e) {
                read.nextLine();
                System.out.println("Por favor digite apenas números inteiros");
            }
        } while (auxCoin<1 || auxCoin >7);

        return auxCoin;
    }
}
