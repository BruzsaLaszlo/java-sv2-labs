package classstructureintegrate;

/*
Számlanyitáshoz mindhárom attribútum értékét meg kell adni.
A számlára lehet befizetni (deposit()) és lehet róla pénzt kivenni (withdraw()).

A getInfo() metódus a számla adatait az alábbi formában adja vissza Stringként:

Tóth Kálmán (10073217-12000098-67341590): 103400 Ft
 */

public class BankAccount {

    private String accountNumber;
    private String owner;
    private int balance;

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int money) {
        balance -= money;
    }

    public String getInfo() {
        return owner + "(" + accountNumber + "): " + balance + " Ft";
    }

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

}
