package Structures;

import Bank.Customer.CustomerDebit;

public class DoubleListDe {
    private NodeDe head; // Primer nodo
    private NodeDe tail; // Último nodo

    public DoubleListDe() { // Constructor de lista vacía
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() { // Comprueba si la lista está vacía
        return head == null; // Comprobación en return
    }

    public NodeDe getHead() {
        return head;
    }

    public NodeDe getTail() {
        return tail;
    }

    public void insertBeginning(CustomerDebit cus) {
        NodeDe newNodeDe = new NodeDe(cus);
        if (isEmpty()) {
            head = newNodeDe;
            tail = newNodeDe;
        } else {
            newNodeDe.next = head;
            head.prev = newNodeDe;
            head = newNodeDe;
        }
    }

    public void insertEnd(CustomerDebit cus) {
        NodeDe newNodeDe = new NodeDe(cus);
        if (isEmpty()) {
            head = newNodeDe;
            tail = newNodeDe;
        } else {
            tail.next = newNodeDe;
            newNodeDe.prev = tail;
            tail = newNodeDe;
        }
    }

    // Elimina un nodo dependiendo del número de tarjeta
    public NodeDe deleteNodeDeValue(String cardNumber) {
        NodeDe current = head;

        while (current != null) {
            if (cardNumber.equals(current.cus.getCard().getNumber())) {
                // El nodo a eliminar es el primero
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                }
                // El nodo a eliminar es el último
                else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                }
                // El nodo a eliminar está en el medio
                else {
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                }
                return current; // Al eliminar el nodo no es necesario seguir iterando
            }
            current = current.next; // Funciona como contador para iterar la lista
        }
        // Si llegamos aquí, significa que no se encontró el nodo con el valor cardNumber
        System.out.println("El registro del número de tarjeta: " + cardNumber + " no se encontró.");
        return null;
    }

    public void printForward() {
        if (isEmpty()) {
            System.out.println("\nLista vacía");
            return; // Si la lista está vacía, finalizamos el método
        }
        NodeDe current = head;
        while (current != null) {
            current.cus.showCDeb();
            System.out.println("--------------------------");
            current = current.next;
        }
        System.out.println("\n");
    }

    public void printBackward() {
        if (isEmpty()) {
            System.out.println("\nLista vacía");
            return; // Si la lista está vacía, finalizamos el método
        }
        NodeDe current = tail;
        while (current != null) {
            current.cus.showCDeb();
            System.out.println("-----------------------------------");
            current = current.prev;
        }
        System.out.println("\n");
    }

    public void searchCus(String number) {
        if (isEmpty()) {
            System.out.println("\nLista vacía");
            return; // Si la lista está vacía, finalizamos el método
        }
        NodeDe current = head;
        while (current != null) {
            if (number.equals(current.cus.getCard().getNumber())) {
                System.out.println("CLIENTE ENCONTRADO\n");
                current.cus.showCDeb();
                System.out.println("-----------------------------------");
                return;
            }
            current = current.next;
        }
        System.out.println("Número de cuenta no registrada");
        System.out.println("\n");
    }

    public boolean findCus(String number) {
        if (isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Lista vacía\nNo hay clientes registrados");
            return false; // Si la lista está vacía, finalizamos el método
        }

        NodeDe current = head;

        while (current != null) {
            if (number.equals(current.cus.getCard().getNumber())) {
                return true; // El cliente se encuentra en la lista
            }
            current = current.next;
        }
        // Si no se encuentra el cliente
        return false;
    }

    // Método para particionar la lista para Quick Sort
    private NodeDe partition(NodeDe min, NodeDe may) {
        String pivot = may.cus.getCard().getNumber(); // Selecciona el número de tarjeta del nodo final como pivote
        NodeDe i = min.prev; // Puntero para el nodo más pequeño

        for (NodeDe j = min; j != may; j = j.next) {
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
    private void swapNodes(NodeDe a, NodeDe b) {
        CustomerDebit temp = a.cus;
        a.cus = b.cus;
        b.cus = temp;
    }

    // Método recursivo para aplicar Quick Sort
    private void quickSort(NodeDe min, NodeDe may) {
        if (may != null && min != may && min != may.next) {
            NodeDe pivot = partition(min, may); // Particiona la lista
            quickSort(min, pivot.prev); // Ordena la sublista izquierda
            quickSort(pivot.next, may); // Ordena la sublista derecha
        }
    }

    // Método público para iniciar el Quick Sort
    public void sort() {
        quickSort(head, tail);
    }

    public void readOtherList(DoubleListDe list) {
        NodeDe current = list.head;
        if (current == null) {
            System.out.println("La lista a copiar está vacía.");
            return;
        }
    
        int count = 0;
        while (current != null) {
            CustomerDebit ncus = current.cus;
            insertEnd(ncus);
            current = current.next;
            count++;
        }
        System.out.println("Se han copiado " + count + " clientes a la lista de débito final.");
    }
}
