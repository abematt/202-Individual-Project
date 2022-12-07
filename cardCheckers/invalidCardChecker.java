package cardCheckers;

import creditCard.*;
import java.util.Date;

public class invalidCardChecker implements cardCheckers{
	
	private cardCheckers successor = null;
	
    @Override
    
    public CreditCard checkCreditCard(String cardNumber, Date expiryDate, String nameOfCardHolder) {
        System.out.println("MasterCCHandler got the request...");
        if( cardNumber.isEmpty() || cardNumber.isBlank() || cardNumber.length() == 0){
            return  new MasterCard(cardNumber, nameOfCardHolder, expiryDate, false, "Invalid","empty/null card number");
         }
        
         if(! cardNumber.matches("^[0-9]+$")){
            return  new MasterCard(cardNumber, nameOfCardHolder, expiryDate, false, "Invalid","non numeric characters");
         }

         if(  cardNumber.length() > 19){
            return  new MasterCard(cardNumber, nameOfCardHolder, expiryDate, false, "Invalid"," more than 19 digits");
         }

        else {
            if (successor != null)
                return successor.checkCreditCard(cardNumber, expiryDate, nameOfCardHolder);
        }
        return null;
    }

    @Override
    public void setSuccessor(cardCheckers next) {
        this.successor = next;
    }
}
