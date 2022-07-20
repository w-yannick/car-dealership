/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.User;
import java.util.List;

/**
 *
 * @author w-yan
 */
public interface UserDao {
    //CRUD: 
    //Create: Create a location
    User addUser(User user);
    
    //Read: get all locations
    List<User> getAllUsers();
    User findUserById(int userId);

    //Update: Update a location
    boolean updateUser(User user);

    //Delete: Delete a location
    boolean deleteUserById(int userId);
}
