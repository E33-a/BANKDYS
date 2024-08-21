package Bank.Customer;

import Bank.Card.Card;
import Bank.Credit.CreditC;

public abstract class Customer extends Person{
    protected double salary;
    protected Card card;
    protected CreditC Credit;

    Customer(String name, String surname1, String surname2, int age, char gender, double salary, CreditC Credit, Card card){
        super(name, surname1, surname2, age, gender);

    this.salary = salary;
    this.card = card;
    this.Credit = Credit;
    }

//setters
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void assingCardPayroll(Card card){
        this.card = card;
    }

    public void assingCredit(CreditC Credit){
        this.Credit = Credit;
    }

//getters
    public double getSalary(){
        return salary;
    }

    public Card getCard(){
        return card;
    }

    public CreditC getCredit(){
        return Credit;
    }

    public void showInfoC(){
        System.out.println("Salario: $" + getSalary());
        if(getCredit().getTypeCred() != null) {
            System.out.println("\nTipo de credito: " + getCredit().getTypeCred());
            System.out.println("Monto: $" + getCredit().getAmount());
        } else {
            System.out.println("\nSin credito");
        }
    }
}
