package Bank;

public abstract class Person {
    protected String name;
    protected String surname1;
    protected String surname2;
    protected int age;
    protected char gender;

//Constructor
    Person(String name, String surname1, String surname2, int age, char gender){
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.age = age;
        this.gender = gender;
    }
//setters
    public void setName(String name){
        this.name = name;
    }

    public void setSurname1(String surname1){
        this.surname1 = surname1;
    }

    public void setSurname2(String surname2){
        this.surname2 = surname2;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    //getters
    public String getName(){
        return name;
    }

    public String getSurname1(){
        return surname1;
    }

    public String getSurname2(){
        return surname2;
    }

    public int getAge(){
        return age;
    }

    public char getGender(){
        return gender;
    }

    public void showInfoP(){
        System.out.println("Nombre: " + getName() + " " + getSurname1() + " " + getSurname2());
        System.out.println("Edad: " + getAge());
        System.out.println("Genero: " + getGender());
    }

}
