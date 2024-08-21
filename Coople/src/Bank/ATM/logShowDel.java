package Bank.ATM;

import javax.swing.JOptionPane;
import Bank.ListFInal.ListFinal;
import Structures.NodeCr;
import Structures.NodeDe;
import Structures.NodePay;

public class logShowDel {
    public static void typeLoggin(String cardNumber) {
        if (ListFinal.ListP.findCus(cardNumber)) {
            ATM.logginPayroll(cardNumber);
        } else if (ListFinal.ListD.findCus(cardNumber)) {
            ATM.logginDebit(cardNumber);
        } else if (ListFinal.ListC.findCus(cardNumber)) {
            ATM.logginCredit(cardNumber);
        } else {
            JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO\nInténtalo nuevamente");
        }
    }

    public static void showFound(String cardNumber) {
        if (ListFinal.ListP.findCus(cardNumber)) {
            ListFinal.ListP.searchCus(cardNumber);
        } else if (ListFinal.ListD.findCus(cardNumber)) {
            ListFinal.ListD.searchCus(cardNumber);
        } else if (ListFinal.ListC.findCus(cardNumber)) {
            ListFinal.ListC.searchCus(cardNumber);
        } else {
            JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO\nInténtalo nuevamente");
        }
    }

    public static void updateFound(String cardNumber) {
        if (ListFinal.ListP.findCus(cardNumber)) {
            updateCus.updatePay(cardNumber);
        } else if (ListFinal.ListD.findCus(cardNumber)) {
            updateCus.updateDeb(cardNumber);
        } else if (ListFinal.ListC.findCus(cardNumber)) {
            updateCus.updateCre(cardNumber);
        } else {
            JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO\nInténtalo nuevamente");
        }
    }

    public static void showEveryone() {
        int opc;
        opc = -1;
        do {
            try {
                String input = JOptionPane.showInputDialog(
                    "MOSTRAR CLIENTES:\n" +
                    "[1] Nómina\n" +
                    "[2] Débito\n" +
                    "[3] Crédito\n"
                );
                opc = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
                opc = -1; // Asegura que opc se establezca a un valor no válido
            }
        } while (opc < 1 || opc > 3);

        switch (opc) {
            case 1:
                showEveryonePay();
                break;
            case 2:
                showEveryoneDeb();
                break;
            case 3:
                showEveryoneCre();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                break;
        }
    }

    private static void showEveryonePay() {
        if (!ListFinal.ListP.isEmpty()) {
            ListFinal.ListP.printForward();
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía\nPrimero agrega clientes de nómina");
        }
    }

    private static void showEveryoneDeb() {
        if (!ListFinal.ListD.isEmpty()) {
            ListFinal.ListD.printForward();
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía\nPrimero agrega clientes de débito");
        }
    }

    private static void showEveryoneCre() {
        if (!ListFinal.ListC.isEmpty()) {
            ListFinal.ListC.printForward();
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía\nPrimero agrega clientes de crédito");
        }
    }

    public static void delCustomer(String cardNumber) {
        NodePay np;
        NodeDe nd;
        NodeCr nc;

        String nameCom = "";

        if (ListFinal.ListP.findCus(cardNumber)) {
            np = ListFinal.ListP.deleteNodePayValue(cardNumber);
            if (np != null) {
                nameCom = np.cus.getName() + " " + np.cus.getSurname1() + " " + np.cus.getSurname2();
                String messageInfo = "CLIENTE ELIMINADO EXITOSAMENTE\n" +
                    "Nombre: " + nameCom + "\n" +
                    "Edad: " + np.cus.getAge() + "\n" +
                    "Género: " + np.cus.getGender() + "\n" +
                    "Salario: $" + np.cus.getSalary() + "\n" +
                    "Tipo de cliente: " + np.cus.getCard().getType() + "\n" +
                    "Número tarjeta: " + np.cus.getCard().getNumber() + "\n" +
                    "NIP: " + np.cus.getCard().getNip() + "\n" +
                    "Saldo de tarjeta: $" + np.cus.getCard().getBalance() + "\n" +
                    "Tipo de Crédito: " + np.cus.getCredit().getTypeCred() + "\n" +
                    "Monto del Crédito: $" + np.cus.getCredit().getAmount() + "\n";
                JOptionPane.showMessageDialog(null, messageInfo);
            } else {
                JOptionPane.showMessageDialog(null, "CLIENTE CON TARJETA: " + cardNumber + " NO ENCONTRADO");
            }
        } else if (ListFinal.ListD.findCus(cardNumber)) {
            nd = ListFinal.ListD.deleteNodeDeValue(cardNumber);
            if (nd != null) {
                nameCom = nd.cus.getName() + " " + nd.cus.getSurname1() + " " + nd.cus.getSurname2();
                String messageInfo = "CLIENTE ELIMINADO EXITOSAMENTE\n" +
                    "Nombre: " + nameCom + "\n" +
                    "Edad: " + nd.cus.getAge() + "\n" +
                    "Género: " + nd.cus.getGender() + "\n" +
                    "Salario: $" + nd.cus.getSalary() + "\n" +
                    "Tipo de cliente: " + nd.cus.getCard().getType() + "\n" +
                    "Número tarjeta: " + nd.cus.getCard().getNumber() + "\n" +
                    "NIP: " + nd.cus.getCard().getNip() + "\n" +
                    "Saldo de tarjeta: $" + nd.cus.getCard().getBalance() + "\n" +
                    "Tipo de Crédito: " + nd.cus.getCredit().getTypeCred() + "\n" +
                    "Monto del Crédito: $" + nd.cus.getCredit().getAmount() + "\n";
                JOptionPane.showMessageDialog(null, messageInfo);
            } else {
                JOptionPane.showMessageDialog(null, "CLIENTE CON TARJETA: " + cardNumber + " NO ENCONTRADO");
            }
        } else if (ListFinal.ListC.findCus(cardNumber)) {
            nc = ListFinal.ListC.deleteNodeCreValue(cardNumber);
            if (nc != null) {
                nameCom = nc.cus.getName() + " " + nc.cus.getSurname1() + " " + nc.cus.getSurname2();
                String messageInfo = "CLIENTE ELIMINADO EXITOSAMENTE\n" +
                    "Nombre: " + nameCom + "\n" +
                    "Edad: " + nc.cus.getAge() + "\n" +
                    "Género: " + nc.cus.getGender() + "\n" +
                    "Salario: $" + nc.cus.getSalary() + "\n" +
                    "Tipo de cliente: " + nc.cus.getCard().getType() + "\n" +
                    "Número tarjeta: " + nc.cus.getCard().getNumber() + "\n" +
                    "NIP: " + nc.cus.getCard().getNip() + "\n" +
                    "Saldo de crédito tarjeta: $" + nc.cus.getCard().getCreditBalance() + "\n" +
                    "Tipo de Crédito: " + nc.cus.getCredit().getTypeCred() + "\n" +
                    "Monto del Crédito: $" + nc.cus.getCredit().getAmount() + "\n";
                JOptionPane.showMessageDialog(null, messageInfo);
            } else {
                JOptionPane.showMessageDialog(null, "CLIENTE CON TARJETA: " + cardNumber + " NO ENCONTRADO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "CLIENTE NO EXISTENTE\nInténtalo nuevamente");
        }
    }
}
