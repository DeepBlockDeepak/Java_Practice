// practice with classes

class BankAccount{
    //
    protected double balance;

    public BankAccount(double balanceIn){
        balance = balanceIn;
    }
    
    public void printBalance(){
        System.out.println("Your account balance is $" + balance);
    }
}


class CheckingAccount extends BankAccount{
    //
    public CheckingAccount(double balance){
        super(balance);
    }
    
    @Override
    public void printBalance(){
        System.out.println("Your checking account balance is $" + balance);
    }
    
    public static void main(String[] args){
        BankAccount myCheckings = new CheckingAccount(5000);
        myCheckings.printBalance();
    }
}


