package cardCheckers;

import creditCard.*;
import java.util.Date;

public class visaCardChecker implements cardCheckers{

    private cardCheckers successor = null;

    @Override
    //If it is master card, create new master card object and return, otherwise forward to VisaCC Handler
    public CreditCard checkCreditCard(String cardNumber, Date expirationDate, String nameOfCardHolder) {
    	System.out.println("VisaCCHandler got the request...");
        int firstDigit = Character.getNumericValue(cardNumber.charAt(0));
        int length = cardNumber.length();
        if ((length==16 || length==13) && firstDigit==4) {
            System.out.println("It is a Visa Credit Card");
            return new VisaCard(cardNumber, nameOfCardHolder, expirationDate, true, "Visa Card", null);
        }
        else {
            if (successor != null)
                return successor.checkCreditCard(cardNumber, expirationDate, nameOfCardHolder);
        }
        return null;
    }

    @Override
    public void setSuccessor(cardCheckers next) {
        this.successor = next;
    }
}
