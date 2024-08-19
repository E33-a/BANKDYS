package Structures;

import javax.swing.JOptionPane;

import Bank.Customer.CustomerPayroll;

public class DoubleListPay {
    private NodePay head; //primer nodo
    private NodePay tail; //ultimo nodo

    public DoubleListPay() { // constructor de lista vacia
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() { //comprobar si la lista esta vacia
        return head == null; //comprobacion en return
    }

    public NodePay getHead(){
        return head;
    }//////////////
    public NodePay getTail(){
        return tail;
    }//////////////

    public void insertBegining(CustomerPayroll cus){
        NodePay newNodePay = new NodePay(cus);
        if (isEmpty()) {
            head = newNodePay;
            tail = newNodePay;
        } else {
            newNodePay.next = head;
            head.prev = newNodePay;
            head = newNodePay;
        }
    }

    public void insertEnd(CustomerPayroll cus){
        NodePay newNodePay = new NodePay(cus);
        if (isEmpty()) {
            head = newNodePay;
            tail = newNodePay;
        } else {
            tail.next = newNodePay;
            newNodePay.prev = tail;
            tail = newNodePay;
        }
    }

    //eliminar nodo dependiendo de un valor
    public NodePay deleteNodePayValue(String cardNumber){
        NodePay current = head;

        while (current != null) {
            if (cardNumber.equals(current.cus.getCard().getNumber())){
                //el nodo a eliminar es el primero
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                }
                // si el nodo a eliminar es el ultimo
                else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                }
                //Nodo a eliminar esta en el medio
                else {
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                }
                return current; // al eliminar el nodo no es necesario seguir iterando y lo retornamos
            }
            current = current.next; //funciona como contadora para iterar la lista
        }
        // Si llegamos aquí, significa que no se encontró el nodo con el valor data
        System.out.println("El registro del numero de tarjeta: " + cardNumber + " no se encontró.");
        return null; //si no se encontro retornamos nulo
    }

    public void printForward() {
        if (isEmpty()){
            System.out.println("\nLista vacia");
            return; //si la lista esta vacia finalizamos el metodo
        }
        NodePay current = head;
        while (current != null) {
            current.cus.showCPay();
            System.out.println("--------------------------");
            current = current.next;
        }
        System.out.println("\n");
    }

    public void printBackward(){
        if (isEmpty()) {
            System.out.println("\nLista vacia");
            return; //si la lista esta vacia finalizamos el metodo
        }
        NodePay current = tail;
        while (current != null) {
            current.cus.showCPay();
            System.out.println("-----------------------------------");
            current = current.prev;
        }
        System.out.println("\n");
    }

    public void searchCus(String number){
        if (isEmpty()){
            System.out.println("\nLista vacia");
            return; //si la lista esta vacia finalizamos el metodo
        }
        NodePay current = head;
        while (current != null) {
           if(number.equals(current.cus.getCard().getNumber())){
                System.out.println("CLIENTE ENCONTRADO\n");
                current.cus.showCPay();
                System.out.println("-----------------------------------");
                return;
            } 
            current = current.next;
        }
        System.out.println("Numero de cuenta no registrada");
        System.out.println("\n");
    }

    public boolean findCus(String number){
        if (isEmpty()){
            JOptionPane.showMessageDialog(null, "Lista vacia\nNo hay clientes registrados");
            return false; //si la lista esta vacia finalizamos el metodo
        }
        NodePay current = head;
        while (current != null) {
           if(number.equals(current.cus.getCard().getNumber())){
                //System.out.println("CLIENTE ENCONTRADO\n");
                //current.cus.showCPay();
                return true;
            } 
            current = current.next;
        }
        //Si no se encuentra el cliente
        return false;
    }   
    //sort
    private NodePay partition(NodePay low, NodePay high) {
        String pivot = high.cus.getCard().getNumber(); // Selecciona el número de tarjeta del nodo final como pivote
        NodePay i = low.prev; // Puntero para el nodo más pequeño

        for (NodePay j = low; j != high; j = j.next) {
            // Si el número de tarjeta del nodo actual es menor o igual que el pivote
            if (j.cus.getCard().getNumber().compareTo(pivot) <= 0) {
                i = (i == null) ? low : i.next; // Incrementa el puntero de i
                swap(i, j); // Intercambia los nodos i y j
            }
        }
        i = (i == null) ? low : i.next; // Mueve i a la siguiente posición
        swap(i, high); // Intercambia el nodo i con el pivote
        return i; // Devuelve la nueva posición del pivote
    }

    // Método para intercambiar los datos de dos nodos
    private void swap(NodePay a, NodePay b) {
        CustomerPayroll temp = a.cus;
        a.cus = b.cus;
        b.cus = temp;
    }

    // Método recursivo para aplicar Quick Sort
    private void quickSort(NodePay low, NodePay high) {
        if (high != null && low != high && low != high.next) {
            NodePay pivot = partition(low, high); // Particiona la lista
            quickSort(low, pivot.prev); // Ordena la sublista izquierda
            quickSort(pivot.next, high); // Ordena la sublista derecha
        }
    }

    // Método público para iniciar el Quick Sort
    public void sort() {
        quickSort(head, tail);
    }
}
