package Bank;

import javax.swing.JOptionPane;

import Bank.Card.CardCredit;
import Bank.Card.CardDebit;
import Bank.Card.CardPayroll;
import Bank.Credit.CreditC;
import Bank.Customer.CustomerCredit;
import Bank.Customer.CustomerDebit;
import Bank.Customer.CustomerPayroll;
import Bank.ListFInal.ListFinal;

public class BankAdd {
    private static int optiion(){ //Funcion para optimizar el codigo
        int opc;
        opc = -1;
            do{
                try{
                    opc = Integer.parseInt(JOptionPane.showInputDialog("""
                                                    \nTipo de cliente
                                                    \n[1] Nomina
                                                    \n[2] Debito
                                                    \n[3] Credito\n
                                                                        """));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
                }
            } while (opc < 1 || opc > 3);
        return opc;
    }
    private static String Name(){
        String name;
        do {
            name = JOptionPane.showInputDialog("Ingresa el nombre: ");
            if (name != null) {
                name = name.toUpperCase();
            }
            if (name == null) {
                JOptionPane.showMessageDialog(null, "Los campos deben llenarse\n\tIntenta nuevamente");
            }
        } while (name == null);
        return name;
    }
    private static String Surname1(){
        String surname1;
        do {
            surname1 = JOptionPane.showInputDialog("Ingresa el primer apellido: ");
            if (surname1 != null) {
                surname1 = surname1.toUpperCase();
            }
            if (surname1 == null) {
                JOptionPane.showMessageDialog(null, "Los campos deben llenarse\n\tIntenta nuevamente");
            }
        } while (surname1 == null);
        return surname1;
    }
    private static String Surname2(){
        String surname2;
        do {
            surname2 = JOptionPane.showInputDialog("Ingresa el segundo apellido: ");
            if (surname2 != null) {
                surname2 = surname2.toUpperCase();
            }
            if (surname2 == null) {
                JOptionPane.showMessageDialog(null, "Los campos deben llenarse\n\tIntenta nuevamente");
            }
        } while (surname2 == null);
        return surname2;
    }
    private static int Age(){
        int age;
        age = -1;
        try{
            age = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad: "));
            if (age < 18 || age > 110) {
                JOptionPane.showMessageDialog(null, "La edad debe estar entre 18 y 110 años\n\tIntenta nuevamente");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para la edad.");
        }
        return age;
    }
    private static char Gender(){
        char gender;
        do{
            gender = JOptionPane.showInputDialog("Ingresa el genero  M/F").charAt(0);
            gender = Character.toUpperCase(gender);
        } while (gender != 'M' && gender != 'F');
        return gender;
    }
    private static CreditC Creditt(){
        int forCredit;
        double amount = 0, interest = 0;
        int fees = 0;
        String typeCred = "";
        forCredit = -1;
            do{
                try{
                    forCredit = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                            \n\t CREDITOS
                                                                            \n [1] CASA ($300,000, 36 meses, 12% interes)
                                                                            \n [2] AUTOMOVILISTICO($100,000, 24 meses, 15% interes)
                                                                            \n [3] ESTUDIANTIL($50,000, 12 meses, 10% interes)\n
                                                                                """));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
                }
            } while (forCredit < 1 || forCredit > 3);

            switch (forCredit) {
                case 1:
                    amount = 300000;
                    interest = 0.12;
                    fees = 36;
                    typeCred = "CASA";
                    break;
                case 2:
                    amount = 100000;
                    interest = 0.15;
                    fees = 26;
                    typeCred = "AUTOMOVILISTICO";
                    break;
                case 3:
                    amount = 50000;
                    interest = 0.10;
                    fees = 12;
                    typeCred = "ESTUDIANTIL";
                    break;
            }
            CreditC credit = new CreditC(amount, interest, fees, typeCred);
            return credit;
    }
    private static double Salary(){
        double salary;
        salary = -1;
        do {
            try{
                salary = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el salario: "));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el salario.");
            }
        } while (salary < 0 || salary > 1000000);
        return salary;
    }

    //Añadir un cliente
    public static void addCustomer(){
        int opc;
        char r;

        do{
            opc = optiion();
            switch(opc){
                case 1:
                    addPayroll();
                    break;
                case 2:
                    addDebit();
                    break;
                case 3:
                    addCredit();
                    break;
            }
            r = JOptionPane.showInputDialog("Agregar mas clientes s/n").charAt(0);
        } while (Character.toUpperCase(r) == 'S');
    }

    private static void addPayroll(){
        Character res;
        String name, surname1, surname2;
        char gender;
        int age;
        double balance, salary;
        //boolean isNum;

        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de registro de usuarios de BANKDYS\n\tA continuación introduce a los usuarios");
        do {
            do {
                JOptionPane.showMessageDialog(null, "INGRESAR DATOS DE NUEVO CLIENTE NOMINA");

                // Validación y asignación del nombre
                name = Name();

                // Validación y asignación del primer apellido
                surname1 = Surname1();

                // Validación y asignación del segundo apellido
                surname2 = Surname2();

                // Validación y asignación de la edad
                age = Age();
                
            } while (age < 18 || age > 110);

            //Validacion y asignacion de genero
            gender = Gender();

            balance = -1;
            do {
                try {
                    balance = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el saldo: "));
                    if (balance < 0 || balance > 100000) {
                        JOptionPane.showMessageDialog(null, "El saldo debe estar entre 0 y 100000. Intenta nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el saldo.");
                }
            } while (balance < 0 || balance > 100000);
            
            //Validacion y asignacion de salario
            salary = Salary();

            // Creación de un nuevo objeto Customer con los datos capturados
            CardPayroll card = new CardPayroll(balance);

            //Asignacion y validacion de credito
            CreditC credit = Creditt();

            CustomerPayroll cusPay = new CustomerPayroll(name, surname1, surname2, age, gender, salary, credit, card);
            
            //nCustomer.assignCard(nCard); // Asignación de tarjeta al cliente
            
            // Agregamos el cliente a la lista de Payroll
            ListFinal.ListP.insertBegining(cusPay);

            //Asignacion de informacion a mostrar despues de crear un cliente
            String nameCom = cusPay.getName() + " " + cusPay.getSurname1() + " " + cusPay.getSurname2();
            String nuCa = cusPay.getCard().getNumber();
            String nipT = cusPay.getCard().getNip();
            String typeC = cusPay.getCard().getType();

            String messageInfo = """
                    \tCLIENTE INGRESADO EXITOSAMENTE
                        \nNombre: """ + nameCom + """
                        \nEdad: """ + cusPay.getAge() + """
                        \nGenero: """ + cusPay.getGender() + """
                        \nSalario: $""" + cusPay.getSalary() + """
                        \nTipo de cliente: """ +  typeC + """
                        \nNumero tarjeta: """ + nuCa + """
                        \nNIP: """ + nipT + """
                        \nSaldo de tarjeta: $""" + cusPay.getCard().getBalance() + """
                        \nTipo de Credito: """ + cusPay.getCredit().getTypeCred() + """
                        \nMonto del Credito: $""" + cusPay.getCredit().getAmount() + """
                        \n""";
            
            //Mostrar informacion relevante del cliente despues de guardarlo
            JOptionPane.showMessageDialog(null, messageInfo);

            res = JOptionPane.showInputDialog("Agregar nuevo cliente Nomina s/n: ").charAt(0);
        } while (Character.toUpperCase(res) == 'S');
    }

    private static void addCredit(){
        Character res;
        String name, surname1, surname2;
        char gender;
        int age;
        double creditBalance, salary, discount, cardInterest;
        //boolean isNum;

        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de registro de usuarios de BANKDYS\n\tA continuación introduce a los usuarios");
        do {
            age = -1;
            // Captura de datos del cliente
            do {
                JOptionPane.showMessageDialog(null, "INGRESAR DATOS DE NUEVO CLIENTE CREDITO");

                // Validación y asignación del nombre
                name = Name();

                // Validación y asignación del primer apellido
                surname1 = Surname1();

                // Validación y asignación del segundo apellido
                surname2 = Surname2();

                // Validación y asignación de la edad
                age = Age();

            } while (age < 18 || age > 110);

            //Validacion y asignacion de genero
            gender = Gender();

            // Validación y captura del saldo de tarjeta
            creditBalance = -1;
            do {
                try{
                    creditBalance = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el saldo de credito: "));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el saldo de credito.");
                }
            } while (creditBalance < 0 || creditBalance > 1000000);

            //Validacion y asignacion de descuento de tarjeta
            discount = 0;
            do{
                try{
                    discount = Double.parseDouble(JOptionPane.showInputDialog("Descuento de la tarjeta\nEntre 12% a 15%"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el descuento.");
                }
            } while (discount < 0.12 || discount > 0.15);

            //Validacion y asignacion del interes de tarjeta
            cardInterest = 0;
            do{
                try{
                    cardInterest = Double.parseDouble(JOptionPane.showInputDialog("Interes de la tarjeta\nEntre 10% a 20%"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el interes de la tarjeta.");
                }
            } while (cardInterest < 0.10 || cardInterest > 0.20);

            //Validacion y asignacion de salario
            salary = Salary();

            // Creación de un nuevo objeto Customer con los datos capturados
            CardCredit card = new CardCredit(creditBalance, cardInterest, discount);

            //Asignacion y validacion de credito
            CreditC credit = Creditt();

            CustomerCredit cusCre = new CustomerCredit(name, surname1, surname2, age, gender, salary, credit, card);
            
            // Agregamos el cliente a la lista de Debit
            ListFinal.ListC.insertBegining(cusCre);

            //Asignacion de informacion a mostrar despues de crear un cliente
            String nameCom = cusCre.getName() + " " + cusCre.getSurname1() + " " + cusCre.getSurname2();
            String nuCa = cusCre.getCard().getNumber();
            String nipT = cusCre.getCard().getNip();
            String typeC = cusCre.getCard().getType();

            String messageInfo = """
                    \tCLIENTE INGRESADO EXITOSAMENTE
                        \nNombre: """ + nameCom + """
                        \nEdad: """ + cusCre.getAge() + """
                        \nGenero: """ + cusCre.getGender() + """
                        \nSalario: $""" + cusCre.getSalary() + """
                        \nTipo de cliente: """ +  typeC + """
                        \nNumero tarjeta: """ + nuCa + """
                        \nNIP: """ + nipT + """
                        \nSaldo de credito tarjeta: $""" + cusCre.getCard().getCreditBalance() + """
                        \nTipo de Credito: """ + cusCre.getCredit().getTypeCred() + """
                        \nMonto del Credito: $""" + cusCre.getCredit().getAmount() + """
                        \n""";
            
            //Mostrar informacion relevante del cliente despues de guardarlo
            JOptionPane.showMessageDialog(null, messageInfo);

            res = JOptionPane.showInputDialog("Agregar nuevo cliente credito s/n: ").charAt(0);
        } while (Character.toUpperCase(res) == 'S');
    }
    private static void addDebit(){
        Character res;
        String name, surname1, surname2;
        char gender;
        int age;
        double balance, salary, discount;
        //boolean isNum;

        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de registro de usuarios de BANKDYS\n\tA continuación introduce a los usuarios");
        do {
            // Captura de datos del cliente
            do {
                JOptionPane.showMessageDialog(null, "INGRESAR DATOS DE NUEVO CLIENTE DEBITO");

                // Validación y asignación del nombre
                name = Name();

                // Validación y asignación del primer apellido
                surname1 = Surname1();

                // Validación y asignación del segundo apellido
                surname2 = Surname2();

                // Validación y asignación de la edad
                age = Age();

            } while (age < 18 || age > 110);

            //Validacion y asignacion de genero
            gender = Gender();

            // Validación y captura del saldo de tarjeta
            balance = -1;
            do {
                try{
                    balance = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el saldo: "));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el saldo.");
                }
            } while (balance < 0 || balance > 1000000);

            //Validacion y asignacion de descuento de tarjeta
            discount = 0;
            do{
                try{
                    discount = Double.parseDouble(JOptionPane.showInputDialog("Descuento de la tarjeta\nEntre 12% a 15%"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el descuento.");
                }
            } while (discount < 0.10 || discount > 0.15);

            //Validacion y asignacion de salario
            salary = Salary();

            // Creación de un nuevo objeto Customer con los datos capturados
            CardDebit card = new CardDebit(balance, discount);

            //Asignacion y validacion de credito
            CreditC credit = Creditt();

            CustomerDebit cusDeb = new CustomerDebit(name, surname1, surname2, age, gender, salary, credit, card);
            
            // Agregamos el cliente a la lista de Debit
            ListFinal.ListD.insertBegining(cusDeb);

            //Asignacion de informacion a mostrar despues de crear un cliente
            String nameCom = cusDeb.getName() + " " + cusDeb.getSurname1() + " " + cusDeb.getSurname2();
            String nuCa = cusDeb.getCard().getNumber();
            String nipT = cusDeb.getCard().getNip();
            String typeC = cusDeb.getCard().getType();

            String messageInfo = """
                    \tCLIENTE INGRESADO EXITOSAMENTE
                        \nNombre: """ + nameCom + """
                        \nEdad: """ + cusDeb.getAge() + """
                        \nGenero: """ + cusDeb.getGender() + """
                        \nSalario: $""" + cusDeb.getSalary() + """
                        \nTipo de cliente: """ +  typeC + """
                        \nNumero tarjeta: """ + nuCa + """
                        \nNIP: """ + nipT + """
                        \nSaldo de tarjeta: $""" + cusDeb.getCard().getBalance() + """
                        \nTipo de Credito: """ + cusDeb.getCredit().getTypeCred() + """
                        \nMonto del Credito: $""" + cusDeb.getCredit().getAmount() + """
                        \n""";
            
            //Mostrar informacion relevante del cliente despues de guardarlo
            JOptionPane.showMessageDialog(null, messageInfo);

            res = JOptionPane.showInputDialog("Agregar nuevo cliente debito s/n: ").charAt(0);
        } while (Character.toUpperCase(res) == 'S');
    }
}
