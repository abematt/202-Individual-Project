import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import creditCard.CreditCard;
import fileTypes.*;

public class UserInterface {
	
	public static void main(String[] args) {
		
		ArrayList<CreditCard> creditCards;
		FileType newFile;
		
		System.out.println("Proceed with file read?(y/n) :");
		Scanner userInput = new Scanner(System.in);
		
		String inputChoice = userInput.next();
		
		if(inputChoice.equals("y")) {
			System.out.println("Proceeding...");
			System.out.println("Enter File:");
			
			Scanner fileTypeInput = new Scanner(System.in);
			
			String typeOfFile = fileTypeInput.nextLine();
			
			newFile = FileCreators.makeFile(typeOfFile);
			
			creditCards = newFile.readFromFile("./src/" + typeOfFile);
			
			newFile.writeToFile(creditCards,"./src/");
		
			
			fileTypeInput.close();
		}
		if(inputChoice.equals("n")) {
			System.out.println("Goodbye!");
		}
		
		userInput.close();
		
	}

}
