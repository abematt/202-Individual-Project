package fileTypes;

import java.util.ArrayList;

import creditCard.*;

public class XmlFile extends FileType{
	
	@Override
	public ArrayList<CreditCard> readFromFile(String inputPath){
		
		ArrayList<CreditCard> creditCards = new ArrayList<>();
		System.out.println("Xml file");
		return creditCards;
	}



	@Override
	public boolean writeToFile(ArrayList<CreditCard> creditCards, String outputPath) {
		
		return true;
	}
}