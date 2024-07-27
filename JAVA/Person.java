package com.mycompany.bank;

/**
 * Clase abstracta Person
 */
public abstract class Person {
 /*
Una vez ingresado el nombre y apellidos estos no podran modificarse
*/
    protected final String name; // Atributo nombre
    protected final String surname1; // Atributo primer apellido
    protected final String surname2; // Atributo segundo apellido
    protected int age; // Atributo edad
    //protected char gender; // Posible implementacion
    
    /**
     * Constructor sobrecargado de la clase Person
     * @param name atributo nombre de la persona
     * @param surname1 atributo primer apellido de la persona
     * @param surname2 atributo segundo apellido de la persona
     * @param age  atributo edad de la persona
     */
    public Person(String name, String surname1, String surname2, int age){
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.age = age;
        //this.gender = gender;
    }

    // Metodos getters de Person
    public String getName() {
        return name;
    }

    public String getSurname1() {
        return surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public int getAge() {
        return age;
    }

    
     //Metodos setters de Person (edad es el unico atributo modificable por ahora)
    
    public void setAge(int age) {
        this.age = age;
    }
    
    // Metodo que muestra la informacion de Person
    public void showPerson(){
        System.out.println("\n\n--------------------------------------------------------");
        System.out.println("Nombre: " + getName() + " " + getSurname1() + " " + getSurname2());
        System.out.println("Edad: " + getAge());
        //System.out.println("Genero: " + getGender()); // Posible implementacion
    }
}
