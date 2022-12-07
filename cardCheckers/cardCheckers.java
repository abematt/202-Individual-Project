package cardCheckers;

import creditCard.*;
import java.util.Date;

public interface cardCheckers {

    public CreditCard checkCreditCard(String cardNumber, Date expiryDate, String nameOfCardHolder);

    public void setSuccessor(cardCheckers next);

}
