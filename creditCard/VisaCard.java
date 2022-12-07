package creditCard;

import java.util.Date;

public class VisaCard extends CreditCard{
    public VisaCard(String cardNumber,String nameOfCardHolder,Date expiryDate,boolean validStatus,String cardProvider,String cardError) {
        super(cardNumber, nameOfCardHolder, expiryDate, validStatus, cardProvider,cardError);
    }
}
