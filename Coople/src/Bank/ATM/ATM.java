package Bank.ATM;

import javax.swing.JOptionPane;

import Bank.Customer.CustomerCredit;
import Bank.Customer.CustomerDebit;
import Bank.Customer.CustomerPayroll;
import Bank.ListFInal.ListFinal;
import Structures.*;

public class ATM {
    private static double moneyT; // Variable estática para el dinero total del ATM

    // Operaciones a elegir después del login
    private static int Opc() {
        int opc = -1;

        try {
            String input = JOptionPane.showInputDialog(
                "DEPÓSITO A:\n" +
                "Elige una opción:\n" +
                " [1] Consultar saldo\n" +
                " [2] Depositar\n" +
                " [3] Retirar\n" +
                " [4] Cambiar NIP\n" +
                " [0] Salir\n"
            );

            opc = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
        }
        return opc;
    }

    public static void setMoneyT(double moneyT) {
        ATM.moneyT = moneyT;
    }

    // Método para obtener el dinero total del ATM
    public static double getMoneyT() {
        return moneyT;
    }

    // Logins
    public static void logginPayroll(String cardNumber) {
        String nameCom;
        String nip;
        int cont;

        NodePay current = ListFinal.ListP.getHead();

        // Lista para payroll
        if (!ListFinal.ListP.isEmpty()) { // Mientras no esté vacía
            while (current != null) {
                if (current.cus.getCard().getNumber().equals(cardNumber)) {
                    nameCom = current.cus.getName() + " " + current.cus.getSurname1() + " " + current.cus.getSurname2();
                    cont = 1;
                    do {
                        nip = JOptionPane.showInputDialog(nameCom + " ¡bienvenido!\n\tIngresa tu NIP");
                        if (nip == null) {
                            JOptionPane.showMessageDialog(null, "Operación cancelada");
                            return;
                        }
                        if (!current.cus.getCard().getNip().equals(nip)) {
                            cont++;
                            if (cont > 3) {
                                JOptionPane.showMessageDialog(null, "Acceso incorrecto\nDemasiados intentos fallidos");
                                return;
                            } else if (cont == 3) {
                                JOptionPane.showMessageDialog(null, "Último intento\nIngresa correctamente tu NIP");
                            }
                        }
                    } while (!current.cus.getCard().getNip().equals(nip));

                    JOptionPane.showMessageDialog(null, "Acceso permitido\nBienvenido " + nameCom);

                    optionsCus(current.cus);
                    return;
                }
                current = current.next;
            }
        }
    }

    public static void logginCredit(String cardNumber) {
        String nameCom;
        String nip;
        int cont;

        NodeCr current = ListFinal.ListC.getHead();

        // Lista para credit
        if (!ListFinal.ListC.isEmpty()) { // Mientras no esté vacía
            while (current != null) {
                if (current.cus.getCard().getNumber().equals(cardNumber)) {
                    nameCom = current.cus.getName() + " " + current.cus.getSurname1() + " " + current.cus.getSurname2();
                    cont = 1;
                    do {
                        nip = JOptionPane.showInputDialog(nameCom + " ¡bienvenido!\n\tIngresa tu NIP");
                        if (nip == null) {
                            JOptionPane.showMessageDialog(null, "Operación cancelada");
                            return;
                        }
                        if (!current.cus.getCard().getNip().equals(nip)) {
                            cont++;
                            if (cont > 3) {
                                JOptionPane.showMessageDialog(null, "Acceso incorrecto\nDemasiados intentos fallidos");
                                return;
                            } else if (cont == 3) {
                                JOptionPane.showMessageDialog(null, "Último intento\nIngresa correctamente tu NIP");
                            }
                        }
                    } while (!current.cus.getCard().getNip().equals(nip));

                    JOptionPane.showMessageDialog(null, "Acceso permitido\nBienvenido " + nameCom);
                    optionsCus(current.cus);
                    return;
                }
                current = current.next;
            }
        }
    }

