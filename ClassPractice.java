// practice with classes

//import BankAccount.BankAccount;

/**
* @Critical: Not sure how to import BankAccount class from BankAccount.java

*/


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

class CheckingAccount extends BankAccount{
    //
    public CheckingAccount(double balance){
        super(balance);
    }
    
    
    //@Override
    public void printBalance(){
        System.out.println("Your checking account balance is $" + balance);
    }

    
    public String toString(){
        String repr = "This CheckingAccount object has a balance of $" + balance;
        return repr;
    }
    
    public static void main(String[] args){
        CheckingAccount myCheckings = new CheckingAccount(5000);
        
        myCheckings.printBalance();

        //System.out.println(myCheckings.toString());



    }
}


