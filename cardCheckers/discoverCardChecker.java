package cardCheckers;

import creditCard.*;
import java.util.Date;

public class discoverCardChecker implements cardCheckers{

    private cardCheckers successor = null;

    @Override
    //If it is master card, create new master card object and return, otherwise forward to VisaCC Handler
    public CreditCard checkCreditCard(String cardNumber, Date expirationDate, String nameOfCardHolder) {
    	System.out.println("DiscoverCCHandler got the request...");
        int length = cardNumber.length();
        if (length==16 && cardNumber.startsWith("6011")) {
            System.out.println("It is an Discover Credit Card");
            return new DiscoverCard(cardNumber, nameOfCardHolder, expirationDate, true, "Discover Card",null);
        }
        else {
            if (successor != null)
                return successor.checkCreditCard(cardNumber, expirationDate, nameOfCardHolder);
        }
        System.out.println("ERROR: It is an Invalid Card!");
        return new DiscoverCard(cardNumber, nameOfCardHolder, expirationDate, false, "Invalid","not a possible card");
    }

    @Override
    public void setSuccessor(cardCheckers next) {
        this.successor = next;
    }
}
