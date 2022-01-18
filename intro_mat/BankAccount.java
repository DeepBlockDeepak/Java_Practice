/**
    Practice importing BankAccount to it's subclass within the file ClassPractice.java
    @Critical: Not sure how to import this to the ClassPractice.java file!!!!!!!


*/
 
package BankAccount;

class BankAccount{
    //
    protected double balance;

    public BankAccount(double balanceIn){
        balance = balanceIn;
    }
    
    public void printBalance(){
        System.out.println("Your account balance is $" + balance);
    }

    
    public String toString(){
        String repr = "This BankAccount object has a balance of $ " + balance;
        return repr;
    }
    
}
