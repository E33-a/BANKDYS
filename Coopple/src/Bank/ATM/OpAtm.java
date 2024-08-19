package Bank.ATM;

import javax.swing.JOptionPane;

import Bank.Customer.CustomerCredit;
import Bank.Customer.CustomerDebit;
import Bank.Customer.CustomerPayroll;

public class OpAtm {
        
    // Método para consultar el saldo del cliente // son sobrecargados dependiendo del tipo de cliente y tarjeta
    public static void checkBalance(CustomerPayroll cus) {
        double balance = cus.getCard().getBalance();
        JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + balance);
    }
    public static void checkBalance(CustomerCredit cus) {
        double balance = cus.getCard().getCreditBalance();
        JOptionPane.showMessageDialog(null, "Tu saldo de credito actual es: \n$" + balance);
    }
    public static void checkBalance(CustomerDebit cus) {
        double balance = cus.getCard().getBalance();
        JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + balance);
    }

    // Método para depositar dinero en la cuenta del cliente
    public static void depositMoney(CustomerCredit cus) {
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
                double balance = cus.getCard().getCreditBalance();
                balance += moneyDe;
                cus.getCard().setCreditBalance(balance);
                JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA cuenta propia");
            }
            case 2 -> {
                do {
                    cta = JOptionPane.showInputDialog("Ingresa la cuenta a la que depositarás: ");
                } while (cta == null || !cta.matches("\\d{16}")); // Verificar formato de cuenta (16 dígitos numéricos)

                double balance = cus.getCard().getCreditBalance();
                if (moneyDe > balance) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la acción");
                } else {
                    JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA la cuenta: " + cta);
                    balance -= moneyDe;
                    cus.getCard().setCreditBalance(balance);
                    JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getCard().getCreditBalance());
                }
            }
        }
    }
    public static void depositMoney(CustomerPayroll cus) {
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
                double balance = cus.getCard().getBalance();
                balance += moneyDe;
                cus.getCard().setBalance(balance);
                JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA cuenta propia");
            }
            case 2 -> {
                do {
                    cta = JOptionPane.showInputDialog("Ingresa la cuenta a la que depositarás: ");
                } while (cta == null || !cta.matches("\\d{16}")); // Verificar formato de cuenta (16 dígitos numéricos)

                double balance = cus.getCard().getBalance();
                if (moneyDe > balance) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la acción");
                } else {
                    JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA la cuenta: " + cta);
                    balance -= moneyDe;
                    cus.getCard().setBalance(balance);
                    JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getCard().getBalance());
                }
            }
        }
    }
    public static void depositMoney(CustomerDebit cus) {
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
                double balance = cus.getCard().getBalance();
                balance += moneyDe;
                cus.getCard().setBalance(balance);
                JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA cuenta propia");
            }
            case 2 -> {
                do {
                    cta = JOptionPane.showInputDialog("Ingresa la cuenta a la que depositarás: ");
                } while (cta == null || !cta.matches("\\d{16}")); // Verificar formato de cuenta (16 dígitos numéricos)

                double balance = cus.getCard().getBalance();
                if (moneyDe > balance) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la acción");
                } else {
                    JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA la cuenta: " + cta);
                    balance -= moneyDe;
                    cus.getCard().setBalance(balance);
                    JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getCard().getBalance());
                }
            }
        }
    }

    // Método para retirar dinero de la cuenta del cliente
    public static void withdrawMoney(CustomerPayroll cus) {
        double mWithdraw = 0;
        JOptionPane.showMessageDialog(null, "Puedes retirar hasta\n$15,000 como máximo\n$50 como mínimo");
        do {
            String in = JOptionPane.showInputDialog("Ingresa la cantidad a retirar");

            if(in == null){//si no se da respuesta en joption
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            try{//tratar de hacer la conversion
                mWithdraw = Double.parseDouble(in);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Selecciona una cantidad valida");
                continue;//volver a repetir si no fue exitoso
            }
            if (mWithdraw < 50 || mWithdraw > 15000) {
                JOptionPane.showMessageDialog(null, "Debes retirar una cantidad válida\nIntenta nuevamente");
            }
            else if(ATM.getMoneyT() < mWithdraw){
                JOptionPane.showMessageDialog(null, "El cajero no tiene esa cantidad\nIntenta nuevamente");
            }

        } while (mWithdraw < 50 || mWithdraw > 15000 || (mWithdraw > ATM.getMoneyT()));

        double atmres = ATM.getMoneyT();
        
        double balance = cus.getCard().getBalance();

        if (mWithdraw > balance || mWithdraw > atmres) {
            JOptionPane.showMessageDialog(null, "No se puede realizar la acción");
        } 
        else if (mWithdraw <= balance && mWithdraw <= atmres) {
            balance -= mWithdraw;
            atmres -= mWithdraw;
            ATM.setMoneyT(atmres);
            cus.getCard().setBalance(balance);
            JOptionPane.showMessageDialog(null, "Retiro correcto de $" + mWithdraw);
            JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getCard().getBalance());
        }
    }
    public static void withdrawMoney(CustomerDebit cus) {
        double mWithdraw = 0;
        JOptionPane.showMessageDialog(null, "Puedes retirar hasta\n$15,000 como máximo\n$50 como mínimo");
        do {
            String in = JOptionPane.showInputDialog("Ingresa la cantidad a retirar");

            if(in == null){//si no se da respuesta en joption
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            try{
                mWithdraw = Double.parseDouble(in);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Selecciona una cantidad valida");
                continue;
            }
            if (mWithdraw < 50 || mWithdraw > 15000) {
                JOptionPane.showMessageDialog(null, "Debes retirar una cantidad válida\nIntenta nuevamente");
            }
            else if(ATM.getMoneyT() < mWithdraw){
                JOptionPane.showMessageDialog(null, "El cajero no tiene esa cantidad\nIntenta nuevamente");
            }

        } while (mWithdraw < 50 || mWithdraw > 15000 || (mWithdraw > ATM.getMoneyT()));

        double atmres = ATM.getMoneyT();
        
        double balance = cus.getCard().getBalance();

        if (mWithdraw > balance || mWithdraw > atmres) {
            JOptionPane.showMessageDialog(null, "No se puede realizar la acción");
        } 
        else if (mWithdraw <= balance && mWithdraw <= atmres) {
            balance -= mWithdraw;
            atmres -= mWithdraw;
            ATM.setMoneyT(atmres);
            cus.getCard().setBalance(balance);
            JOptionPane.showMessageDialog(null, "Retiro correcto de $" + mWithdraw);
            JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getCard().getBalance());
        }
    }
    public static void withdrawMoney(CustomerCredit cus) {
        double mWithdraw = 0;
        JOptionPane.showMessageDialog(null, "Puedes retirar hasta\n$15,000 como máximo\n$50 como mínimo");
        do {
            String in = JOptionPane.showInputDialog("Ingresa la cantidad a retirar");

            if(in == null){//si no se da respuesta en joption
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }
            try{
                mWithdraw = Double.parseDouble(in);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Selecciona una cantidad valida");
                continue;
            }
            if (mWithdraw < 50 || mWithdraw > 15000) {
                JOptionPane.showMessageDialog(null, "Debes retirar una cantidad válida\nIntenta nuevamente");
            }
            else if(ATM.getMoneyT() < mWithdraw){
                JOptionPane.showMessageDialog(null, "El cajero no tiene esa cantidad\nIntenta nuevamente");
            }

        } while (mWithdraw < 50 || mWithdraw > 15000 || (mWithdraw > ATM.getMoneyT()));

        double atmres = ATM.getMoneyT();
        
        double balance = cus.getCard().getCreditBalance();

        if (mWithdraw > balance || mWithdraw > atmres) {
            JOptionPane.showMessageDialog(null, "No se puede realizar la acción");
        } 
        else if (mWithdraw <= balance && mWithdraw <= atmres) {
            balance -= mWithdraw;
            atmres -= mWithdraw;
            ATM.setMoneyT(atmres);
            cus.getCard().setCreditBalance(balance);
            JOptionPane.showMessageDialog(null, "Retiro correcto de $" + mWithdraw);
            JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getCard().getCreditBalance());
        }
    }
}
