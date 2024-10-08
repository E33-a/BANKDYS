package Bank.ATM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import Bank.Customer.Customer;
import Bank.Customer.CustomerCredit;
import Bank.Customer.CustomerDebit;
import Bank.Customer.CustomerPayroll;

public class OpAtm {
    
    private static String Date(){
        LocalDateTime fechaHoy = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fecha = fechaHoy.format(formatDate);
        String time = fechaHoy.format(formatTime);
        String date = "\nFecha: " + fecha + "\nHora: " + time;
        return date;
    }
    private static int Op(){
        int op;
        op = 0;

        try{
            op = Integer.parseInt(JOptionPane.showInputDialog(
    "DEPÓSITO A:\n" +
    "Elige una opción:\n" +
    "[1] Cuenta propia\n" +
    "[2] Cuenta externa"));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
        }
        return op;
    }
        
    // Método para consultar el saldo del cliente // son sobrecargados dependiendo del tipo de cliente y tarjeta
    public static void checkBalance(CustomerPayroll cus) {
        double balance = cus.getCard().getBalance();
        JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + balance + "\n\nOperación realizada en:" + Date());
    }
    public static void checkBalance(CustomerCredit cus) {
        double balance = cus.getCard().getCreditBalance();
        JOptionPane.showMessageDialog(null, "Tu saldo de credito actual es: \n$" + balance + "\n\nOperación realizada en:" + Date());
    }
    public static void checkBalance(CustomerDebit cus) {
        double balance = cus.getCard().getBalance();
        JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + balance + "\n\nOperación realizada en:" + Date());
    }

    // Método para depositar dinero en la cuenta del cliente
    public static void depositMoney(CustomerCredit cus) {
        double moneyDe, balance;
        String cta;
        int op;

        JOptionPane.showMessageDialog(null, "Puedes ingresar hasta\n$5,000 como máximo\n$100 como mínimo");
        moneyDe = 0;
        do {
            try{
                moneyDe = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la cantidad a depositar"));
                if (moneyDe < 100 || moneyDe > 5000) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar una cantidad válida\nInténtalo nuevamente");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el depósito.");
            }
        } while (moneyDe < 100 || moneyDe > 5000);

        do {
            op = Op();
        } while (op < 1 || op > 2);

        switch (op) {
            case 1:
                balance = cus.getCard().getCreditBalance();
                balance += moneyDe;
                cus.getCard().setCreditBalance(balance);
                JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA cuenta propia" + "\n\nOperación realizada en:" + Date());
            break;
            case 2:
                do {
                    cta = JOptionPane.showInputDialog("Ingresa la cuenta a la que depositarás: ");
                } while (cta == null || !cta.matches("\\d{16}")); // Verificar formato de cuenta (16 dígitos numéricos)

                balance = cus.getCard().getCreditBalance();
                if (moneyDe > balance) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la acción");
                } else {
                    JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA la cuenta: " + cta + "\n\nOperación realizada en:" + Date());
                    balance -= moneyDe;
                    cus.getCard().setCreditBalance(balance);
                    JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getCard().getCreditBalance());
                }
            break;
        }
    }
    public static void depositMoney(CustomerPayroll cus) {
        double moneyDe, balance;
        String cta;
        int op;

        JOptionPane.showMessageDialog(null, "Puedes ingresar hasta\n$5,000 como máximo\n$100 como mínimo");
        moneyDe = 0;
        do {
            try{
                moneyDe = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la cantidad a depositar"));
                if (moneyDe < 100 || moneyDe > 5000) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar una cantidad válida\nInténtalo nuevamente");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el depósito.");
            }
        } while (moneyDe < 100 || moneyDe > 5000);

        do {
           op = Op();
        } while (op < 1 || op > 2);

        switch (op) {
            case 1:
                balance = cus.getCard().getBalance();
                balance += moneyDe;
                cus.getCard().setBalance(balance);
                JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA cuenta propia" + "\n\nOperación realizada en:" + Date());
            break;
            case 2:
                do {
                    cta = JOptionPane.showInputDialog("Ingresa la cuenta a la que depositarás: ");
                } while (cta == null || !cta.matches("\\d{16}")); // Verificar formato de cuenta (16 dígitos numéricos)

                balance = cus.getCard().getBalance();
                if (moneyDe > balance) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la acción");
                } else {
                    JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA la cuenta: " + cta + "\n\nOperación realizada en:" + Date());
                    balance -= moneyDe;
                    cus.getCard().setBalance(balance);
                    JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getCard().getBalance());
                }
            break;
        }
    }
    public static void depositMoney(CustomerDebit cus) {
        double moneyDe, balance;
        String cta;
        int op;

        JOptionPane.showMessageDialog(null, "Puedes ingresar hasta\n$5,000 como máximo\n$100 como mínimo");
        moneyDe = 0;
        do {
             try{
                moneyDe = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la cantidad a depositar"));
                if (moneyDe < 100 || moneyDe > 5000) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar una cantidad válida\nInténtalo nuevamente");
                }
             } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
             }
        } while (moneyDe < 100 || moneyDe > 5000);

        do {
            op = Op();
        } while (op < 1 || op > 2);

        switch (op) {
            case 1:
                balance = cus.getCard().getBalance();
                balance += moneyDe;
                cus.getCard().setBalance(balance);
                JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA cuenta propia" + "\n\nOperación realizada en:" + Date());
            break;
            case 2:
                do {
                    cta = JOptionPane.showInputDialog("Ingresa la cuenta a la que depositarás: ");
                } while (cta == null || !cta.matches("\\d{16}")); // Verificar formato de cuenta (16 dígitos numéricos)

                balance = cus.getCard().getBalance();
                if (moneyDe > balance) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la acción");
                } else {
                    JOptionPane.showMessageDialog(null, "Depósito correcto de $" + moneyDe + "\nA la cuenta: " + cta + "\n\nOperación realizada en:" + Date());
                    balance -= moneyDe;
                    cus.getCard().setBalance(balance);
                    JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getCard().getBalance());
                }
            break;
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
                JOptionPane.showMessageDialog(null, "Selecciona una cantidad válida");
                continue;//volver a repetir si no fue exitoso
            }
            if (mWithdraw < 50 || mWithdraw > 15000) {
                JOptionPane.showMessageDialog(null, "Debes retirar una cantidad válida\nInténtalo nuevamente");
            }
            else if(ATM.getMoneyT() < mWithdraw){
                JOptionPane.showMessageDialog(null, "El cajero no tiene esa cantidad\nInténtalo nuevamente");
            }

        } while (mWithdraw < 50 || mWithdraw > 15000 || (mWithdraw > ATM.getMoneyT()));

        double atmres = ATM.getMoneyT();
        
        double balance = cus.getCard().getBalance();

        if (mWithdraw > balance || mWithdraw > atmres) {
            if (mWithdraw > balance) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                return;
            }
            else if (mWithdraw > atmres) {
                JOptionPane.showMessageDialog(null, "Saldo del cajero insuficiente");
                return;
            }
        } 
        else if (mWithdraw <= balance && mWithdraw <= atmres) {
            balance -= mWithdraw;
            atmres -= mWithdraw;
            ATM.setMoneyT(atmres);
            cus.getCard().setBalance(balance);
            JOptionPane.showMessageDialog(null, "Retiro correcto de $" + mWithdraw + "\n\nOperación realizada en:" + Date());
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
                JOptionPane.showMessageDialog(null, "Selecciona una cantidad válida");
                continue;
            }
            if (mWithdraw < 50 || mWithdraw > 15000) {
                JOptionPane.showMessageDialog(null, "Debes retirar una cantidad válida\nInténtalo nuevamente");
            }
            else if(ATM.getMoneyT() < mWithdraw){
                JOptionPane.showMessageDialog(null, "El cajero no tiene esa cantidad\nInténtalo nuevamente");
            }

        } while (mWithdraw < 50 || mWithdraw > 15000 || (mWithdraw > ATM.getMoneyT()));

        double atmres = ATM.getMoneyT();
        
        double balance = cus.getCard().getBalance();

        if (mWithdraw > balance || mWithdraw > atmres) {
            if (mWithdraw > balance) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                return;
            }
            else if (mWithdraw > atmres) {
                JOptionPane.showMessageDialog(null, "Saldo del cajero insuficiente");
                return;
            }
        } 
        else if (mWithdraw <= balance && mWithdraw <= atmres) {
            balance -= mWithdraw;
            atmres -= mWithdraw;
            ATM.setMoneyT(atmres);
            cus.getCard().setBalance(balance);
            JOptionPane.showMessageDialog(null, "Retiro correcto de $" + mWithdraw + "\n\nOperación realizada en:" + Date());
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
                JOptionPane.showMessageDialog(null, "Selecciona una cantidad válida");
                continue;
            }
            if (mWithdraw < 50 || mWithdraw > 15000) {
                JOptionPane.showMessageDialog(null, "Debes retirar una cantidad válida\nInténtalo nuevamente");
            }
            else if(ATM.getMoneyT() < mWithdraw){
                JOptionPane.showMessageDialog(null, "El cajero no tiene esa cantidad\nInténtalo nuevamente");
            }

        } while (mWithdraw < 50 || mWithdraw > 15000 || (mWithdraw > ATM.getMoneyT()));

        double atmres = ATM.getMoneyT();
        
        double balance = cus.getCard().getCreditBalance();

        if (mWithdraw > balance || mWithdraw > atmres) {
            if (mWithdraw > balance) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                return;
            }
            else if (mWithdraw > atmres) {
                JOptionPane.showMessageDialog(null, "Saldo del cajero insuficiente");
                return;
            }
        } 
        else if (mWithdraw <= balance && mWithdraw <= atmres) {
            balance -= mWithdraw;
            atmres -= mWithdraw;
            ATM.setMoneyT(atmres);
            cus.getCard().setCreditBalance(balance);
            JOptionPane.showMessageDialog(null, "Retiro correcto de $" + mWithdraw + "\n\nOperación realizada en:" + Date());
            JOptionPane.showMessageDialog(null, "Tu saldo actual es: \n$" + cus.getCard().getCreditBalance());
        }

    }

    public static void changeNIP(Customer cus) {
        String newNIP, confirmNIP, nameCom;
        nameCom = cus.getName() + " " + cus.getSurname1() + " " + cus.getSurname2();
        try{
            // Primer bucle: pedir el nuevo NIP
            do {
                newNIP = JOptionPane.showInputDialog("CAMBIAR NIP\n\nHola " + nameCom + "\nIngresa el nuevo NIP:\n");
                if (newNIP == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    return; // Salir si se cancela
                }
                if (newNIP.length() >= 4) {
                    newNIP = newNIP.substring(0, 4); // Almacenar solo los primeros 4 caracteres
                }
                if (newNIP.matches("\\d{4}")) {
                    break; // Salir del bucle si el NIP es válido
                } else {
                    JOptionPane.showMessageDialog(null, "El NIP debe ser numérico y tener exactamente 4 dígitos.");
                }
            } while (true);
        
            // Segundo bucle: confirmar el nuevo NIP
            do {
                confirmNIP = JOptionPane.showInputDialog("CONFIRMAR NUEVO NIP\n\nNuevo NIP:\n");
                if (confirmNIP == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    return; // Salir si se cancela
                }
                if (confirmNIP.length() >= 4) {
                    confirmNIP = confirmNIP.substring(0, 4); // Almacenar solo los primeros 4 caracteres
                }
                if (!confirmNIP.matches("\\d{4}")) {
                    JOptionPane.showMessageDialog(null, "El NIP debe ser numérico y tener exactamente 4 dígitos.");
                    continue; // Repetir si el NIP no es válido
                }
        
                if (newNIP.equals(confirmNIP)) {
                    cus.getCard().setNip(confirmNIP);
                    JOptionPane.showMessageDialog(null, "CAMBIO DE NIP\n\nExitoso");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "CAMBIO DE NIP\n\nIncorrecto\nIngresa correctamente el nuevo NIP\n");
                }
            } while (!newNIP.equals(confirmNIP));
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al capturar el nuevo NIP");
        }
    }
}
