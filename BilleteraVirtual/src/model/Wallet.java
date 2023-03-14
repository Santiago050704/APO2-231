package model;

import exceptions.NegativeAmountException;
import exceptions.NotEnoughMoneyException;

public class Wallet {
    private String id;
    private double funds;

    public void put(double amount) throws NegativeAmountException{
        if(amount < 0){
            throw new NegativeAmountException();
        }
        funds += amount;
    }

    public Wallet(String id, double funds) {
        this.id = id;
        this.funds = funds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public void withDraw(double amount)throws NegativeAmountException, NotEnoughMoneyException{
        if(amount < 0){
            throw new NegativeAmountException();
        }
        if(funds < amount){
            throw new NotEnoughMoneyException();
        }
        funds -= amount;
    }
}
