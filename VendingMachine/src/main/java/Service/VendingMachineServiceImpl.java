/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import VendingDao.VendingException;
import VendingDao.VendingMachineDao;
import VendingDto.Change;
import VendingDto.Item;
import java.math.BigDecimal;
import java.util.Map;

/**
 *

 */
public class VendingMachineServiceImpl implements VendingServiceLayer {
       VendingMachineDao dao;

    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public Map<String, Item> getAllItems() throws VendingException {
        return dao.getAllItems();
    }

    public Change getChange(BigDecimal itemCost, BigDecimal userMoney) throws VendingException {
        BigDecimal retrieveChange = userMoney.subtract(itemCost);
        Change change = new Change();
        int pennies = retrieveChange.multiply(BigDecimal.valueOf(100)).intValue();
        change.change(pennies);

        return change;

    }

    public void verifyInventory(Item item) throws NoInventoryException {
        if (item.getItemStock() <= 0) {
            throw new NoInventoryException("Item out of Stock");

        }
    }

    public Item updateInventory(Item item) throws VendingException {
        return dao.updateInventory(item);

    }

    public void checkFunds(BigDecimal itemCost, BigDecimal userMoney) throws InsufficentFundsException {
        if (itemCost.compareTo(userMoney) > 0) {
            throw new InsufficentFundsException("Insufficent Funds");
        }
    }

       @Override
    public Item getItem(String itemName) throws VendingException {
        return dao.getItem(itemName);
    }
}
