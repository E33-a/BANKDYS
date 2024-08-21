package Bank.Card;

import Bank.Interface.Discountt;

public class CardCredit extends Card implements Discountt{
    protected double creditBalance;
    protected double cardInterest;
    protected double discount;

    public CardCredit(double creditBalance, double cardInterest, double discount) {
        super();
        this.creditBalance = creditBalance;
        this.cardInterest = cardInterest;
        this.discount = discount;
        this.type = "CREDITO";
    }
    public CardCredit(String number, String nip, String type, double creditBalance, double cardInterest, double discount) {
        super(number, nip, type);
        this.creditBalance = creditBalance;
        this.cardInterest = cardInterest;
        this.discount = discount;
    }//implemementado para file

    //setters
    public void setCreditBalance(double creditBalance){
        this.creditBalance = creditBalance;
    }

    public void setCardInterest(double cardInterest){
        this.cardInterest = cardInterest;
    }

    @Override
    public void setDiscount(double discount){
        this.discount = discount;
    }

    //getters
    public double getCreditBalance(){
        return creditBalance;
    }

    public double getCardInterest(){
        return cardInterest;
    }

    @Override
    public double getDiscount(){
        return discount;
    }
}
