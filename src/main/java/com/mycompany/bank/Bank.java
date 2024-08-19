package com.mycompany.bank;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 * Clase principal en la que se realizan las operaciones del banco.
 * 
 * @author emax1
 */
public class Bank implements InterfaceUsAd{
    static String numberT; // Variable global para almacenar el número de tarjeta ingresado en los métodos

    /**
     * Método principal
     * 
     * @param args argumentos de main
     */
    public static void main(String[] args) {
        ColectCust colect = new ColectCust(); // Instancia del colector de clientes

        char res; // Respuesta de usuario
        int opc; // Opción elegida por el usuario
        
        
        try {
            // Control de excepciones para mostrar y validar el menú principal
            do {       
                do {
                    opc = Integer.parseInt(JOptionPane.showInputDialog("""
                            DANDY'S BANK C
                            MENU
                            Elige una opcion:
                             [1] Operaciones banco
                             [2] Operaciones usuarios
                            """));
                } while (opc < 1 || opc > 2); // Corregido: opc debe ser 1 o 2

                switch (opc) {
                    case 1 -> OperationsAdmin(colect); // Operaciones del banco
                    case 2 -> OperationsUser(); // Operaciones de usuarios
                }

                res = JOptionPane.showInputDialog("Deseas realizar otra accion\nPara cajero o\nPara cliente  s/n: ").charAt(0); // Elección de nueva acción
            } while (Character.toUpperCase(res) == 'S');
            
            
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage()); // Impresión del mensaje de error específico
        } catch (NullPointerException d) {
            System.out.println("Error: " +  d);
        } finally {
            System.out.println("\n\nEjecucion realizada\n\n"); // El programa se ejecuta correctamente
        }
    }

    // METODOS
    /**
     * Realizar operaciones bancarias
     * 
     * @param colect Instancia de ColectCus para gestionar clientes
     */
    static public void OperationsAdmin(ColectCust colect) {
        char res1; // Respuesta para realizar nueva acción en operaciones del banco
        int opc1; // Opción elegida para realizar una operación
        double atMoney; // Cantidad de dinero que se le asignará al banco
        final String password = "ban01"; // Contraseña para realizar operaciones del banco
        String pass; // Contraseña ingresada por el usuario
        boolean service;

        do {
            pass = JOptionPane.showInputDialog("Operaciones para operadores del banco\nIngresa la contraseña para acceder: ");

            // Verificar si la contraseña es válida
            if (pass != null && pass.equals(password)) {
                do {
                    // Mostrar menú de banco y validación de opción
                    opc1 = Integer.parseInt(JOptionPane.showInputDialog("""
                            OPERACIONES BANCO
                            MENU
                            Elige una opcion:
                             [1] Ingresar usuarios
                             [2] Mostrar usuarios
                             [3] Mostrar usuario especifico
                             [4] Eliminar usuario
                             [5] Asignar dinero a cajero                                     
                            """));

                    switch (opc1) {
                        case 1 -> colect.addCust(); // Agregar nuevo cliente
                        case 2 -> colect.showCust(); // Mostrar todos los clientes
                        case 3 -> {
                            // Buscar un cliente específico
                            do {
                                numberT = JOptionPane.showInputDialog("Buscar a un usuario\nIngresa el numero de tarjeta: ");
                            } while (numberT == null || numberT.length() != 16);
                            colect.showOneCustomer(numberT);
                        }
                        case 4 -> {
                            // Eliminar un cliente específico
                            do {
                                numberT = JOptionPane.showInputDialog("Eliminar usuario\nIngresa el numero de tarjeta: ");
                            } while (numberT == null || numberT.length() != 16);
                            colect.deleteCustomer(numberT);
                        }
                        case 5 -> {
                            // Ingresar dinero al cajero
                            do {
                                atMoney = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa dinero al cajero:\nComo máximo $25000\nComo mínimo $6000"));
                                if (atMoney < 6000 || atMoney > 25000) {
                                    JOptionPane.showMessageDialog(null, "Cantidad incorrecta\nInténtalo de nuevo.");
                                }
                            } while (atMoney < 6000 || atMoney > 25000);
                            Atm.setMoneyT(atMoney);
                            service = true;
                            Atm.setInService(service);
                            JOptionPane.showMessageDialog(null, "Cajero en servicio");
                        }
                    }

                    res1 = JOptionPane.showInputDialog("BANK SYSTEM\nDeseas realizar otra accion   s/n: ").charAt(0); // Elección de nueva acción en banco
                } while (Character.toUpperCase(res1) == 'S');
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta\nInténtalo de nuevo.");
            }
        } while (pass != null && !pass.equals(password));
    }

    /**
     * Realizar operaciones de usuario
     */
    static public void OperationsUser() {
        char res2; // Respuesta para realizar nueva acción en operaciones de usuario
        int opc2; // Opción elegida por el usuario
        boolean numT; // Validación de 16 dígitos numéricos de la tarjeta

        do {
            // Mostrar menú de usuario y validación de opción
            opc2 = Integer.parseInt(JOptionPane.showInputDialog("""
                    OPERACIONES USUARIOS
                    MENU
                    Elige una opcion:
                     [1] Ingresar
                     [2] Operaciones externas (próximamente)
                    """));

            switch (opc2) {
                case 1 -> {
                    do {
                        // Ingresar el número de tarjeta y validar los 16 dígitos numéricos
                        numberT = JOptionPane.showInputDialog("Ingresa el numero de tarjeta: ");
                    } while (numberT == null || numberT.length() != 16);
                    numT = true;
                    for (int i = 0; i < 16; i++) {
                        char dig = numberT.charAt(i);
                        if (!Character.isDigit(dig)) {
                            numT = false;
                            break;
                        }
                    }
                    if (!numT) {
                        JOptionPane.showMessageDialog(null, "El número debe contener exactamente 16 dígitos numéricos\nIngresa nuevamente");
                    } else {
                        Card ncard = new Card(numberT);
                        Atm.loginCust(ncard);
                    }
                    //case 2 -> {
                    // Otras operaciones a implementar
                    //}
                }
            }

            res2 = JOptionPane.showInputDialog("CLIENTE\nDeseas realizar otra accion   s/n: ").charAt(0); // Elección de nueva acción en cliente
        } while (Character.toUpperCase(res2) == 'S');
    }
}
