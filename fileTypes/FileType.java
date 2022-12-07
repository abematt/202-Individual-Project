package fileTypes;
import java.util.ArrayList;

import creditCard.*;

abstract public class FileType {

    public abstract ArrayList<CreditCard> readFromFile(String inputPath);

    public abstract boolean writeToFile(ArrayList<CreditCard> creditCards, String outputPath);

}
