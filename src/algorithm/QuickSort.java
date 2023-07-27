package algorithm;

import dataProcessing.DataProcessing;
import interfaces.Algorithm;
import interfaces.ConsoleColors;
import printer.Printer;

import java.util.Arrays;
import java.util.Objects;

public class QuickSort implements Algorithm {
    private Printer printer;
    private int passo = 2;
    private DataProcessing dataProcessing;

    public QuickSort(DataProcessing dataProcessing) {
        this.dataProcessing = dataProcessing;
        if (Objects.equals(dataProcessing.getType(), "c")){
            System.out.println(ConsoleColors.GREEN_BOLD + "------------- Passo "+(1)+ " -------------");
            printer = new Printer(dataProcessing.getValuesChar());
            System.out.println(ConsoleColors.YELLOW_BOLD + "------------------------------------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orderString();
        }else{
            System.out.println(ConsoleColors.GREEN_BOLD + "------------- Passo "+(1)+ " -------------");
            printer = new Printer(dataProcessing.getValuesInt());
            System.out.println(ConsoleColors.YELLOW_BOLD + "------------------------------------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            order();
        }
    }

    @Override
    public void order() {
        int[] values = dataProcessing.getValuesInt();
        int low = 0;
        int high = values.length-1;
        quickSort(values, low,high);

    }
    private void quickSort(int[] array, int low, int high){
        if (low < high){
            int pivot = array[high];

            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if(array[j] <= pivot){
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;

            quickSort(array, low,i);
            quickSort(array, i+ 2, high);
            System.out.println(ConsoleColors.GREEN_BOLD + "------------- Passo "+(passo)+ " -------------");
            printer = new Printer(array);
            System.out.println(ConsoleColors.YELLOW_BOLD+"------------------------------------");
            passo+=1;
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
        int low = 0;
        int high = values.length-1;
        quickSort(values, low,high);
    }
    private void quickSort(char[] array, int low, int high){
        if (low < high){
            int pivot = array[high];

            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if(array[j] <= pivot){
                    i++;
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            char temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;

            quickSort(array, low,i);
            quickSort(array, i+ 2, high);
            System.out.println(ConsoleColors.GREEN_BOLD + "------------- Passo "+(passo)+ " -------------");
            printer = new Printer(array);
            System.out.println(ConsoleColors.YELLOW_BOLD + "------------------------------------");
            passo+=1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
