package cardCheckers;

import creditCard.*;
import java.util.Date;

public class masterCardChecker implements cardCheckers{

    private cardCheckers successor = null;

    @Override
    //If it is master card, create new master card object and return, otherwise forward to VisaCC Handler
    public CreditCard checkCreditCard(String cardNumber, Date expirationDate, String nameOfCardHolder) {
        System.out.println("MasterCCHandler got the request...");
        int firstDigit = Character.getNumericValue(cardNumber.charAt(0));
        int secondDigit = Character.getNumericValue(cardNumber.charAt(1));
        int length = cardNumber.length();
        if (length==16 && firstDigit==5 && secondDigit<=5 && secondDigit>=1) {
            System.out.println("It is a Master Credit Card");
            return new MasterCard(cardNumber, nameOfCardHolder, expirationDate, true, "Master Card", null);
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
