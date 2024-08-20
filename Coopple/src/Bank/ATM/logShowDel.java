package Bank.ATM;

import javax.swing.JOptionPane;

import Bank.ListFInal.ListFinal;
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
        else {//if (!ListFinal.ListP.findCus(cardNumber) && !ListFinal.ListD.findCus(cardNumber) && !ListFinal.ListC.findCus(cardNumber)) {
            JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO\nInténtalo nuevamente");
        return;
        }
    }

    public static void showFound(String cardNumber){

        if (ListFinal.ListP.findCus(cardNumber)) {
            ListFinal.ListP.searchCus(cardNumber);
            return;
        }
        if (ListFinal.ListD.findCus(cardNumber)) {
            ListFinal.ListD.searchCus(cardNumber);
            return;
        }
        if (ListFinal.ListC.findCus(cardNumber)) {
            ListFinal.ListC.searchCus(cardNumber);
            return;
        }
        if (!ListFinal.ListP.findCus(cardNumber) && !ListFinal.ListD.findCus(cardNumber) && !ListFinal.ListC.findCus(cardNumber)) {
            JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO\nInténtalo nuevamente");
        return;
        }
    }

    public static void updateFound(String cardNumber){//Actualizar datos de un usuario

        if (ListFinal.ListP.findCus(cardNumber)) {
            updateCus.updatePay(cardNumber);
            return;
        }
        else if (ListFinal.ListD.findCus(cardNumber)) {
            updateCus.updateDeb(cardNumber);
            return;
        }
        else if (ListFinal.ListC.findCus(cardNumber)) {
            updateCus.updateCre(cardNumber);
            return;
        }
        if (!ListFinal.ListP.findCus(cardNumber) && !ListFinal.ListD.findCus(cardNumber) && !ListFinal.ListC.findCus(cardNumber)) {
            JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO\nInténtalo nuevamente");
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
                                                                    \n[1] Nómina
                                                                    \n[2] Débito
                                                                    \n[3] Crédito\n
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
        } else if(ListFinal.ListP.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista esta vacía\nPrimero agrega clientes de nómina");
            return;
        }
    }
    private static void showEveryoneDeb(){
        if(!ListFinal.ListD.isEmpty()){
            ListFinal.ListD.printForward();
            return;
        } else if (ListFinal.ListD.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista esta vacía\nPrimero agrega clientes de débito");
            return;
        }
    }
    private static void showEveryoneCre(){
        if(!ListFinal.ListC.isEmpty()){
            ListFinal.ListC.printForward();
            return;
        } else if (ListFinal.ListC.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista esta vacía\nPrimero agrega clientes de crédito");
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
                            \nGénero: """ + np.cus.getGender() + """
                            \nSalario: $""" + np.cus.getSalary() + """
                            \nTipo de cliente: """ +  np.cus.getCard().getType() + """
                            \nNúmero tarjeta: """ + np.cus.getCard().getNumber() + """
                            \nNIP: """ + np.cus.getCard().getNip() + """
                            \nSaldo de tarjeta: $""" + np.cus.getCard().getBalance() + """
                            \nTipo de Crédito: """ + np.cus.getCredit().getTypeCred() + """
                            \nMonto del Crédito: $""" + np.cus.getCredit().getAmount() + """
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
                            \nGénero: """ + nd.cus.getGender() + """
                            \nSalario: $""" + nd.cus.getSalary() + """
                            \nTipo de cliente: """ +  nd.cus.getCard().getType() + """
                            \nNúmero tarjeta: """ + nd.cus.getCard().getNumber() + """
                            \nNIP: """ + nd.cus.getCard().getNip() + """
                            \nSaldo de tarjeta: $""" + nd.cus.getCard().getBalance() + """
                            \nTipo de Crédito: """ + nd.cus.getCredit().getTypeCred() + """
                            \nMonto del Crédito: $""" + nd.cus.getCredit().getAmount() + """
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
                            \nGénero: """ + nc.cus.getGender() + """
                            \nSalario: $""" + nc.cus.getSalary() + """
                            \nTipo de cliente: """ +  nc.cus.getCard().getType() + """
                            \nNúmero tarjeta: """ + nc.cus.getCard().getNumber() + """
                            \nNIP: """ + nc.cus.getCard().getNip() + """
                            \nSaldo de crédito tarjeta: $""" + nc.cus.getCard().getCreditBalance() + """
                            \nTipo de Crédito: """ + nc.cus.getCredit().getTypeCred() + """
                            \nMonto del Crédito: $""" + nc.cus.getCredit().getAmount() + """
                            \n""";
                JOptionPane.showMessageDialog(null, messageInfo);
            } else {
                JOptionPane.showMessageDialog(null, "CLIENTE CON TARJETA: " + cardNumber + " NO ENCONTRADO");
            }
            return;
        }
        if (!ListFinal.ListP.findCus(cardNumber) && !ListFinal.ListD.findCus(cardNumber) && !ListFinal.ListC.findCus(cardNumber)) {
            JOptionPane.showMessageDialog(null, "CLIENTE NO EXISTENTE\nInténtalo nuevamente");
        return;
        }
    }
}
