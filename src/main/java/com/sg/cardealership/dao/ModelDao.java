/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.Model;
import java.util.List;

/**
 *
 * @author w-yan
 */
public interface ModelDao {
    //CRUD: 
    //Create: Create a location
    Model addModel(Model model);
    
    //Read: get all locations
    List<Model> getAllModels();
    Model findModelById(int modelId);

    //Update: Update a location
    boolean updateModel(Model model);

    //Delete: Delete a location
    boolean deleteModelById(int modelId);
}
