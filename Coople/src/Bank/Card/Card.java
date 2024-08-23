package Bank.Card;

import java.util.concurrent.ThreadLocalRandom;

import Bank.ListFInal.ListFinal;

public abstract class Card {
    long numero = ThreadLocalRandom.current().nextLong(100000000000L, 1000000000000L);
    long numeroR1 = ThreadLocalRandom.current().nextLong(1000, 10000); // NIP aleatorio

    private static final String INITIAL = "4294";

    protected String number;
    protected String nip;
    protected String type;

    public Card() {
        boolean cusExist;
        do {
            cusExist = false;

            // Genera un nuevo número de tarjeta y NIP
            long numero = ThreadLocalRandom.current().nextLong(100000000000L, 1000000000000L); // Número de tarjeta aleatorio
            long numeroR1 = ThreadLocalRandom.current().nextLong(1000, 10000); // NIP aleatorio

            // Asegúrate de que el número de tarjeta tenga exactamente 16 dígitos
            this.number = INITIAL + String.format("%012d", numero); // Formatea el número para que tenga 12 dígitos
            this.nip = String.format("%04d", numeroR1); // Formatea el NIP para que tenga 4 dígitos

            // Verifica si el número de tarjeta ya existe en alguna de las listas
            if (ListFinal.ListP.findCus(this.number) || 
                ListFinal.ListD.findCus(this.number) || 
                ListFinal.ListC.findCus(this.number)) {
                cusExist = true; // El número ya existe, genera uno nuevo
            }
        } while (this.number.length() != 16 || cusExist);
    }
    Card(String number, String nip, String type){
        this.number = number;
        this.nip = nip;
        this.type = type;
    }//implementado para file

    //setters
    public void setNip(String nip){
        this.nip = nip;
    }

    //getters
    public String getNumber(){
        return number;
    }
    
    public String getNip(){
        return nip;
    }

    public String getType(){
        return type;
    }
}

