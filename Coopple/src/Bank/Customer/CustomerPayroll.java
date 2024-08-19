package Bank.Customer;

import Bank.Card.CardPayroll;
import Bank.Credit.CreditC;

public class CustomerPayroll extends Customer {
    private CardPayroll card;

    public CustomerPayroll(String name, String surname1, String surname2, int age, char gender, double salary, CreditC credit, CardPayroll card) {
        super(name, surname1, surname2, age, gender, salary, credit);
        this.card = card;
    }

    // Setters
    public void assignCardPayroll(CardPayroll card) {
        this.card = card;
    }

    // Getters
    public CardPayroll getCard() {
        return card;
    }

    public void showCPay() {
        showInfoP();
        System.out.println("Tipo de tarjeta: " + getCard().getType());
        System.out.println("Número de cuenta: " + getCard().getNumber());
        System.out.println("NIP: " + getCard().getNip());
        System.out.println("Saldo: $" + getCard().getBalance());
        showInfoC();
    }
}
