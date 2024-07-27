package com.mycompany.bank;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase que representa una tarjeta bancaria con sus atributos principales.
 */
public class Card {

    /*
     * Objetos ThreadLocalRandom para generar números aleatorios de cierta extensión
     * para asignarlos al número de tarjeta y al NIP.
     */
    long numeroR = ThreadLocalRandom.current().nextLong(10000000000L, 1000000000000L); // Número de tarjeta aleatorio
    long numeroR1 = ThreadLocalRandom.current().nextLong(1000, 10000); // NIP aleatorio
    
    /*
     * Atributos de la clase Card.
     */
    private final String number; // Número de la tarjeta
    private final String cvv; // Código de seguridad de la tarjeta (CVV)
    private String nip; // Número de identificación personal (NIP)
    private final String dateV; // Fecha de vencimiento de la tarjeta

    /**
     * Constructor de la clase Card para crear una nueva tarjeta con CVV y fecha de vencimiento.
     * @param cvv Código de seguridad de la tarjeta.
     * @param dateV Fecha de vencimiento de la tarjeta.
     */
    Card(String cvv, String dateV) {
        final int in = 4522; // Prefijo para el número de tarjeta
        
        this.number = in + Long.toString(numeroR); // Generar número de tarjeta único
        this.cvv = cvv; // Asignar CVV
        this.nip = Long.toString(numeroR1); // Generar NIP único
        this.dateV = dateV; // Asignar fecha de vencimiento
    }
    
    /**
     * Constructor alternativo de la clase Card para crear una tarjeta temporal con un número específico.
     * Utilizado para comparaciones y operaciones específicas.
     * @param number Número de tarjeta específico.
     */
    public Card(String number) {
        this.number = number; // Asignar número de tarjeta específico
        this.cvv = ""; // CVV vacío para tarjeta temporal
        this.nip = ""; // NIP vacío para tarjeta temporal
        this.dateV = ""; // Fecha de vencimiento vacía para tarjeta temporal
    }
    
    /**
     * Método getter para obtener el número de tarjeta.
     * @return Número de la tarjeta.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Método getter para obtener el CVV de la tarjeta.
     * @return CVV de la tarjeta.
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Método getter para obtener el NIP de la tarjeta.
     * @return NIP de la tarjeta.
     */
    public String getNip() {
        return nip;
    }

    /**
     * Método getter para obtener la fecha de vencimiento de la tarjeta.
     * @return Fecha de vencimiento de la tarjeta.
     */
    public String getDateV() {
        return dateV;
    }

    /**
     * Método setter para establecer el NIP de la tarjeta.
     * @param nip Nuevo NIP a establecer.
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

}
