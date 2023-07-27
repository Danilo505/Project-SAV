package printer;


public class Printer {

    public Printer(int[] values) {
        print(values);
    }

    public Printer(char[] values) {
        print(values);
    }

    public void print(int[] values) {
        int columns = higherNumber(values) + 1;
        int rows = values.length;
        int numberValues = 0;
        String[][] matriz = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            matriz[i][0] = "|" + values[i] + "| ";
            for (int j = 1; j < columns; j++) {
                if (j <= values[numberValues]) {
                    matriz[i][j] = " * ";
                } else {
                    matriz[i][j] = "   ";
                }
            }
            numberValues++;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }

    public void print(char[] valuesChar) {
        int rows = valuesChar.length;
        int columns = 0;

        for (char c : valuesChar) {
            int charValue = 0;
            if (c >= 65 && c <= 90) {
                charValue = c - 'A' + 1;
            } else if (c >= 97 && c <= 122) {
                charValue = c - 'a' + 1;
            }
            if (charValue > columns) {
                columns = charValue + 1;
            }
        }
        String[][] matriz = new String[rows][columns + 1];

        for (int i = 0; i < rows; i++) {
            matriz[i][0] = "|" + valuesChar[i] + "| ";
            int test = 0;
            if (valuesChar[i] >= 65 && valuesChar[i] <= 90) {
                test = valuesChar[i] - 'A' + 1;
            } else if (valuesChar[i] >= 97 && valuesChar[i] <= 122) {
                test = valuesChar[i] - 'a' + 1;
            }
            for (int j = 1; j < columns + 1; j++) {
                if (j <= test) {
                    matriz[i][j] = " * ";
                } else {
                    matriz[i][j] = "   ";
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns + 1; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }

    private int higherNumber(int[] values) {
        int higherNumber = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > higherNumber) {
                higherNumber = values[i];
            }
        }
        return higherNumber;
    }
}

