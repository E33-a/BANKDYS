package Bank.ATM;

import javax.swing.JOptionPane;

import Bank.BankAdd;
import Bank.Credit.CreditC;
import Bank.ListFInal.ListFinal;
import Structures.NodeCr;
import Structures.NodeDe;
import Structures.NodePay;

public class updateCus {
    private static void infoUpdate(NodePay current, String cardNumber){
        String name, surname1, surname2;
        int age;
        char gender;
        double salary;
        CreditC credit;//

        
        while(current != null){
            if(current.cus.getCard().getNumber().equals(cardNumber)){
                
                JOptionPane.showMessageDialog(null, "MODIFICAR DATOS DE CLIENTE");
                name = BankAdd.Name();
                    current.cus.setName(name);
                surname1 = BankAdd.Surname1();
                    current.cus.setSurname1(surname1);
                surname2 = BankAdd.Surname2();
                    current.cus.setSurname2(surname2);
                age = BankAdd.Age();
                    current.cus.setAge(age);
                gender = BankAdd.Gender();
                    current.cus.setGender(gender);
                salary = BankAdd.Salary();
                    current.cus.setSalary(salary);
                credit = BankAdd.Creditt();
                    current.cus.assingCredit(credit);
                return;
            }
        current = current.next;
        }
    }
    private static void infoUpdate(NodeDe current, String cardNumber){
        String name, surname1, surname2;
        int age;
        char gender;
        double salary;
        CreditC credit;//

        
        while(current != null){
            if(current.cus.getCard().getNumber().equals(cardNumber)){
                
                JOptionPane.showMessageDialog(null, "MODIFICAR DATOS DE CLIENTE");
                name = BankAdd.Name();
                    current.cus.setName(name);
                surname1 = BankAdd.Surname1();
                    current.cus.setSurname1(surname1);
                surname2 = BankAdd.Surname2();
                    current.cus.setSurname2(surname2);
                age = BankAdd.Age();
                    current.cus.setAge(age);
                gender = BankAdd.Gender();
                    current.cus.setGender(gender);
                salary = BankAdd.Salary();
                    current.cus.setSalary(salary);
                credit = BankAdd.Creditt();
                    current.cus.assingCredit(credit);
                return;
            }
        current = current.next;
        }
    }
    public static void updatePay(String cardNumber){
        NodePay current;
        current = ListFinal.ListP.getHead();

        if(!ListFinal.ListP.isEmpty()){//Mientras no este vacia
            infoUpdate(current, cardNumber);
        }
    }
    private static void infoUpdate(NodeCr current, String cardNumber){
        String name, surname1, surname2;
        int age;
        char gender;
        double salary;
        CreditC credit;//

        
        while(current != null){
            if(current.cus.getCard().getNumber().equals(cardNumber)){
                
                JOptionPane.showMessageDialog(null, "MODIFICAR DATOS DE CLIENTE");
                name = BankAdd.Name();
                    current.cus.setName(name);
                surname1 = BankAdd.Surname1();
                    current.cus.setSurname1(surname1);
                surname2 = BankAdd.Surname2();
                    current.cus.setSurname2(surname2);
                age = BankAdd.Age();
                    current.cus.setAge(age);
                gender = BankAdd.Gender();
                    current.cus.setGender(gender);
                salary = BankAdd.Salary();
                    current.cus.setSalary(salary);
                credit = BankAdd.Creditt();
                    current.cus.assingCredit(credit);
                return;
            }
        current = current.next;
        }
    }

    public static void updateDeb(String cardNumber){
        NodeDe current;
        current = ListFinal.ListD.getHead();

        if(!ListFinal.ListD.isEmpty()){//Mientras no este vacia
            infoUpdate(current, cardNumber);
        }
    }

    public static void updateCre(String cardNumber){
        NodeCr current;
        current = ListFinal.ListC.getHead();

        if(!ListFinal.ListC.isEmpty()){//Mientras no este vacia
            infoUpdate(current, cardNumber);
        }
    }
}
