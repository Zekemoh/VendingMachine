/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingDto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 
 */
public class Item {
       String itemName;
    BigDecimal itemCost;
    int itemStock;
    
       public Item() {
    }

    public Item(String itemName, BigDecimal itemCost, int itemStock) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemStock = itemStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemCost() {
        return itemCost;
    }

    public void setItemCost(BigDecimal itemCost) {
        this.itemCost = itemCost;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.itemName);
        hash = 17 * hash + Objects.hashCode(this.itemCost);
        hash = 17 * hash + this.itemStock;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.itemStock != other.itemStock) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemCost, other.itemCost)) {
            return false;
        }
        return true;
    }

}
