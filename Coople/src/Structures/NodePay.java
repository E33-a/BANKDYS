package Structures;

import Bank.Customer.CustomerPayroll;

    
public class NodePay extends Node{
    public CustomerPayroll cus;
    public NodePay next; //ref a nodo siguiente
    public NodePay prev; //ref a nodo anterior

    //constructor
    NodePay(CustomerPayroll cus){
        super(cus);
        this.cus = cus;
        this.next = null;
        this.prev = null;
    }
}