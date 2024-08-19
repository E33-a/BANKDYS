package Coopple;

import Structures.DoubleListPay;
import Structures.NodePay;

import java.util.Scanner;

/**
 * El codigo esta desarrollado en linux si llegara existir alguna incompatibilidad de instrucciones
 * Falta implementar los otros tipos de clientes asi como sus listas especiales y nodos
 */
public class Coopple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleListPay customersList = new DoubleListPay();

        int option = -1;
        
        while (option != 0) {
            
            System.out.println("\tMENU");
            System.out.println("1. Añadir cliente (inicio)");
            System.out.println("2. Añadir cliente (final)");
            System.out.println("3. Mostrar información de clientes (inicio)");
            System.out.println("4. Mostrar información de clientes (final)");
            System.out.println("5. Buscar cliente (No. tarjeta)");
            System.out.println("6. Eliminar cliente (No. tarjeta)");
            System.out.println("7. Realizar una compra");
            System.out.println("8. Realizar un pago");
            System.out.println("9. Imprimir últimas 3 transacciones");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione una opción: ");
            option = scanner.nextInt();
            clearScreen();
            switch (option) {
                case 1:
                    customersList.insertBegining(createCustomer(scanner));
                    break;
                case 2:
                    customersList.insertEnd(createCustomer(scanner));
                    break;
                case 3:
                    customersList.printForward();
                    break;
                case 4:
                    customersList.printBackward();
                    break;
                case 5:
                    System.out.print("\nIngrese el número de tarjeta: ");
                    String searchNumber = scanner.next();
                    customersList.searchCus(searchNumber);
                    break;
                case 6:
                    System.out.print("\nIngrese el número de tarjeta: ");
                    String deleteNumber = scanner.next();
                    CustomerPayroll customerToDelete = findCustomer(customersList, deleteNumber);
                    if (customerToDelete != null) {
                        customersList.deleteNodePayValue(customerToDelete);
                    }
                    break;
                case 7:
                    System.out.print("\nIngrese el número de tarjeta: ");
                    String cardNumberCompra = scanner.next();
                    CustomerPayroll customerCompra = findCustomer(customersList, cardNumberCompra);
                    if (customerCompra != null) {
                        System.out.print("\nIngrese el monto de la compra: ");
                        double montoCompra = scanner.nextDouble();
                        customerCompra.realizarCompra(montoCompra);
                    }
                    break;
                case 8:
                    System.out.print("\nIngrese el número de tarjeta: ");
                    String cardNumberPago = scanner.next();
                    CustomerPayroll customerPago = findCustomer(customersList, cardNumberPago);
                    if (customerPago != null) {
                        System.out.print("\nIngrese el monto del pago: ");
                        double montoPago = scanner.nextDouble();
                        System.out.print("\nPago completo (true/false): ");
                        boolean esPagoCompleto = scanner.nextBoolean();
                        System.out.print("\nPago rebasa fecha límite (true/false): ");
                        boolean rebasaFechaLimite = scanner.nextBoolean();
                        customerPago.realizarPago(montoPago, esPagoCompleto, rebasaFechaLimite);
                    }
                    break;
                case 9:
                    System.out.print("Ingrese el número de tarjeta: ");
                    String cardNumber = scanner.next();
                    CustomerPayroll customer = findCustomer(customersList, cardNumber);
                    if (customer != null) {
                        customer.showTransactions();
                    }
                    break;
                case 0:
                    System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("\nOpción no válida, por favor intente de nuevo.");
            }
        } 
        scanner.close();
    }

    private static CustomerPayroll createCustomer(Scanner scanner) {
        System.out.print("\nIngrese el nombre: ");
        String name = scanner.next();
        name = name.toUpperCase();
        System.out.print("\nIngrese el primer apellido: ");
        String surname1 = scanner.next();
        surname1 = surname1.toUpperCase();
        System.out.print("\nIngrese el segundo apellido: ");
        String surname2 = scanner.next();
        surname2 = surname2.toUpperCase();
        System.out.print("\nIngrese la edad: ");
        int age = scanner.nextInt();
        System.out.print("\nIngrese el género (M/F): ");
        char gender = scanner.next().charAt(0);
        gender = Character.toUpperCase(gender);
        System.out.print("\nIngrese el salario: ");
        double salary = scanner.nextDouble();
        System.out.print("\nIngrese el número de tarjeta: ");
        String cardNumber = scanner.next();
        System.out.print("\nIngrese el NIP: ");
        String nip = scanner.next();
        System.out.print("\nIngrese el saldo inicial: ");
        double balance = scanner.nextDouble();
        
        // Crear la tarjeta y el crédito del cliente
        CardPayroll card = new CardPayroll(cardNumber, nip, "NOMINA", balance);
        CreditC credit = new CreditC(salary * 0.2, 0.12, 36, "CASA"); // Ejemplo de cálculo de crédito

        // Crear y retornar el cliente
        return new CustomerPayroll(name, surname1, surname2, age, gender, salary, credit, card);
    }

    private static CustomerPayroll findCustomer(DoubleListPay list, String cardNumber) {
        NodePay current = list.getHead();
        while (current != null) {
            if (current.cus.getCard().getNumber().equals(cardNumber)) {
                return current.cus;
            }
            current = current.next;
        }
        System.out.println("Cliente no encontrado con el número de tarjeta: " + cardNumber);
        return null;
    }

    public static void clearScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}
