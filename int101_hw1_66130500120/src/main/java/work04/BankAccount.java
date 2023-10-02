
package work04;

public class BankAccount {
    private int number ;
    
    private Person owner ;
    
    private double balance ;
    public BankAccount (int number,Person owner){}
    

    public int getNumber() { return number;}

    public double getBalance() { return balance;}

    public Person getOwner() { return owner;}
    
    public double deposit (double amount){
        balance += amount;
        return balance;
    }
    
    public double withdraw (double amount){
        balance -= amount ;    
        return balance ;
                }
    
    
    public void transfer (double amount , BankAccount account){
        withdraw(amount);
        account.deposit(amount); }
    
    @Override
    public String toString (){
        return "BankAccount(id"+number+")";
    }
    
}
