package Coopple;

import Coopple.Receipt.Receipt;

public class Coopple {
    static String numberT;
    
    public static void main(String[] args) {
        System.out.println("fecha: " + Receipt.getDateFinal());
    }
}    






























/* 

        //DoubleList l1 = new DoubleList();
        Scanner scanner = new Scanner(System.in);
        char res, gender;
        String name, s1, s2;
        int age;
        double salary;
 
        Customer c1 = new Customer("Juan", "Perez", "Prado", 35, 'C', 3000, null, null);
        CardPayroll ca1 = new CardPayroll(15000);
        CreditC creD1 = new CreditC(20000, 0.20, 12, "AUTOMOVILISTICO");

        c1.assingCardPayroll(ca1);
        c1.assingCredit(creD1);

        c1.showInfoC();

        
        Files.makeFile("./FilesC/Products.txt");
        Files.writeFile("./FilesC/Products.txt", "Elmothor, cts");
        Files.readFileLine("./FilesC/Products.txt");
        Files.readFileAll("./FilesC/Products.txt");
        Files.deleteLinesFromFile("./FilesC/Products.txt", 1, 3);

 DoubleListCr listCredTemp = new DoubleListCr();//lista para escribir en txt
        do{
            CardCredit C1 = new CardCredit(-20000, 0.12, 0.15);
            CreditC cre1 = new CreditC(300000, 0.10, 36, "CASA");
            
            System.out.println("Nombre: "); name = scanner.nextLine();
            name = name.toUpperCase();
            scanner.nextLine();
            System.out.println("Apellido 1: "); s1 = scanner.nextLine();
            s1 = s1.toUpperCase();
            scanner.nextLine();
            System.out.println("Apellido 2: "); s2 = scanner.nextLine();
            s2 = s2.toUpperCase();
            System.out.println("Edad: "); age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Genero: "); gender = scanner.nextLine().charAt(0);
            gender = Character.toUpperCase(gender);
            System.out.println("Salario: "); salary = scanner.nextDouble();
           
            CustomerCredit cus = new CustomerCredit(name, s1, s2, age, gender, salary, cre1, C1);
            listCredTemp.insertBegining(cus);
            //l1.insertBegining(cus);


            scanner.nextLine();
            System.out.println("Deseas agregar un cliente nuevo: ");
            res = scanner.nextLine().charAt(0);
        } while (Character.toUpperCase(res) == 'S');
        ListCust.saveCustomersCred("./FilesC/CustomersCredit.txt", listCredTemp);
        //l1.printForward();
        scanner.close();
        
*/

        /* 
        ListCust.readCusCaCre("./FilesC/CustomersCredit.txt");
        ListCust.listCredit.printForward();
        String search;
        search = JOptionPane.showInputDialog("Ingresa cuenta a buscar: ");
        ListCust.listCredit.searchCus(search);*/
 
