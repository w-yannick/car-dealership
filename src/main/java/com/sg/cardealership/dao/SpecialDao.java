/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.Special;
import java.util.List;

/**
 *
 * @author w-yan
 */
public interface SpecialDao {
    //CRUD: 
    //Create: Create a location
    Special addSpecial(Special special);
    
    //Read: get all locations
    List<Special> getAllSpecials();
    Special findSpecialById(int specialId);

    //Update: Update a location
    boolean updateSpecial(Special special);

    //Delete: Delete a location
    boolean deleteSpecialById(int specialId);
}
