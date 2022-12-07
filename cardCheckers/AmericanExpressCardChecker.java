package cardCheckers;

import creditCard.*;
import java.util.Date;

public class AmericanExpressCardChecker implements cardCheckers{

    private cardCheckers successor = null;

    @Override
    //If it is master card, create new master card object and return, otherwise forward to VisaCC Handler
    public CreditCard checkCreditCard(String cardNumber, Date expirationDate, String nameOfCardHolder) {
    	System.out.println("AmExCCHandler got the request...");
        int firstDigit = Character.getNumericValue(cardNumber.charAt(0));
        int secondDigit = Character.getNumericValue(cardNumber.charAt(1));
        int length = cardNumber.length();
        if (length==15 && firstDigit==3 && (secondDigit==4 || secondDigit==7)) {
            System.out.println("It is an AmericanExpress Credit Card");
            return new AmericanExpressCard(cardNumber, nameOfCardHolder, expirationDate, true, "Visa Card", null);
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
