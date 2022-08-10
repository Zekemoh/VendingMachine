/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingDto;

/**
 *
 
 */
public class Change {
      int dollars;
    int quarters;
    int dimes;
    int nickels;
    int pennies;

    public Change() {
        
    }
    

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }
    
    public void change (int totalPennies) {
        
        dollars = totalPennies / 100;
        totalPennies = totalPennies - dollars * 100;
        
        quarters = totalPennies / 25;
        totalPennies = totalPennies - quarters * 25;
        
        dimes = totalPennies / 10;
        totalPennies = totalPennies - dimes * 10;
        
        nickels = totalPennies / 5;
        totalPennies = totalPennies - nickels * 5;
        
        pennies = totalPennies;
        
    }
}
