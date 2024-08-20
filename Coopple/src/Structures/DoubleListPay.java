package Structures;

import Bank.Customer.CustomerPayroll;

// Implementación de una lista doblemente enlazada para clientes de nómina
public class DoubleListPay {
    private NodePay head; // Primer nodo de la lista
    private NodePay tail; // Último nodo de la lista

    // Constructor de la lista vacía
    public DoubleListPay() {
        this.head = null;
        this.tail = null;
    }

    // Comprueba si la lista está vacía
    public boolean isEmpty() {
        return head == null; // La lista está vacía si el nodo cabeza es nulo
    }

    // Obtiene el primer nodo de la lista
    public NodePay getHead() {
        return head;
    }

    // Obtiene el último nodo de la lista
    public NodePay getTail() {
        return tail;
    }

    // Inserta un nuevo cliente al principio de la lista
    public void insertBeginning(CustomerPayroll cus) {
        NodePay newNodePay = new NodePay(cus); // Crea un nuevo nodo con el cliente

        if (isEmpty()) { // Si la lista está vacía
            head = newNodePay;
            tail = newNodePay;
        } else {
            newNodePay.next = head; // El nuevo nodo apunta al antiguo primer nodo
            head.prev = newNodePay; // El antiguo primer nodo apunta al nuevo nodo
            head = newNodePay; // El nuevo nodo se convierte en el primer nodo
        }
    }

    // Inserta un nuevo cliente al final de la lista
    public void insertEnd(CustomerPayroll cus) {
        NodePay newNodePay = new NodePay(cus); // Crea un nuevo nodo con el cliente

        if (isEmpty()) { // Si la lista está vacía
            head = newNodePay;
            tail = newNodePay;
        } else {
            tail.next = newNodePay; // El antiguo último nodo apunta al nuevo nodo
            newNodePay.prev = tail; // El nuevo nodo apunta al antiguo último nodo
            tail = newNodePay; // El nuevo nodo se convierte en el último nodo
        }
    }

    // Elimina un nodo en la lista basado en el número de tarjeta del cliente
    public NodePay deleteNodePayValue(String cardNumber) {
        NodePay current = head; // Comienza desde el primer nodo

        while (current != null) {
            if (cardNumber.equals(current.cus.getCard().getNumber())) { // Compara el número de tarjeta
                // El nodo a eliminar es el primero
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null; // Actualiza el puntero del anterior del nuevo primer nodo
                    }
                }
                // El nodo a eliminar es el último
                else if (current == tail) {
                    tail = current.prev;
                    tail.next = null; // Actualiza el puntero del siguiente del nuevo último nodo
                }
                // El nodo a eliminar está en el medio
                else {
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                }
                return current; // Retorna el nodo eliminado
            }
            current = current.next; // Mueve al siguiente nodo en la lista
        }

        // Si no se encontró el nodo
        System.out.println("El registro del número de tarjeta: " + cardNumber + " no se encontró.");
        return null; // Retorna nulo si no se encontró el nodo
    }

    // Imprime los nodos de la lista desde el principio hasta el final
    public void printForward() {
        if (isEmpty()) {
            System.out.println("\nLista vacía");
            return; // Finaliza el método si la lista está vacía
        }
        NodePay current = head;
        while (current != null) {
            current.cus.showCPay(); // Muestra los detalles del cliente
            System.out.println("--------------------------");
            current = current.next; // Mueve al siguiente nodo en la lista
        }
        System.out.println("\n");
    }

    // Imprime los nodos de la lista desde el final hasta el principio
    public void printBackward() {
        if (isEmpty()) {
            System.out.println("\nLista vacía");
            return; // Finaliza el método si la lista está vacía
        }
        NodePay current = tail;
        while (current != null) {
            current.cus.showCPay(); // Muestra los detalles del cliente
            System.out.println("-----------------------------------");
            current = current.prev; // Mueve al nodo anterior en la lista
        }
        System.out.println("\n");
    }

    // Busca un cliente en la lista basado en el número de tarjeta
    public void searchCus(String number) {
        if (isEmpty()) {
            System.out.println("\nLista vacía");
            return; // Finaliza el método si la lista está vacía
        }
        NodePay current = head;
        while (current != null) {
            if (number.equals(current.cus.getCard().getNumber())) { // Compara el número de tarjeta
                System.out.println("CLIENTE ENCONTRADO\n");
                current.cus.showCPay(); // Muestra los detalles del cliente
                System.out.println("-----------------------------------");
                return;
            }
            current = current.next; // Mueve al siguiente nodo en la lista
        }
        System.out.println("Número de cuenta no registrada");
        System.out.println("\n");
    }

    // Verifica si un cliente existe en la lista basado en el número de tarjeta
    public boolean findCus(String number) {
        if (isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Lista vacía\nNo hay clientes registrados");
            return false; // Retorna falso si la lista está vacía
        }
        NodePay current = head;
        while (current != null) {
            if (number.equals(current.cus.getCard().getNumber())) { // Compara el número de tarjeta
                return true; // Retorna verdadero si el cliente se encuentra
            }
            current = current.next; // Mueve al siguiente nodo en la lista
        }
        return false; // Retorna falso si el cliente no se encuentra
    }

    // Método para particionar la lista para Quick Sort
    private NodePay partition(NodePay min, NodePay may) {
        String pivot = may.cus.getCard().getNumber(); // El número de tarjeta del nodo final se usa como pivote
        NodePay i = min.prev; // Puntero para el nodo más pequeño

        for (NodePay j = min; j != may; j = j.next) {
            // Si el número de tarjeta del nodo actual es menor o igual que el pivote
            if (j.cus.getCard().getNumber().compareTo(pivot) <= 0) {
                i = (i == null) ? min : i.next; // Incrementa el puntero de i
                swapNodes(i, j); // Intercambia los nodos i y j
            }
        }
        i = (i == null) ? min : i.next; // Mueve i a la siguiente posición
        swapNodes(i, may); // Intercambia el nodo i con el pivote
        return i; // Devuelve la nueva posición del pivote
    }

    // Método para intercambiar los datos de dos nodos
    private void swapNodes(NodePay a, NodePay b) {
        CustomerPayroll temp = a.cus;
        a.cus = b.cus;
        b.cus = temp;
    }

    // Método recursivo para aplicar Quick Sort en la lista
    private void quickSort(NodePay min, NodePay may) {
        if (may != null && min != may && min != may.next) {
            NodePay pivot = partition(min, may); // Particiona la lista
            quickSort(min, pivot.prev); // Ordena la sublista izquierda
            quickSort(pivot.next, may); // Ordena la sublista derecha
        }
    }

    // Método público para iniciar el Quick Sort
    public void sort() {
        quickSort(head, tail);
    }
}
