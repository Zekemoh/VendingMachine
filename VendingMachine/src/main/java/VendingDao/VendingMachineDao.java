/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingDao;

import VendingDto.Item;
import java.util.Map;

/**
 *
 
 */
public interface VendingMachineDao {   
    public Map<String, Item> getAllItems() throws VendingException;
    
    public Item getItem(String itemName) throws VendingException;
    
   public Item updateInventory(Item item) throws VendingException;  
}
