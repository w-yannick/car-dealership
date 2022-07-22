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
        //Superhumans
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
}
