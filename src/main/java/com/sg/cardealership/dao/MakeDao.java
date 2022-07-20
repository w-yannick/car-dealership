/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.Make;
import java.util.List;

/**
 *
 * @author w-yan
 */
public interface MakeDao {
    //CRUD: 
    //Create: Create a location
    Make addMake(Make make);
    
    //Read: get all locations
    List<Make> getAllMakes();
    Make findMakeById(int makeId);

    //Update: Update a location
    boolean updateMake(Make make);

    //Delete: Delete a location
    boolean deleteMakeById(int makeId);
}
