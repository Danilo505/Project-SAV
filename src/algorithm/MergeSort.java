package algorithm;


import dataProcessing.DataProcessing;
import interfaces.Algorithm;
import interfaces.ConsoleColors;
import printer.Printer;

import java.util.Objects;

public class MergeSort implements Algorithm {
    private Printer printer;
    private DataProcessing dataProcessing;
    private int passo = 1;

    public MergeSort(DataProcessing dataProcessing) {
        this.dataProcessing = dataProcessing;
        if (Objects.equals(dataProcessing.getType(), "c")){
            orderString();
        }else{
            order();
        }
    }

    @Override
    public void order() {
        mergeSort(dataProcessing.getValuesInt());
    }
    private void mergeSort(int[] array){
        if (array.length > 1){
            int[] left = new int[array.length / 2];
            int[] right = new int[array.length - left.length];
            System.arraycopy(array,0,left,0,left.length);
            System.arraycopy(array,left.length,right,0,right.length);

            mergeSort(left);
            mergeSort(right);

            merge(left, right, array);
        }
    }

    private void merge(int[] left, int[] right, int[] array) {
        int indexL = 0;
        int indexR = 0;
        int indexA = 0;

        while (indexL < left.length && indexR < right.length){
            if (left[indexL] < right[indexR]){
                array[indexA] = left[indexL];
                indexL++;
            }else{
                array[indexA] = right[indexR];
                indexR++;
            }
            indexA++;
        }
        while (indexL < left.length){
            array[indexA] = left[indexL];
            indexL++;
            indexA++;
        }
        while (indexR < right.length){
            array[indexA] = right[indexR];
            indexR++;
            indexA++;
        }
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

    @Override
    public void orderString() {
        mergeSort(dataProcessing.getValuesChar());
    }
    private void mergeSort(char[] array){
        if (array.length > 1){
            char[] left = new char[array.length / 2];
            char[] right = new char[array.length - left.length];
            System.arraycopy(array,0,left,0,left.length);
            System.arraycopy(array,left.length,right,0,right.length);

            mergeSort(left);
            mergeSort(right);

            merge(left, right, array);
        }
    }

    private void merge(char[] left, char[] right, char[] array) {
        int indexL = 0;
        int indexR = 0;
        int indexA = 0;

        while (indexL < left.length && indexR < right.length){
            if (left[indexL] < right[indexR]){
                array[indexA] = left[indexL];
                indexL++;
            }else{
                array[indexA] = right[indexR];
                indexR++;
            }
            indexA++;
        }
        while (indexL < left.length){
            array[indexA] = left[indexL];
            indexL++;
            indexA++;
        }
        while (indexR < right.length){
            array[indexA] = right[indexR];
            indexR++;
            indexA++;
        }
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

