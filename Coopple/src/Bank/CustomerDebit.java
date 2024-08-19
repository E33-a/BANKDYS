package Bank;


public class CustomerDebit extends CustomerPayroll{
    private CardDebit Card;

    public CustomerDebit(String name, String surname1, String surname2, int age, char gender, double salary, CreditC Credit, CardDebit Card){
        super(name, surname1, surname2, age, gender, salary, Credit, Card);
    this.Card = Card;
    }//posibles errores

    //setters
    public void assingCardDebit(CardDebit Card){
        this.Card = Card;
    }

    //getters
    public CardDebit getCard(){
        return Card;
    }

    public void showCDeb(){
        showInfoP();
        System.out.println("Tipo de tarjeta: " + getCard().getType());
        System.out.println("Numero de cuenta: " + getCard().getNumber());
        System.out.println("NIP: " + getCard().getNip());
        System.out.println("Saldo: $" + getCard().getBalance());
        System.out.println("Descuento: " + (getCard().getDiscount() * 100) + "%");
        showInfoC();
    }
}
