package com.mycompany.bank;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ColectCust {
    private final static ArrayList<Customer> colectCus = new ArrayList<>();

    // Método para agregar clientes al ArrayList
    public void addCust() {
        Character res;
        String name, surname1, surname2, address, email, celnum;
        int age;
        float balance, debt;
        boolean isNum;

        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de registro de usuarios de Dandy´s Bank C.\n\tA continuación introduce a los usuarios");

        do {
            Card nCard = new Card("1206", "2409"); // Creación de una nueva tarjeta con valores fijos (por mejorar)

            // Captura de datos del cliente
            do {
                JOptionPane.showMessageDialog(null, "INGRESAR DATOS DE CLIENTE");

                // Validación y asignación del nombre
                do {
                    name = JOptionPane.showInputDialog("Ingresa el nombre: ");
                    if (name != null) {
                        name = name.toUpperCase();
                    }
                    if (name == null) {
                        JOptionPane.showMessageDialog(null, "Los campos deben llenarse\n\tIntenta nuevamente");
                    }
                } while (name == null);

                // Validación y asignación del primer apellido
                do {
                    surname1 = JOptionPane.showInputDialog("Ingresa el primer apellido: ");
                    if (surname1 != null) {
                        surname1 = surname1.toUpperCase();
                    }
                    if (surname1 == null) {
                        JOptionPane.showMessageDialog(null, "Los campos deben llenarse\n\tIntenta nuevamente");
                    }
                } while (surname1 == null);

                // Validación y asignación del segundo apellido
                do {
                    surname2 = JOptionPane.showInputDialog("Ingresa el segundo apellido: ");
                    if (surname2 != null) {
                        surname2 = surname2.toUpperCase();
                    }
                    if (surname2 == null) {
                        JOptionPane.showMessageDialog(null, "Los campos deben llenarse\n\tIntenta nuevamente");
                    }
                } while (surname2 == null);

                // Validación y asignación de la edad
                age = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad: "));
                if (age < 18 || age > 110) {
                    JOptionPane.showMessageDialog(null, "La edad debe estar entre 18 y 110 años\n\tIntenta nuevamente");
                }
            } while (age < 18 || age > 110);

            // Captura de dirección
            address = JOptionPane.showInputDialog("Ingresa la dirección: ");

            // Validación y captura del email usando el método validEmail()
            do {
                email = JOptionPane.showInputDialog("Ingresa el email: ");
                if (validEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Dirección de correo válida: " + email);
                } else {
                    JOptionPane.showMessageDialog(null, "Dirección de correo inválida\n\tIngresa nuevamente");
                }
            } while (!validEmail(email));

            // Validación y captura del número de celular
            do {
                do {
                    celnum = JOptionPane.showInputDialog("Ingresa el número de celular: ");
                } while (celnum == null || celnum.length() != 10);
                isNum = true;

                // Validación de que el número contenga solo dígitos
                for (int i = 0; i < 10; i++) {
                    char dig = celnum.charAt(i);
                    if (!Character.isDigit(dig)) {
                        isNum = false;
                        break;
                    }
                }
                if (!isNum) {
                    JOptionPane.showMessageDialog(null, "El número debe contener exactamente 10 dígitos numéricos\nIngresa nuevamente");
                }
            } while (!isNum);

            // Validación y captura del saldo
            do {
                balance = Float.parseFloat(JOptionPane.showInputDialog("Ingresa el saldo: "));
            } while (balance < 0 || balance > 1000000);

            // Validación y captura de la deuda
            do {
                debt = Float.parseFloat(JOptionPane.showInputDialog("Ingresa la deuda: "));
            } while (debt < 0 || debt > 10000000);

            // Creación de un nuevo objeto Customer con los datos capturados
            Customer nCustomer = new Customer(name, surname1, surname2, age, address, email, celnum, balance, debt);
            nCustomer.assignCard(nCard); // Asignación de tarjeta al cliente
            colectCus.add(nCustomer); // Agregamos el cliente al ArrayList
            JOptionPane.showMessageDialog(null, "CLIENTE INGRESADO EXITOSAMENTE");

            res = JOptionPane.showInputDialog("Agregar nuevo cliente   s/n: ").charAt(0);
        } while (Character.toUpperCase(res) == 'S');
    }

    // Método para mostrar todos los clientes registrados
    public void showCust() {
        if (colectCus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY CLIENTES REGISTRADOS");
            return;
        }
        for (Customer nCustomer : colectCus) {
            nCustomer.showCustomer(); // Llama al método showCustomer() de la clase Customer
            System.out.println("==============================");
        }
    }

    // Método para mostrar la información de un cliente específico según el número de tarjeta
    public void showOneCustomer(String cardNumber) {
        if (colectCus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY CLIENTES REGISTRADOS");
            return;
        }
        boolean found = false;
        for (int i = 0; i < colectCus.size(); i++) {
            Customer customer = colectCus.get(i);
            if (customer.getCard() != null && customer.getCard().getNumber().equals(cardNumber)) {
                customer.showCustomer(); // Muestra la información del cliente encontrado
                JOptionPane.showMessageDialog(null, "Cliente encontrado");
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ese número de tarjeta.");
        }
    }

    // Método para eliminar un cliente según el número de tarjeta
    public void deleteCustomer(String cardNumber) {
        if (colectCus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY CLIENTES REGISTRADOS");
            return;
        }
        boolean found = false;
        for (int i = 0; i < colectCus.size(); i++) {
            Customer customer = colectCus.get(i);
            if (customer.getCard() != null && customer.getCard().getNumber().equals(cardNumber)) {
                colectCus.remove(i); // Elimina el cliente del ArrayList
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ese número de tarjeta.");
        }
    }

    // Método estático para validar un email usando expresiones regulares
    public static boolean validEmail(String email) {
        // Patrón de expresión regular para validar correo electrónico
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    // Método estático para obtener la colección de clientes
    public static ArrayList<Customer> getColectCus() {
        return colectCus;
    }
}
