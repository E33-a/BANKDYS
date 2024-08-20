package Bank;

import javax.swing.JOptionPane;
import Bank.ATM.ATM;
import Bank.ATM.logShowDel;
import Bank.Interface.crud;
import Bank.ListFInal.ListFinal;

public class BANKDYS {
    public static void main(String[] args) {

        String numberT;
        double moneyAtm = 0;

        int option = -1;
        try {
            while (option != 0) {
                numberT = "";
                try {
                    option = Integer.parseInt(JOptionPane.showInputDialog("""
                                                        \n\t MENÚ
                                                        \n [1]  Añadir cliente
                                                        \n [2]  Buscar cliente (No. tarjeta)
                                                        \n [3]  Mostrar información de clientes
                                                        \n [4]  Eliminar cliente (No. tarjeta)
                                                        \n [5]  Editar información de cliente
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
                        crud.create();
                        break;

                    case 2:
                        crud.read(numberT);
                        break;

                    case 3:
                        logShowDel.showEveryone();
                        break;

                    case 4:
                        crud.delete(numberT);
                        break;

                    case 5:
                        crud.update(numberT);
                        break;

                    case 6:
                        try {
                            do {
                                moneyAtm = Double.parseDouble(JOptionPane.showInputDialog("ASIGNAR DINERO AL CAJERO\nMínimo $20000\nMáximo $60000\n\nIngresa cantidad:"));
                            } while (moneyAtm < 20000 || moneyAtm > 60000);
                        } catch (Exception a) {
                            System.out.println("Error: " + a);
                            JOptionPane.showMessageDialog(null, "Error inesperado al asignar dinero\nInténtalo nuevamente");
                        }
                        ATM.setMoneyT(moneyAtm);
                        String message = "Dinero asignado correctamente al cajero\nCantidad asignada: $" + moneyAtm;
                        JOptionPane.showMessageDialog(null, message);
                        break;

                    case 7:
                        try {
                            do {
                                numberT = JOptionPane.showInputDialog("VALIDAR CUENTA\nIngresa el número de tarjeta: ");
                                if (numberT != null && numberT.length() == 16 && numberT.matches("\\d{16}")) {
                                    break; // Rompe ciclo si se cumple el match
                                    // Usé expresión regular para saber si los caracteres son numéricos
                                    // \\d representa dígitos (0 al 9), {16} indica que deben ser 16 dígitos
                                } else {
                                    JOptionPane.showMessageDialog(null, "El número de tarjeta debe ser numérico y tener exactamente 16 dígitos.");
                                }
                            } while (true);
                        } catch (Exception q) {
                            System.out.println("Error: " + q);
                            JOptionPane.showMessageDialog(null, "Error inesperado al buscar la cuenta en el cajero\nInténtalo nuevamente");
                        }
                        logShowDel.typeLoggin(numberT); // Buscar y seleccionar tipo de login
                        break;

                    case 8:
                        JOptionPane.showMessageDialog(null, "Ordenando todas las listas\nRespecto al número de tarjeta");
                        ListFinal.ListP.sort();
                        JOptionPane.showMessageDialog(null, "Lista de NÓMINA ordenada");
                        ListFinal.ListD.sort();
                        JOptionPane.showMessageDialog(null, "Lista de DÉBITO ordenada");
                        ListFinal.ListC.sort();
                        JOptionPane.showMessageDialog(null, "Lista de CRÉDITO ordenada");
                        JOptionPane.showMessageDialog(null, "TODAS LAS LISTAS\nHAN SIDO ORDENADAS");
                        break;

                    case 0:
                        System.out.println("\nSaliendo...");
                        break;

                    default:
                        System.out.println("\nOpción no válida\nPor favor intente de nuevo.");
                }
            }
        } catch (Exception g) {
            System.out.println("Error crítico: " + g);
        }
    }

    // Método para limpiar "limpiar consola"
    public static void clearScreen() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }
}
