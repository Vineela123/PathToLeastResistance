package codechallenge.com.pathtlr;

/**
 * Created by Vineela on 5/25/2016.
 */
public class Preconditions {

    public static int MAX_RESISTANCE=50;
    public static int NO_ROW=0;
    public static int NO_COLUMN=0;
    public static int Matrix[][];
public static  int totalResistanceT;
    public static int totalResistanceF;
    public static boolean validate_rowLimit(int inputRow){
        if(inputRow >= 1 && inputRow <= 10){
            Preconditions.NO_ROW=inputRow;
            return true;
        }
        else {return false;}
    }
    public static boolean validate_columnLimit(int inputColumn){
        if(inputColumn >= 5 && inputColumn <= 100){
            Preconditions.NO_COLUMN=inputColumn;
            return true;
        }
        else {return false;}
    }
}
