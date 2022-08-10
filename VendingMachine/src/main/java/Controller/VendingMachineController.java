/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.InsufficentFundsException;
import Service.NoInventoryException;
import Service.VendingMachineServiceImpl;
import UI.VendingMachineView;
import VendingDao.VendingException;
import VendingDto.Change;
import VendingDto.Item;
import java.math.BigDecimal;

/**
 *
 */
public class VendingMachineController {
      VendingMachineView view;
    VendingMachineServiceImpl service;

    public VendingMachineController(VendingMachineView view, VendingMachineServiceImpl service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        String menuSelection = "";

        Boolean next = true;
        while (next) {

            try {
                menuSelection = getMenuSelection();

                Item select = service.getItem(menuSelection);

                if (select == null) {
                    view.validItem();
                    continue;

                }
                BigDecimal money = view.getuserMoney();

                try {
                    service.checkFunds(select.getItemCost(), money);
                } catch (InsufficentFundsException e) {
                    view.insufficentFundsBanner();
                    continue;
                }

                try {
                    service.verifyInventory(select);
                } catch (NoInventoryException e) {
                    view.noInventoryBanner();
                    continue;
                }

                Change change = service.getChange(select.getItemCost(), money);
                view.getChange(change);

                service.updateInventory(select);
            } catch (VendingException e) {
                view.errorMessage(e.getMessage());
            }
        }
    }

    private String getMenuSelection() throws VendingException {
        return view.printMenuAndGetSelection(service.getAllItems());
    }

}

