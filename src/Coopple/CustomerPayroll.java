package Coopple;

public class CustomerPayroll extends Customer{
    private CardPayroll Card;

    CustomerPayroll(String name, String surname1, String surname2, int age, char gender, double salary, CreditC Credit, CardPayroll Card){
        super(name, surname1, surname2, age, gender, salary, Credit);
    this.Card = Card;
    }

    //setters
    public void assingCardPayroll(CardPayroll Card){
        this.Card = Card;
    }

    //getters
    public CardPayroll getCard(){
        return Card;
    }

    public void showCPay(){
        showInfoP();
        System.out.println("Tipo de tarjeta: " + getCard().getType());
        System.out.println("Numero de cuenta: " + getCard().getNumber());
        System.out.println("NIP: " + getCard().getNip());
        System.out.println("Saldo: $" + getCard().getBalance());
        showInfoC();
    }
}
