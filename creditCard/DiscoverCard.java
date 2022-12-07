package creditCard;

import java.util.Date;

public class DiscoverCard extends CreditCard{
    public DiscoverCard(String cardNumber,String nameOfCardHolder,Date expiryDate,boolean validStatus,String cardProvider,String cardError) {
        super(cardNumber, nameOfCardHolder, expiryDate, validStatus, cardProvider,cardError);
    }
}
