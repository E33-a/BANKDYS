package Structures;

import Bank.Customer.Customer;

// Este es un nodo general del que derivan los demas
public class Node {
    public Customer cus;
    public Node next; //ref a nodo siguiente
    public Node prev; //ref a nodo anterior

    //constructor
    Node(Customer cus){
        this.cus = cus;
        this.next = null;
        this.prev = null;
    }
}