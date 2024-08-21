package Structures;

import Bank.Customer.CustomerCredit;

public class NodeCr extends Node{
    public CustomerCredit cus;
    public NodeCr next; //ref a nodo siguiente
    public NodeCr prev; //ref a nodo anterior

    //constructor
    NodeCr(CustomerCredit cus){
        super(cus);
        this.cus = cus;
        this.next = null;
        this.prev = null;
    }
}
