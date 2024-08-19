package Bank.ATM;

import javax.swing.JOptionPane;

import Bank.ListFinal;
import Structures.NodeCr;
import Structures.NodeDe;
import Structures.NodePay;

public class logShowDel {
    public static void typeLoggin(String cardNumber){

        if (ListFinal.ListP.findCus(cardNumber)) {
            ATM.logginPayroll(cardNumber);
            return;
        }
        else if (ListFinal.ListD.findCus(cardNumber)) {
            ATM.logginDebit(cardNumber);
            return;
        }
        else if (ListFinal.ListC.findCus(cardNumber)) {
            ATM.logginCredit(cardNumber);
            return;
        }
        if (!ListFinal.ListP.findCus(cardNumber) && !ListFinal.ListD.findCus(cardNumber) && !ListFinal.ListC.findCus(cardNumber)) {
            JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO\nIntente nuevamente");
        return;
        }
    }

    public static void showFound(String cardNumber){

        if (ListFinal.ListP.findCus(cardNumber)) {
            ListFinal.ListP.searchCus(cardNumber);
            return;
        }
        else if (ListFinal.ListD.findCus(cardNumber)) {
            ListFinal.ListD.searchCus(cardNumber);
            return;
        }
        else if (ListFinal.ListC.findCus(cardNumber)) {
            ListFinal.ListC.searchCus(cardNumber);
            return;
        }
        if (!ListFinal.ListP.findCus(cardNumber) && !ListFinal.ListD.findCus(cardNumber) && !ListFinal.ListC.findCus(cardNumber)) {
            JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO\nIntente nuevamente");
        return;
        }
    }

    public static void showEveryone(){
        int opc;
        opc = -1;
        do{
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                    MOSTRAR CLIENTES:
                                                                    \n[1] Nomina
                                                                    \n[2] Debito
                                                                    \n[3] Credito\n
                                                                        """));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
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
        }
    }

    private static void showEveryonePay(){
        if(!ListFinal.ListP.isEmpty()){
            ListFinal.ListP.printForward();
            return;
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia\nPrimero agrega clientes de nomina");
            return;
        }
    }
    private static void showEveryoneDeb(){
        if(!ListFinal.ListD.isEmpty()){
            ListFinal.ListD.printForward();
            return;
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia\nPrimero agrega clientes de nomina");
            return;
        }
    }
    private static void showEveryoneCre(){
        if(!ListFinal.ListC.isEmpty()){
            ListFinal.ListC.printForward();
            return;
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia\nPrimero agrega clientes de nomina");
            return;
        }
    }

    public static void delCustomer(String cardNumber){
        NodePay np;
        NodeDe nd;
        NodeCr nc;

        String nameCom = "";
        
        if (ListFinal.ListP.findCus(cardNumber)) {
            np = ListFinal.ListP.deleteNodePayValue(cardNumber);
            if (np != null){
                nameCom = np.cus.getName() + " " + np.cus.getSurname1() + " " + np.cus.getSurname2();
                String messageInfo = """
                        \tCLIENTE ELIMINADO EXITOSAMENTE
                            \nNombre: """ + nameCom + """
                            \nEdad: """ + np.cus.getAge() + """
                            \nGenero: """ + np.cus.getGender() + """
                            \nSalario: $""" + np.cus.getSalary() + """
                            \nTipo de cliente: """ +  np.cus.getCard().getType() + """
                            \nNumero tarjeta: """ + np.cus.getCard().getNumber() + """
                            \nNIP: """ + np.cus.getCard().getNip() + """
                            \nSaldo de tarjeta: $""" + np.cus.getCard().getBalance() + """
                            \nTipo de Credito: """ + np.cus.getCredit().getTypeCred() + """
                            \nMonto del Credito: $""" + np.cus.getCredit().getAmount() + """
                            \n""";
                JOptionPane.showMessageDialog(null, messageInfo);
            } else {
                JOptionPane.showMessageDialog(null, "CLIENTE CON TARJETA: " + cardNumber + " NO ENCONTRADO");
            }
            return;
        }
        else if (ListFinal.ListD.findCus(cardNumber)) {
            nd = ListFinal.ListD.deleteNodeDeValue(cardNumber);
            if (nd != null){
                nameCom = nd.cus.getName() + " " + nd.cus.getSurname1() + " " + nd.cus.getSurname2();
                String messageInfo = """
                        \tCLIENTE ELIMINADO EXITOSAMENTE
                            \nNombre: """ + nameCom + """
                            \nEdad: """ + nd.cus.getAge() + """
                            \nGenero: """ + nd.cus.getGender() + """
                            \nSalario: $""" + nd.cus.getSalary() + """
                            \nTipo de cliente: """ +  nd.cus.getCard().getType() + """
                            \nNumero tarjeta: """ + nd.cus.getCard().getNumber() + """
                            \nNIP: """ + nd.cus.getCard().getNip() + """
                            \nSaldo de tarjeta: $""" + nd.cus.getCard().getBalance() + """
                            \nTipo de Credito: """ + nd.cus.getCredit().getTypeCred() + """
                            \nMonto del Credito: $""" + nd.cus.getCredit().getAmount() + """
                            \n""";
                JOptionPane.showMessageDialog(null, messageInfo);
            } else {
                JOptionPane.showMessageDialog(null, "CLIENTE CON TARJETA: " + cardNumber + " NO ENCONTRADO");
            }
            return;
        }
        else if (ListFinal.ListC.findCus(cardNumber)) {
            nc = ListFinal.ListC.deleteNodeCreValue(cardNumber);
            if (nc != null){
                nameCom = nc.cus.getName() + " " + nc.cus.getSurname1() + " " + nc.cus.getSurname2();
                String messageInfo = """
                        \tCLIENTE ELIMINADO EXITOSAMENTE
                            \nNombre: """ + nameCom + """
                            \nEdad: """ + nc.cus.getAge() + """
                            \nGenero: """ + nc.cus.getGender() + """
                            \nSalario: $""" + nc.cus.getSalary() + """
                            \nTipo de cliente: """ +  nc.cus.getCard().getType() + """
                            \nNumero tarjeta: """ + nc.cus.getCard().getNumber() + """
                            \nNIP: """ + nc.cus.getCard().getNip() + """
                            \nSaldo de credito tarjeta: $""" + nc.cus.getCard().getCreditBalance() + """
                            \nTipo de Credito: """ + nc.cus.getCredit().getTypeCred() + """
                            \nMonto del Credito: $""" + nc.cus.getCredit().getAmount() + """
                            \n""";
                JOptionPane.showMessageDialog(null, messageInfo);
            } else {
                JOptionPane.showMessageDialog(null, "CLIENTE CON TARJETA: " + cardNumber + " NO ENCONTRADO");
            }
            return;
        }
        if (!ListFinal.ListP.findCus(cardNumber) && !ListFinal.ListD.findCus(cardNumber) && !ListFinal.ListC.findCus(cardNumber)) {
            JOptionPane.showMessageDialog(null, "CLIENTE NO EXISTENTE\nIntente nuevamente");
        return;
        }
    }
}
