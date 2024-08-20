package Bank.Customer;

import Bank.Card.CardCredit;
import Bank.Credit.CreditC;

public class CustomerCredit extends Customer{
    private CardCredit Card;

    public CustomerCredit(String name, String surname1, String surname2, int age, char gender, double salary, CreditC Credit, CardCredit Card){
        super(name, surname1, surname2, age, gender, salary, Credit, Card);
    this.Card = Card;
    }

    //setters
    public void assingCardCredit(CardCredit Card){
        this.Card = Card;
    }

    //getters
    public CardCredit getCard(){
        return Card;
    }

    public void showCCre(){
        showInfoP();
        System.out.println("Tipo de tarjeta: " + getCard().getType());
        System.out.println("Numero de cuenta: " + getCard().getNumber());
        System.out.println("NIP: " + getCard().getNip());
        System.out.println("Saldo: $" + getCard().getCreditBalance());
        System.out.println("Tasa de interes: " + (getCard().getCardInterest() * 100) + "%");
        System.out.println("Descuento: " + (getCard().getDiscount() * 100) + "%");
        showInfoC();
    }
}
