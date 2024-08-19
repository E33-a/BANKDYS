package Coopple;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Structures.DoubleListCr;
import Structures.DoubleListDe;
import Structures.DoubleListPay;
import Structures.NodeCr;
import Structures.NodeDe;
import Structures.NodePay;

public class ListCust implements Files{
    public static DoubleListPay listPayroll = new DoubleListPay();
    //public DoubleListPay listPayrollTemp = new DoubleListPay();//lista para escribir en txt

    public static DoubleListDe listDebit = new DoubleListDe();
    //public DoubleListDe listDebitTemp = new DoubleListDe();//lista para escribir en txt

    public static DoubleListCr listCredit = new DoubleListCr();
    //public DoubleListCr listCreditTemp = new DoubleListCr();//lista para escribir en txt

    
    public static void readCusCaPay(String path){ //leer todas las lineas
        File file = new File(path); 

        try {
            BufferedReader in = new BufferedReader(new FileReader(file)); 
            String reading; //primera linea

            while ((reading = in.readLine()) != null){
                String parts[] = reading.split(",");
                String name = parts[0];
                String surname1 = parts[1];
                String surname2 = parts[2];
                int age = Integer.parseInt(parts[3]);
                char gender = parts[4].charAt(0);
                double salary = Double.parseDouble(parts[5]);
                String number = parts[6];
                String nip = parts[7];
                String type = parts[8];
                double balance = Double.parseDouble(parts[9]);
                double amount = Double.parseDouble(parts[10]);
                double interest = Double.parseDouble(parts[11]);
                int fees = Integer.parseInt(parts[12]);
                String typeCred = parts[13];
                
                CardPayroll CardP = new CardPayroll(number, nip, type, balance);
                CreditC CredC = new CreditC(amount, interest, fees, typeCred);
                listPayroll.insertBegining(new CustomerPayroll(name, surname1, surname2, age, gender, salary, CredC, CardP));
            }

            in.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    } 

    public static void readCusCaDeb(String path){ //leer todas las lineas
        File file = new File(path); 

        try {
            BufferedReader in = new BufferedReader(new FileReader(file)); 
            String reading; //primera linea

            while ((reading = in.readLine()) != null){
                String parts[] = reading.split(",");
                String name = parts[0];
                String surname1 = parts[1];
                String surname2 = parts[2];
                int age = Integer.parseInt(parts[3]);
                char gender = parts[4].charAt(0);
                double salary = Double.parseDouble(parts[5]);
                String number = parts[6];
                String nip = parts[7];
                String type = parts[8];
                double balance = Double.parseDouble(parts[9]);
                double discount = Double.parseDouble(parts[10]);
                double amount = Double.parseDouble(parts[11]);
                double interest = Double.parseDouble(parts[12]);
                int fees = Integer.parseInt(parts[13]);
                String typeCred = parts[14];
                
                CardDebit CardD = new CardDebit(number, nip, type, balance, discount);
                CreditC CredC = new CreditC(amount, interest, fees, typeCred);
                listDebit.insertBegining(new CustomerDebit(name, surname1, surname2, age, gender, salary, CredC, CardD));
            }

            in.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void readCusCaCre(String path){ //leer todas las lineas
        File file = new File(path); 

        try {
            BufferedReader in = new BufferedReader(new FileReader(file)); 
            String reading; //primera linea

            while ((reading = in.readLine()) != null){
                String parts[] = reading.split(",");
                String name = parts[0];
                String surname1 = parts[1];
                String surname2 = parts[2];
                int age = Integer.parseInt(parts[3]);
                char gender = parts[4].charAt(0);
                double salary = Double.parseDouble(parts[5]);
                String number = parts[6];
                String nip = parts[7];
                String type = parts[8];
                double debt = Double.parseDouble(parts[9]);
                double cardInterest = Double.parseDouble(parts[10]);
                double discount = Double.parseDouble(parts[11]);
                double amount = Double.parseDouble(parts[12]);
                double interest = Double.parseDouble(parts[13]);
                int fees = Integer.parseInt(parts[14]);
                String typeCred = parts[15];
                
                CardCredit CardC = new CardCredit(number, nip, type, debt, cardInterest, discount);
                CreditC CredC = new CreditC(amount, interest, fees, typeCred);
                listCredit.insertBegining(new CustomerCredit(name, surname1, surname2, age, gender, salary, CredC, CardC));
            }

            in.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    //Guardar cleintes Payroll Card en txt
    public static void saveCustomersPay(String path, DoubleListPay Temp){
        File file = new File(path);
        //String lineSeparator = System.getProperty("line.separator");
        //Line separator sirve para gregar \r\n windows o \n unix
        try {
            //BuefferedWriter no sirvio ya que no saltaba la linea
            //BufferedWriter addLine = new BufferedWriter(new FileWriter(file, true));
            NodePay current = Temp.getHead();//Obtenemos el primer elemento de la lista
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
    
            //System.out.println("\nFile escrito");

                while (current != null){
                    /*addLine.write(
                        current.cus.getName() + "," + current.cus.getSurname1() + "," +
                        current.cus.getSurname2() + "," + current.cus.getAge() + "," +
                        current.cus.getGender() + "," + current.cus.getSalary() + "," +
                        current.cus.getCard().getNumber() + "," + current.cus.getCard().getNip() + "," +
                        current.cus.getCard().getType() + "," + current.cus.getCredit().getAmount() + "," +
                        current.cus.getCredit().getInterest() + "," + current.cus.getCredit().getFees() + "," +
                        current.cus.getCredit().getTypeCred());*/
                    out.println(current.cus.getName() + "," + current.cus.getSurname1() + "," +
                        current.cus.getSurname2() + "," + current.cus.getAge() + "," +
                        current.cus.getGender() + "," + current.cus.getSalary() + "," +
                        current.cus.getCard().getNumber() + "," + current.cus.getCard().getNip() + "," +
                        current.cus.getCard().getType() + "," + current.cus.getCard().getBalance() + "," +
                        current.cus.getCredit().getAmount() + "," + 
                        current.cus.getCredit().getFees() + "," + current.cus.getCredit().getTypeCred());

                        current = current.next;
                }
            //addLine.close();
            out.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    //Guardar cleintes Credit Card en txt
    public static void saveCustomersCred(String path, DoubleListCr Temp){
        File file = new File(path);
        try {
            NodeCr current = Temp.getHead();//Obtenemos el primer elemento de la lista
            PrintWriter out = new PrintWriter(new FileWriter(file, true));

                while (current != null){
                    out.println(current.cus.getName() + "," + current.cus.getSurname1() + "," +
                        current.cus.getSurname2() + "," + current.cus.getAge() + "," +
                        current.cus.getGender() + "," + current.cus.getSalary() + "," +
                        current.cus.getCard().getNumber() + "," + current.cus.getCard().getNip() + "," +
                        current.cus.getCard().getType() + "," + current.cus.getCard().getDebt() + "," +
                        current.cus.getCard().getCardInterest() + "," + current.cus.getCard().getDiscount() + "," + 
                        current.cus.getCredit().getAmount() + "," + current.cus.getCredit().getInterest() + "," + 
                        current.cus.getCredit().getFees() + "," + current.cus.getCredit().getTypeCred());

                        current = current.next;
                }
            out.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void saveCustomersDeb(String path, DoubleListDe Temp){
        File file = new File(path);
        
        try {
            NodeDe current = Temp.getHead();//Obtenemos el primer elemento de la lista
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
    
                while (current != null){
                    out.println(
                        current.cus.getName() + "," + current.cus.getSurname1() + "," +
                        current.cus.getSurname2() + "," + current.cus.getAge() + "," +
                        current.cus.getGender() + "," + current.cus.getSalary() + "," +
                        current.cus.getCard().getNumber() + "," + current.cus.getCard().getNip() + "," +
                        current.cus.getCard().getType() + "," + current.cus.getCard().getBalance() + "," +
                        current.cus.getCard().getDiscount() + "," + current.cus.getCredit().getAmount() + "," + 
                        current.cus.getCredit().getInterest() + "," + current.cus.getCredit().getFees() + "," + 
                        current.cus.getCredit().getTypeCred());

                        current = current.next;
                }
            out.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
