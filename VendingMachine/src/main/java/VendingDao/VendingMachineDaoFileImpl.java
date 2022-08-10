/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingDao;

import VendingDto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *

 */
public class VendingMachineDaoFileImpl implements VendingMachineDao  {
     private final static String VENDING_FILE = "./vendingMachine.txt";
    Map<String, Item> inventory = new HashMap();
    public static final String DELIMITER = "::";

    
    private void loadFile() throws VendingException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(VENDING_FILE)));
        } catch (FileNotFoundException ex) {
            throw new VendingException("File not found");
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Item currentItem = new Item();

            currentItem.setItemName(currentTokens[0]);
            currentItem.setItemCost(new BigDecimal(currentTokens[1]));
            currentItem.setItemStock(Integer.parseInt(currentTokens[2]));

            inventory.put(currentItem.getItemName(), currentItem);

        }
        scanner.close();

    }

   
    private void writeFile() throws VendingException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(VENDING_FILE));
        } catch (IOException e) {
            throw new VendingException(
                    "Could not save item data.", e);
        }

        List<Item> itemList = new ArrayList(inventory.values());
        for (Item currentItem : itemList) {

            out.println(currentItem.getItemName() + DELIMITER
                    + currentItem.getItemCost() + DELIMITER
                    + currentItem.getItemStock());

            out.flush();
        }

        out.close();
    }

    @Override
    public Map<String, Item> getAllItems() throws VendingException {
        loadFile();
        return inventory;
    }

     @Override
    public Item getItem(String itemName) throws VendingException {
        loadFile();

        return inventory.get(itemName);
    }

    public Item updateInventory(Item item) throws VendingException {
        item.setItemStock(item.getItemStock() - 1);
        writeFile();
        return item;
    }

}
