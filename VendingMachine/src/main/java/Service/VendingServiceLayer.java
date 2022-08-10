/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import VendingDao.VendingException;
import VendingDto.Change;
import VendingDto.Item;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 */
public interface VendingServiceLayer {
             
    public Map<String, Item> getAllItems() throws VendingException;
    
    public Item getItem(String itemName) throws VendingException;
    
    public Change getChange(BigDecimal itemCost, BigDecimal userMoney) throws VendingException;
    
    public void verifyInventory(Item item) throws NoInventoryException;
    
    public void checkFunds(BigDecimal itemCost, BigDecimal userMoney) throws InsufficentFundsException;
    
    public Item updateInventory(Item item) throws VendingException;
}
