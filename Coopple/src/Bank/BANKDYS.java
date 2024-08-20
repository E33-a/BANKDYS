package Bank;

import javax.swing.JOptionPane;

import Bank.ATM.ATM;
import Bank.ATM.logShowDel;
import Bank.ListFInal.ListFinal;

public class BANKDYS {
    public static void main(String[] args) {

        String numberT;
        double moneyAtm = 0;

        int option = -1;
        try{
            while (option != 0) {
                numberT = "";
                try{
                    option = Integer.parseInt(JOptionPane.showInputDialog("""
                                                        \n\t MENU
                                                        \n [1]  Añadir cliente
                                                        \n [2]  Buscar cliente (No. tarjeta)
                                                        \n [3]  Mostrar información de clientes
                                                        \n [4]  Eliminar cliente (No. tarjeta)
                                                        \n [5]  Editar informacion de cliente
                                                        \n [6]  Asignar dinero al ATM
                                                        \n [7]  ATM - Operaciones
                                                        \n [8]  Ordenar listas
                                                        \n [0]  Salir
                                                        \n\n\tSeleccione una opción:
                                                        """));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
                }
                clearScreen();
                switch (option) {
                    case 1:
                        BankAdd.addCustomer(); //Añadir cleinte de cualquier tipo
                        break;

                    case 2:
                        try{
                            do {
                                numberT = JOptionPane.showInputDialog("BUSCAR CUENTA\nIngresa el numero de tarjeta: ");
                                if (numberT != null && numberT.length() == 16 && numberT.matches("\\d{16}")) {
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "El número de tarjeta debe ser numérico y tener exactamente 16 dígitos.");
                                }
                            } while (true);
                           
                        } catch (NumberFormatException e) {
                            System.out.println("Error: " + e);
                            JOptionPane.showMessageDialog(null, "Error inesperado al buscar la cuenta\nIntenta nuevamente");
                            continue;
                        }
                        logShowDel.showFound(numberT);//buscar e imprimir datos 
                        break;

                    case 3:
                        logShowDel.showEveryone();
                        break;

                    case 4:
                        try{
                            do {
                                numberT = JOptionPane.showInputDialog("BUSCAR CUENTA A ELIMINAR\nIngresa el numero de tarjeta: ");
                                if (numberT != null && numberT.length() == 16 && numberT.matches("\\d{16}")) {
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "El número de tarjeta debe ser numérico y tener exactamente 16 dígitos.");
                                }
                            } while (true);
                        } catch (Exception a) {
                            System.out.println("Error: " + a);
                            JOptionPane.showMessageDialog(null, "Error inesperado al buscar la cuenta a eliminar\nIntenta nuevamente");
                        }
                        logShowDel.delCustomer(numberT);
                        break;

                    case 5:
                    try{//Editar informacion (update)
                        do {
                            numberT = JOptionPane.showInputDialog("BUSCAR CUENTA\nIngresa el numero de tarjeta: ");
                            if (numberT != null && numberT.length() == 16 && numberT.matches("\\d{16}")) {
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "El número de tarjeta debe ser numérico y tener exactamente 16 dígitos.");
                            }
                        } while (true);
                       
                    } catch (NumberFormatException e) {
                        System.out.println("Error: " + e);
                        JOptionPane.showMessageDialog(null, "Error inesperado al buscar la cuenta\nIntenta nuevamente");
                        continue;
                    }
                        logShowDel.updateFound(numberT);
                        break;

                    case 6:
                        try{
                            do{
                                moneyAtm = Double.parseDouble(JOptionPane.showInputDialog("ASIGNAR DINERO A CAJERO\nMinimo $20000\nMaximo $60000\n\nIngresa cantidad:"));
                            } while (moneyAtm < 20000 || moneyAtm > 60000);
                        } catch (Exception a) {
                            System.out.println("Error: " + a);
                            JOptionPane.showMessageDialog(null, "Error inesperado al asignar dinero\nIntenta nuevamente");
                        }
                        ATM.setMoneyT(moneyAtm);
                        String message = "Dinero asignado correctamente al cajero\nCantidad asignada: $" + moneyAtm;
                            JOptionPane.showMessageDialog(null, message);
                            break;

                    case 7:
                        try{
                            do {
                                numberT = JOptionPane.showInputDialog("VALIDAR CUENTA\nIngresa el numero de tarjeta: ");
                                if (numberT != null && numberT.length() == 16 && numberT.matches("\\d{16}")) {
                                    break; //rompe ciclo si se cumple el matches
                                    // Ocupe expresion regular para saber si los caracteres son numericos
                                    // \\d representa digitos (0 al 9), {16} indica que deben ser 16 digitos
                                } else {
                                    JOptionPane.showMessageDialog(null, "El número de tarjeta debe ser numérico y tener exactamente 16 dígitos.");
                                }
                            } while (true);
                        } catch (Exception q) {
                            System.out.println("Error: " + q);
                            JOptionPane.showMessageDialog(null, "Error inesperado al buscar la cuenta en ATM\nIntenta nuevamente");
                        }
                        logShowDel.typeLoggin(numberT);//buscar y seleccionar tipo de loggeo
                        break;

                    case 8:
                        JOptionPane.showMessageDialog(null, "Ordenando todas las listas\nRespecto al numero de tarjeta");
                        ListFinal.ListP.sort();
                        JOptionPane.showMessageDialog(null, "Lista de NOMINA ordenada");
                        ListFinal.ListD.sort();
                        JOptionPane.showMessageDialog(null, "Lista de DEBITO ordenada");
                        ListFinal.ListC.sort();
                        JOptionPane.showMessageDialog(null, "Lista de CREDITO ordenada");
                        JOptionPane.showMessageDialog(null, "TODAS LAS LISTAS\nHAN SIDO ORDENANDAS");
                        break;

                    case 0:
                        System.out.println("\nSaliendo...");
                        break;

                    default:
                        System.out.println("\nOpción no válida\nPor favor intente de nuevo.");
                }
            } 
        } catch (Exception g) {
            System.out.println("Critical error: " + g);
        }
    }

    //Metodo para limpiar "limpiar consola"
    public static void clearScreen() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }
}
