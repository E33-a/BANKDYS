package Bank.Interface;

import Bank.BankAdd;
import Bank.ATM.logShowDel;

import javax.swing.JOptionPane;

public class crud implements CRUD{
    public static void create(){
        BankAdd.addCustomer();
    }
    public static void read(String numberT){
        try {
            do {
                numberT = JOptionPane.showInputDialog("BUSCAR CUENTA\nIngresa el número de tarjeta: ");
                if (numberT != null && numberT.length() == 16 && numberT.matches("\\d{16}")) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "El número de tarjeta debe ser numérico y tener exactamente 16 dígitos.");
                }
            } while (true);

        } catch (NumberFormatException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Error inesperado al buscar la cuenta\nInténtalo nuevamente");
        }
        logShowDel.showFound(numberT); // Buscar e imprimir datos
    }
    public static void update(String numberT){
        try { // Editar información (update)
            do {
                numberT = JOptionPane.showInputDialog("BUSCAR CUENTA\nIngresa el número de tarjeta: ");
                if (numberT != null && numberT.length() == 16 && numberT.matches("\\d{16}")) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "El número de tarjeta debe ser numérico y tener exactamente 16 dígitos.");
                }
            } while (true);

        } catch (NumberFormatException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Error inesperado al buscar la cuenta\nInténtalo nuevamente");
        }
        logShowDel.updateFound(numberT);
    }
    public static void delete(String numberT){
        try {
            do {
                numberT = JOptionPane.showInputDialog("BUSCAR CUENTA A ELIMINAR\nIngresa el número de tarjeta: ");
                if (numberT != null && numberT.length() == 16 && numberT.matches("\\d{16}")) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "El número de tarjeta debe ser numérico y tener exactamente 16 dígitos.");
                }
            } while (true);
        } catch (Exception a) {
            System.out.println("Error: " + a);
            JOptionPane.showMessageDialog(null, "Error inesperado al buscar la cuenta a eliminar\nInténtalo nuevamente");
        }
        logShowDel.delCustomer(numberT);
    }
}
