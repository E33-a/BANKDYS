package Bank;

public class NodeCr {
    public CustomerCredit cus;
    public NodeCr next; //ref a nodo siguiente
    public NodeCr prev; //ref a nodo anterior

    //constructor
    NodeCr(CustomerCredit cus){
        this.cus = cus;
        this.next = null;
        this.prev = null;
    }
}
