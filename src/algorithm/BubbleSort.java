package algorithm;


import dataProcessing.DataProcessing;
import interfaces.Algorithm;
import interfaces.ConsoleColors;
import printer.Printer;

import java.util.Arrays;
import java.util.Objects;


public class BubbleSort implements Algorithm {

    private DataProcessing dataProcessing;
    private Printer printer;

    public BubbleSort(DataProcessing dataProcessing) {
        this.dataProcessing = dataProcessing;
        if (Objects.equals(dataProcessing.getType(), "c")){
            orderString();
        }else{
            order();
        }
    }
    @Override
    public void order() {
        int[] values = dataProcessing.getValuesInt();
        int[] valuesAnterior = new int[values.length];
        int size = values.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size-i-1; j++) {
                int number1 = values[j];
                int number2 = values[j +1];
                if (number1 > number2){
                    values[j] = number2;
                    values[j + 1] = number1;
                }
            }
            if (Arrays.equals(valuesAnterior, values)){
                break;
            }else{
                for (int j = 0; j < values.length; j++) {
                    valuesAnterior[j] = values[j];
                }
            }

            System.out.println(ConsoleColors.GREEN_BOLD + "------------- Passo "+(i+1)+ " -------------");
            printer = new Printer(values);
            System.out.println(ConsoleColors.YELLOW_BOLD + "\n------------------------------------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void orderString() {
        char[] values = dataProcessing.getValuesChar();
        char[] valuesAnterior = new char[values.length];
        int size = values.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size-i-1; j++) {
                char number1 = values[j];
                char number2 = values[j +1];
                if (number1 > number2){
                    values[j] = number2;
                    values[j + 1] = number1;
                }
            }
            if (Arrays.equals(valuesAnterior, values)){
                break;
            }else{
                for (int j = 0; j < values.length; j++) {
                    valuesAnterior[j] = values[j];
                }
            }
            System.out.println(ConsoleColors.GREEN_BOLD + "------------- Passo "+(i+1)+ " -------------");
            printer = new Printer(values);
            System.out.println(ConsoleColors.YELLOW_BOLD + "------------------------------------");
            try {
                Thread.sleep(1000); // 1000 milissegundos = 1 segundo
            } catch (InterruptedException e) {
                // Tratamento de exceção (caso ocorra uma interrupção durante a pausa)
                e.printStackTrace();
            }
        }
    }
}
