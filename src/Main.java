import SAV.SAV;
import dataProcessing.DataProcessing;
import interfaces.ConsoleColors;
import validations.DataValidation;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String type = getParam(args,"t");
        String typeAlgorithm = getParam(args,"a");
        String valuesUser = getParam(args,"v");

        DataValidation dataValidation = new DataValidation(type, typeAlgorithm,valuesUser);

        boolean test = dataValidation.isSuccess();

        if (test){
            DataProcessing dataProcessing = new DataProcessing(type,typeAlgorithm);
            if (Objects.equals(dataProcessing.getType(), "c")){
                dataProcessing.valuesChar(valuesUser);
            }else{
                dataProcessing.valuesInt(valuesUser);
            }
            SAV sav = new SAV(dataProcessing);
        }

    }
    public static String getParam(String[] args, String field) {
        for (String param : args) {
            String[] keyAndValue = param.split("=");
            if (keyAndValue[0].equals(field)) {
                return keyAndValue[1];
            }
        }

        throw new RuntimeException(ConsoleColors.RED_BOLD + "Invalid param provided");
    }
}
