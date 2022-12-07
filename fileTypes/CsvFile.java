package fileTypes;
import cardCheckers.*;

import java.util.ArrayList;

import creditCard.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvFile extends FileType{
	
	@Override
	public ArrayList<CreditCard> readFromFile(String inputPath){
		
		invalidCardChecker invalidCardChecker = new invalidCardChecker(); 
        masterCardChecker masterCardChecker = new masterCardChecker();
       visaCardChecker visaCardChecker = new visaCardChecker();
       AmericanExpressCardChecker AmericanExpressCardChecker = new AmericanExpressCardChecker();
       discoverCardChecker discoverCardChecker = new discoverCardChecker();
       
       invalidCardChecker.setSuccessor(masterCardChecker);
       masterCardChecker.setSuccessor(visaCardChecker);
       visaCardChecker.setSuccessor(AmericanExpressCardChecker);
       AmericanExpressCardChecker.setSuccessor(discoverCardChecker);
       
		ArrayList<CreditCard> creditCards = new ArrayList<>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		File csvFile = new File(inputPath);
		
		String csvString;
		String splitCriteria = ",";
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		try
		{
			BufferedReader csvReader = new BufferedReader(new FileReader(csvFile)); 
			while((csvString = csvReader.readLine())!= null)
			{
				String[] cardDetails = csvString.split(splitCriteria);
				String cardNumber = cardDetails[0];
				Date expiryDate = dateFormat1.parse("01/02/2022");
				String nameOfCardHolder = cardDetails[2];
				creditCards.add(invalidCardChecker.checkCreditCard(cardNumber, expiryDate, nameOfCardHolder));
				
//				System.out.println(cardDetails[0]+ " " + cardDetails[1]+ " " + cardDetails[2]);
				
			}
		
		}
		catch(IOException | ParseException e) {
			e.printStackTrace();
		}
		return creditCards;
	}



	@Override
	public boolean writeToFile(ArrayList<CreditCard> creditCards, String outputPath) {
		
		System.out.println("Writing to csv file...");
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        File csvFile = new File(outputPath + "output.csv");

        try (PrintWriter printWriter = new PrintWriter(csvFile)) {
            StringBuilder sb = new StringBuilder();
            //first line TAG
            sb.append("CardNumber");
            sb.append(COMMA_DELIMITER);
            sb.append("Type");
            sb.append(NEW_LINE_SEPARATOR);

            for (CreditCard creditCard : creditCards) {
                sb.append(creditCard.getCardNumber());
                sb.append(COMMA_DELIMITER);
                sb.append(creditCard.getCardProvider());
                if (!creditCard.getValidStatus()){
                    sb.append(":" + creditCard.getCardError());
                }
                sb.append(NEW_LINE_SEPARATOR);
            }
            printWriter.write(sb.toString());
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}