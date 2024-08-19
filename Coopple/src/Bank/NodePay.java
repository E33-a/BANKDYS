package Bank;
    
public class NodePay {
    public CustomerPayroll cus;
    public NodePay next; //ref a nodo siguiente
    public NodePay prev; //ref a nodo anterior

    //constructor
    NodePay(CustomerPayroll cus){
        this.cus = cus;
        this.next = null;
        this.prev = null;
    }
}

