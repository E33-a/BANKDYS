package com.mycompany.bank;
import javax.swing.JOptionPane;

public class Atm {
    private static double moneyT; // Variable estática para el dinero total del ATM
    private static boolean inService; // Variable estática para indicar si el ATM está en servicio

    // Método para establecer el dinero total del ATM
    public static void setMoneyT(double moneyT) {
        Atm.inService = false; // Marca el ATM como fuera de servicio al establecer el dinero
        Atm.moneyT = moneyT;
    }

    // Método para establecer si el ATM está en servicio
    public static void setInService(boolean inService) {
        Atm.inService = inService;
    }

    // Método para obtener el dinero total del ATM
    public static double getMoneyT() {
        return moneyT;
    }

    // Método para verificar si el ATM está en servicio
    public static boolean isInService() {
        return inService;
    }

    // Método para que un cliente miembro inicie sesión
    public static void loginCustMember(Card card) {
        String nameCom;
        String nip;
        int cont;
        
        // Iterar a través de la colección de clientes
        for (Customer cus : ColectCust.getColectCus()) {
            if (cus.getCard() != null && cus.getCard().getNumber().equals(card.getNumber())) {
                nameCom = cus.getName() + " " + cus.getSurname1() + " " + cus.getSurname2();
                cont = 1;
                do {
                    if (cont == 3) {
                        JOptionPane.showMessageDialog(null, "Ultimo intento\nIngresa correctamente tu NIP");
                    }
                    nip = JOptionPane.showInputDialog(nameCom + " ¡bienvenido!\n\tIngresa tu NIP");
                    if (nip == null) {
                        JOptionPane.showMessageDialog(null, "Operacion cancelada"); // Cancelación de operación
                        return;
                    }
                    cont++;
                } while ((!nip.equals(cus.getCard().getNip())) && cont < 4);

                if (nip.equals(cus.getCard().getNip())) {
                    JOptionPane.showMessageDialog(null, "Acceso permitido");
                    optionsCus(cus); // Acceso a las opciones del cliente
                } else {
                    JOptionPane.showMessageDialog(null, "Acceso incorrecto");
                }
            }
        }
    }

    // Método para mostrar las opciones disponibles para el cliente
    public static void optionsCus(Customer cus) {
        int opc;
        char res;
        
        do{
            do{
                opc = Integer.parseInt(JOptionPane.showInputDialog("""
                                            DEPOSITO A:
                                            Elige una opcion:
                                             [1] Consultar saldo
                                             [2] Depositar
                                             [3] Retirar
                                             [4] Salir
                                            """));
            }while(opc < 1 || opc > 4);

            switch(opc){
                case 1 -> {
                    checkBalance(cus); // Consultar saldo
                }
                case 2 -> {
                    depositMoney(cus); // Depositar dinero
                }
                case 3 -> {
                    withdrawMoney(cus); // Retirar dinero
                }
                case 4 -> {
                    return;
                }
            }
            res = JOptionPane.showInputDialog("Deseas realizar otro accion  s/n: ").charAt(0);
        }while(Character.toUpperCase(res) == 'S');
    }

    // Método para consultar el saldo del cliente
    public static void checkBalance(Customer cus) {
        double balance = cus.getBalance();
        JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + balance);
    }

    // Método para depositar dinero en la cuenta del cliente
    public static void depositMoney(Customer cus) {
        double moneyDe;
        String cta;
        int op;

        JOptionPane.showMessageDialog(null, "Puedes ingresar hasta\n$5,000 como máximo\n$100 como mínimo");
        do {
            moneyDe = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la cantidad a depositar"));
            if (moneyDe < 100 || moneyDe > 5000) {
                JOptionPane.showMessageDialog(null, "Debes ingresar una cantidad válida\nIntenta nuevamente");
            }
        } while (moneyDe < 100 || moneyDe > 5000);

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("""
                                    DEPOSITO A:
                                    Elige una opción:
                                     [1] Cuenta propia
                                     [2] Cuenta externa
                                    """));
        } while (op < 1 || op > 2);

        switch (op) {
            case 1 -> {
                double balance = cus.getBalance();
                balance += moneyDe;
                cus.setBalance(balance);
                JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA cuenta propia");
            }
            case 2 -> {
                do {
                    cta = JOptionPane.showInputDialog("Ingresa la cuenta a la que depositarás: ");
                } while (cta == null || !cta.matches("\\d{16}")); // Verificar formato de cuenta (16 dígitos numéricos)

                double balance = cus.getBalance();
                if (moneyDe > balance) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la acción");
                } else {
                    JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA la cuenta: " + cta);
                    balance -= moneyDe;
                    cus.setBalance(balance);
                    JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getBalance());
                }
            }
        }
    }

    // Método para retirar dinero de la cuenta del cliente
    public static void withdrawMoney(Customer cus) {
        double mWithdraw;
        JOptionPane.showMessageDialog(null, "Puedes retirar hasta\n$15,000 como máximo\n$50 como mínimo");
        do {
            mWithdraw = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la cantidad a retirar"));
            if (mWithdraw < 50 || mWithdraw > 15000) {
                JOptionPane.showMessageDialog(null, "Debes retirar una cantidad válida\nIntenta nuevamente");
            }
        } while (mWithdraw < 50 || mWithdraw > 15000);

        double balance = cus.getBalance();
        if (mWithdraw > balance) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la acción");
        } else {
            balance -= mWithdraw;
            cus.setBalance(balance);
            JOptionPane.showMessageDialog(null, "Retiro correcto de $" + mWithdraw);
            JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getBalance());
        }
    }
}
