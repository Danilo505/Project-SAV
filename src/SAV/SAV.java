package SAV;


import algorithm.BubbleSort;
import algorithm.MergeSort;
import algorithm.QuickSort;
import dataProcessing.DataProcessing;

public class SAV {

    private DataProcessing dataProcessing;

    public SAV(DataProcessing dataProcessing) {
        this.dataProcessing = dataProcessing;
        start();
    }

    private void start(){
        switch (dataProcessing.getTypeOfAlgorithm()){
            case "b":
                System.out.println();
                System.out.println("Iniciando Bubble Sort");
                System.out.println();
                BubbleSort bubbleSort = new BubbleSort(dataProcessing);
                break;

            case "q":
                System.out.println();
                System.out.println("Iniciando Quick Sort");
                System.out.println();
                QuickSort quickSort = new QuickSort(dataProcessing);
                break;

            case "m":
                System.out.println();
                System.out.println("Iniciando Merge Sort");
                System.out.println();
                MergeSort mergeSort = new MergeSort(dataProcessing);
                break;
            default:
        }
    }
}
