package dataProcessing;


public class DataProcessing {
    private String type;
    private String typeOfAlgorithm;
    private int[] valuesInt;
    private char[] valuesChar;


    public DataProcessing(String type, String typeOfAlgorithm) {
        this.type = type;
        this.typeOfAlgorithm = typeOfAlgorithm;
    }

    public void valuesChar(String values){
        String valuesFormated = values.replaceAll("\\s*,\\s*", "");
        valuesFormated = valuesFormated.replaceAll("\\s","");
        valuesChar = valuesFormated.toCharArray();
    }
    public void valuesInt(String values){
        String[] stringFormated = values.split(",");
        int[] valuesInt = new int[stringFormated.length];

        for (int i = 0; i < valuesInt.length; i++) {
            valuesInt[i] = Integer.parseInt(stringFormated[i]);
        }

        this.valuesInt = valuesInt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeOfAlgorithm() {
        return typeOfAlgorithm;
    }

    public void setTypeOfAlgorithm(String typeOfAlgorithm) {
        this.typeOfAlgorithm = typeOfAlgorithm;
    }

    public int[] getValuesInt() {
        return valuesInt;
    }

    public void setValuesInt(int[] valuesInt) {
        this.valuesInt = valuesInt;
    }

    public char[] getValuesChar() {
        return valuesChar;
    }

    public void setValuesChar(char[] valuesChar) {
        this.valuesChar = valuesChar;
    }
}