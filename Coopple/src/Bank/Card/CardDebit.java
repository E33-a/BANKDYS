package Bank.Card;

import Bank.Discountt;

public class CardDebit extends CardPayroll implements Discountt{
    protected double discount;

    public CardDebit(double balance, double discount){
        super(balance);
        this.discount = discount;
        this.type = "DEBITO";
    }
    public CardDebit(String number, String nip, String type, double balance, double discount){
        super(number, nip, type, balance);
        this.discount = discount;
    }//implementado para files

    //setters
    @Override
    public void setDiscount(double discount){
        this.discount = discount;
    }

    //getters
    @Override
    public double getDiscount(){
        return discount;
    }
    
}
