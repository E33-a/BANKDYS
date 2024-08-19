package Bank.Card;

public class CardPayroll extends Card{
    protected double balance;
    

    public CardPayroll(double balance){
        super();
        this.balance = balance;
        this.type = "NOMINA";
    }
    public CardPayroll(String number, String nip, String type, double balance){
        super(number, nip, type);
        this.balance = balance;
    }//Implementado para files

    //setters
    public void setBalance(double balance){
        this.balance = balance;
    }

    //getters
    public double getBalance(){
        return balance;
    }

    public String getType(){
        return type;
    }
}
