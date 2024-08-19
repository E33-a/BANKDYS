package Structures;

import Coopple.CustomerDebit;

public class DoubleListDe {
    private NodeDe head; //primer nodo
    private NodeDe tail; //ultimo nodo

    public DoubleListDe() { // constructor de lista vacia
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() { //comprobar si la lista esta vacia
        return head == null; //comprobacion en return
    }

    public NodeDe getHead(){
        return head;
    }
    public NodeDe getTail(){
        return tail;
    }

    public void insertBegining(CustomerDebit cus){
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

    public void insertEnd(CustomerDebit cus){
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

    //eliminar nodo dependiendo de un valor
    public void deleteNodeDeValue(CustomerDebit cus){
        NodeDe current = head;

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
        NodeDe current = head;
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
        NodeDe current = tail;
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
        NodeDe current = head;
        while (current != null) {
           if(number.equals(current.cus.getCard().getNumber())){
                System.out.println("CLIENTE ENCONTRADO\n");
                current.cus.showInfoC();
                System.out.println("-----------------------------------");
                return;
            } 
            current = current.next;
        }
        System.out.println("Numero de cuenta no registrada");
        System.out.println("\n");
}

    
}
