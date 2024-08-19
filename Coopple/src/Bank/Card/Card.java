package Bank.Card;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Card {
    long numero = ThreadLocalRandom.current().nextLong(100000000000L, 1000000000000L);
    long numeroR1 = ThreadLocalRandom.current().nextLong(1000, 10000); // NIP aleatorio

    final String initial = "4294";

    protected String number;
    protected String nip;
    protected String type;

    Card(){
        this.number = initial + Long.toString(numero);
        this.nip = Long.toString(numeroR1);
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

