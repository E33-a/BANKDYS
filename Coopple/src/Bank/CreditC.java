package Bank;

public class CreditC extends Credit {
    protected int fees;
    protected String typeCred;

    public CreditC(double amount, double interest, int fees, String typeCred){
        super(amount, interest);
        this.fees = fees;
        this.typeCred = typeCred;
    }

    //setters
    public void setFees(int fees){
        this.fees = fees;
    }

    public void setTypeCred(String typeCred){
        this.typeCred = typeCred;
    }

    //getters
    public int getFees(){
        return fees;
    }

    public String getTypeCred(){
        return typeCred;
    }
}
