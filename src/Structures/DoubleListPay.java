package Structures;

import Coopple.CustomerPayroll;

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
    public void deleteNodePayValue(CustomerPayroll cus){
        NodePay current = head;

        while (current != null) {
            if (current.cus.getCard().getNumber() == cus.getCard().getNumber()){
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
                return; // al eliminar el nodo no es necesario seguir iterando
            }
            current = current.next; //funciona como contadora para iterar la lista
        }
        // Si llegamos aquí, significa que no se encontró el nodo con el valor data
        System.out.println("El registro del usuario " 
        + cus.getName() + " " + cus.getSurname1() + " " + cus.getSurname2()); 
        System.out.println("Con numero de cuenta: " + cus.getCard().getNumber() 
        + " no se encontró.");
    }

    public void printForward() {
        if (isEmpty()){
            System.out.println("\nLista vacia");
            return; //si la lista esta vacia finalizamos el metodo
        }
        NodePay current = head;
        while (current != null) {
            current.cus.showInfoC();
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
            current.cus.showInfoC();
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

    
}
