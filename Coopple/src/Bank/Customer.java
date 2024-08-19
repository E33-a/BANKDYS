package Bank;


public abstract class Customer extends Person{
    protected double salary;
    //protected Card Card;
    protected CreditC Credit;

    Customer(String name, String surname1, String surname2, int age, char gender, double salary, CreditC Credit){
        super(name, surname1, surname2, age, gender);

    this.salary = salary;
    //this.Card = Card;
    this.Credit = Credit;
    }

//setters
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /*public void assingCardPayroll(Card Card){
        this.Card = Card;
    }*/

    public void assingCredit(CreditC Credit){
        this.Credit = Credit;
    }

//getters
    public double getSalary(){
        return salary;
    }

    /*public Card getCard(){
        return Card;
    }*/

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
