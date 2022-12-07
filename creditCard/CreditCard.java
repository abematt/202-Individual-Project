package creditCard;
import java.util.Date;

abstract public class CreditCard {
	    private String cardNumber;
	    private String nameOfCardHolder;
	    private Date expiryDate;
	    private boolean validStatus;
	    private String cardProvider;
	    private String cardError;

	    public CreditCard (String cardNumber,String nameOfCardHolder,Date expiryDate,boolean validStatus,String cardProvider,String cardError){
	        this.cardNumber = cardNumber;
	        this.nameOfCardHolder = nameOfCardHolder;
	        this.expiryDate = expiryDate;
	        this.validStatus = validStatus;
	        this.cardProvider = cardProvider;
	        this.cardError = cardError;
	    }

	    public String getCardNumber(){return this.cardNumber;}
	    public Date getExpiryDate(){return this.expiryDate;}
	    public String getNameOfCardHolder(){return this.nameOfCardHolder;}
	    public String getCardProvider(){return this.cardProvider;}
	    public boolean getValidStatus(){return this.validStatus;}
	    public String getCardError(){return this.cardError;}

	}

