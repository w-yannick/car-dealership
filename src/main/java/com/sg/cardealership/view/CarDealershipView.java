/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.view;

import org.springframework.stereotype.Component;

/**
 *
 * @author w-yan
 */
@Component
public class CarDealershipView {
    public String displayIndexPage(){
        return "index";
    }
    
    public String displayInventoryPage(){
        return "inventory";
    }
    
    public String displaySpecialPage(){
        return "specials";
    }

    public String displayContactPage(){
        return "contact";
    }

    public String displayVehiculeDetailsPage(){
        return "vehiculeDetails";
    }
    
    public String displaySalesPage(){
        return "sales";
    }
    
    public String displayAdminPage(){
        return "admin";
    }
    
    public String displayLoginPage(){
        return "login";
    }
    public String displayLoginSucessPage(){
        return "loginSuccess";
    }
    public String displayPurchasePage(){
        return "purchase";
    }
    public String displayAdminVehiculesPage(){
        return "adminVehicules";
    }
    public String displayAddVehiculePage(){
        return "addVehicule";
    }
    
    public String displayUsersPage(){
        return "users";
    }
    public String displayAddUserPage(){
        return "addUser";
    }
    public String displayEditUserPage(){
        return "editUser";
    }
    public String displayChangePasswordPage(){
        return "changePassword";
    }
    public String displayMakesPage(){
        return "makes";
    }
    public String displayModelsPage(){
        return "models";
    }
    public String displayAdminSpecialsPage(){
        return "adminSpecials";
    }
    public String displayReportsPage(){
        return "reports";
    }
    public String displayInventoryReportPage(){
        return "inventoryReport";
    }
    public String displaySalesReportPage(){
        return "salesReport";
    }
}
