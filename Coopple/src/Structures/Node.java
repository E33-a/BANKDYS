package Structures;

import Bank.Customer.Customer;

public class Node {
    public Customer cus;
    public NodeCr next; //ref a nodo siguiente
    public NodeCr prev; //ref a nodo anterior

    //constructor
    Node(Customer cus){
        this.cus = cus;
        this.next = null;
        this.prev = null;
    }
}