    public static void logginDebit(String cardNumber) {
        String nameCom;
        String nip;
        int cont;

        NodeDe current = ListFinal.ListD.getHead();

        // Lista para debit
        if (!ListFinal.ListD.isEmpty()) { // Mientras no esté vacía
            while (current != null) {
                if (current.cus.getCard().getNumber().equals(cardNumber)) {
                    nameCom = current.cus.getName() + " " + current.cus.getSurname1() + " " + current.cus.getSurname2();
                    cont = 1;
                    do {
                        nip = JOptionPane.showInputDialog(nameCom + " ¡bienvenido!\n\tIngresa tu NIP");
                        if (nip == null) {
                            JOptionPane.showMessageDialog(null, "Operación cancelada");
                            return;
                        }
                        if (!current.cus.getCard().getNip().equals(nip)) {
                            cont++;
                            if (cont > 3) {
                                JOptionPane.showMessageDialog(null, "Acceso incorrecto\nDemasiados intentos fallidos");
                                return;
                            } else if (cont == 3) {
                                JOptionPane.showMessageDialog(null, "Último intento\nIngresa correctamente tu NIP");
                            }
                        }
                    } while (!current.cus.getCard().getNip().equals(nip));

                    JOptionPane.showMessageDialog(null, "Acceso permitido\nBienvenido " + nameCom);
                    optionsCus(current.cus);
                    return;
                }
                current = current.next;
            }
        }
    }

    // Opciones de los clientes
    private static void optionsCus(CustomerPayroll customerP) {
        int opc;
        char res;

        do {
            do {
                opc = Opc();
            } while (opc < 0 || opc > 4);

            switch (opc) {
                case 1:
                    OpAtm.checkBalance(customerP); // Consultar saldo
                    break;
                case 2:
                    OpAtm.depositMoney(customerP); // Depositar dinero
                    break;
                case 3:
                    OpAtm.withdrawMoney(customerP); // Retirar dinero
                    break;
                case 4:
                    OpAtm.changeNIP(customerP);
                    break;
                case 0:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }

            res = JOptionPane.showInputDialog("¿Deseas realizar otra acción? s/n: ").charAt(0);
        } while (Character.toUpperCase(res) == 'S');
    }

    private static void optionsCus(CustomerDebit customerD) {
        int opc;
        char res;

        do {
            do {
                try {
                    opc = Opc();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
                    opc = -1; // Asegura que opc se establezca a un valor no válido
                }
            } while (opc < 0 || opc > 4);

            switch (opc) {
                case 1:
                    OpAtm.checkBalance(customerD); // Consultar saldo
                    break;
                case 2:
                    OpAtm.depositMoney(customerD); // Depositar dinero
                    break;
                case 3:
                    OpAtm.withdrawMoney(customerD); // Retirar dinero
                    break;
                case 4:
                    OpAtm.changeNIP(customerD);
                    break;
                case 0:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }

            res = JOptionPane.showInputDialog("¿Deseas realizar otra acción? s/n: ").charAt(0);
        } while (Character.toUpperCase(res) == 'S');
    }

    private static void optionsCus(CustomerCredit customerC) {
        int opc;
        char res;

        do {
            do {
                try {
                    opc = Opc();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
                    opc = -1; // Asegura que opc se establezca a un valor no válido
                }
            } while (opc < 0 || opc > 4);

            switch (opc) {
                case 1:
                    OpAtm.checkBalance(customerC); // Consultar saldo
                    break;
                case 2:
                    OpAtm.depositMoney(customerC); // Depositar dinero
                    break;
                case 3:
                    OpAtm.withdrawMoney(customerC); // Retirar dinero
                    break;
                case 4:
                    OpAtm.changeNIP(customerC);
                    break;
                case 0:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }

            res = JOptionPane.showInputDialog("¿Deseas realizar otra acción? s/n: ").charAt(0);
        } while (Character.toUpperCase(res) == 'S');
    }
}
