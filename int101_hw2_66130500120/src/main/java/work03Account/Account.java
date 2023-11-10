package work03Account;

import work01Utilitor.Utilitor;
import work02Person.Person;

public class Account {
    private static long nextNo = 100000000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        this.owner = Utilitor.testPerson(owner);
        int resultIsbn = Utilitor.computeIsbn10(nextNo);

        while(resultIsbn == 10) {
            nextNo++;
            resultIsbn = Utilitor.computeIsbn10(nextNo);
        }

        this.no = 10*nextNo+resultIsbn;
        nextNo++;

        this.balance = 0.0;
    }

    public long getNo() {return no;}
    public Person getOwner() {return owner;}
    public double getBalance() {return balance;}

    public double deposit(double amount) {
        return this.balance += Utilitor.testPositive(amount);
    }

    public double withdraw(double amount) {
        if(amount > this.balance) {
            throw new IllegalArgumentException("Insufficient Balance!");
        }

        double newBalance = this.balance - Utilitor.testPositive(amount);
        this.balance = Utilitor.testPositive(newBalance);
        return balance;
    }

    public void transfer(double amount, Account account) {
        if(account == null || balance <= withdraw(amount)) {
            throw new IllegalArgumentException("Insufficient Balance!");
        }
        this.balance -= withdraw(amount);
        account.deposit(amount);
    }


    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account(").append(no).append(",").append(balance).append(")");
        return sb.toString();
    }
}
