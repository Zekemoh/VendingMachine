/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import VendingDto.Change;
import VendingDto.Item;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 *

 */
public class VendingMachineView {
    
    UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public String printMenuAndGetSelection(Map<String, Item> map) {
        io.print(" Vending Machine Main Menu");
        displayItem(map);
        String userDecision = io.readString("Please Select A Snack");
        return userDecision;

    }

    public void displayItem(Map<String, Item> items) {
        Set<String> keys = items.keySet();
        for (String b : keys) {
            if (b != null) {
                io.print(items.get(b).getItemName());
                io.print(items.get(b).getItemCost() + " "); // " " changed it to a string - Learned this during morning excerise
                io.print(" " + items.get(b).getItemStock()); // " " changed it to a string - Learned this during morning excerise
            } else {
                io.print("There's No Such Item In This Vending Machine");
            }
        }

    }

    public BigDecimal getuserMoney() {
        String userMoney = io.readString("How Much Money Do You Want To Insert?");
        BigDecimal money = new BigDecimal(userMoney);
        return money;

    }

    public void getChange(Change change) {
        io.print(change.getDollars() + "Dollars");
        io.print(change.getQuarters() + "Quarters");
        io.print(change.getDimes() + "Dimes");
        io.print(change.getNickels() + "Nickels");
        io.print(change.getPennies() + "Pennies");

    }

    public void displayItemSuccessBanner() {
        io.readString("==Item Has Been Successfully Bought==");

    }

    public void unknownCommandBanner() {
        io.print("==UNKNOWN COMMAND==");

    }

    public void insufficentFundsBanner() {
        io.readString("InSufficent Funds, Press Enter To Continue");
    }

    public void noInventoryBanner() {
        io.readString("This Item Is Out Of Stock, Press Enter To Continue");
    }

    public void errorMessage(String error) {
        io.print("ERROR");
        io.print(error);
    }

    public void validItem() {
        io.readString("Please Enter A Valid Item, Press Enter To Continue");
    }
}
