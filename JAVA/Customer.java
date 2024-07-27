package com.mycompany.bank;

/**
 * Clase Customer hija de la clase Person
 */
public class Customer extends Person{
    private String address; //
    private String email;
    private String celnum;
    private double balance;
    private double debt;
    private Card card;

    /**
     * Constructor sobrecargado de la clase Person
     * @param name atributo nombre heredado de Person
     * @param surname1 atributo primer apellido heredado de Person
     * @param surname2 atributo segundo apellido heredado de Person
     * @param age atributo edad heredado de Person
     * @param address atributo direecion
     * @param email atributo direccion de correo
     * @param celnum atributo numero celular
     * @param balance atributo saldo
     * @param debt  atributo deuda
     */
      public Customer(String name, String surname1, String surname2, int age, String address, String email, String celnum, double balance, double debt) {
        super(name, surname1, surname2, age);
        this.address = address;
        this.email = email;
        this.celnum = celnum;
        this.balance = balance;
        this.debt = debt;
        this.card = null; // Inicialmente la tarjeta no está asignada
    }
      // Cosntructor sobre cargado con posible aplicacion
    /*public Customer(String name, String surname1, String surname2, int age, Card card) {
        this(name, surname1, surname2, age, "", "", "", 0, 0); // Llama al constructor principal con valores por defecto
        this.card = card;
    }*/

    // Metodos getters de Customer
    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getCelnum() {
        return celnum;
    }

    public double getBalance() {
        return balance;
    }

    public double getDebt() {
        return debt;
    }

    public Card getCard() {
        return card;
    }
    
    // Metodos setters de Customer
    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCelnum(String celnum) {
        this.celnum = celnum;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDebt(float debt) {
        this.debt = debt;
    }
    
     public void assignCard(Card card){
        this.card = card;
    }
    
     // Metodo que muestra la informacion de Customer
    public void showCustomer(){
        showPerson();
        System.out.println("Direccion: " + getAddress());
        System.out.println("Email: " + getEmail());
        System.out.println("Numero celular: " + getCelnum());
        System.out.println("Saldo: $" + getBalance());
        System.out.println("Deuda: " + getDebt());
        if(card != null){
            System.out.println("Numero de tarjeta: " + card.getNumber());
            System.out.println("El NIP es " + card.getNip() + " informacion confidencial");
        }else{
            System.out.println("El cliente no tiene tarjeta");
        }
    }
}
