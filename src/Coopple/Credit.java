package Coopple;

public abstract class Credit {
    protected double amount;
    protected double interest;

    Credit(double amount, double interest){
        this.amount = amount;
        this.interest = interest;
    }

    //setters
    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setInterest(double interest){
        this.interest = interest;
    }

    //getters
    public double getAmount(){
        return amount;
    }

    public double getInterest(){
        return interest;
    }
}
