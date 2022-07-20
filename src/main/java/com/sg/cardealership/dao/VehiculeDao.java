/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.Vehicule;
import java.util.List;

/**
 *
 * @author w-yan
 */
public interface VehiculeDao {
    //CRUD: 
    //Create: Create a location
    Vehicule addVehicule(Vehicule vehicule);
    
    //Read: get all locations
    List<Vehicule> getAllVehicules();
    Vehicule findVehiculeById(int vehiculeId);

    //Update: Update a location
    boolean updateVehicule(Vehicule vehicule);

    //Delete: Delete a location
    boolean deleteVehiculeById(int vehiculeId);
}
