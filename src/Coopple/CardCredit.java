package Coopple;

public class CardCredit extends Card implements Discountt{
    protected double debt;
    protected double cardInterest;
    protected double discount;

    CardCredit(double debt, double cardInterest, double discount) {
        super();
        this.debt = debt;
        this.cardInterest = cardInterest;
        this.discount = discount;
        this.type = "CREDITO";
    }
    CardCredit(String number, String nip, String type, double debt, double cardInterest, double discount) {
        super(number, nip, type);
        this.debt = debt;
        this.cardInterest = cardInterest;
        this.discount = discount;
    }//implemementado para file

    //setters
    public void setDebt(double debt){
        this.debt = debt;
    }

    public void setCardInterest(double cardInterest){
        this.cardInterest = cardInterest;
    }

    @Override
    public void setDiscount(double discount){
        this.discount = discount;
    }

    //getters
    public double getDebt(){
        return debt;
    }

    public double getCardInterest(){
        return cardInterest;
    }

    @Override
    public double getDiscount(){
        return discount;
    }
}
