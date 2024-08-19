package Structures;

import Bank.Customer.CustomerDebit;

public class NodeDe {
    public CustomerDebit cus;
    public NodeDe next; //ref a nodo siguiente
    public NodeDe prev; //ref a nodo anterior

    //constructor
    NodeDe(CustomerDebit cus){
        this.cus = cus;
        this.next = null;
        this.prev = null;
    }
}
