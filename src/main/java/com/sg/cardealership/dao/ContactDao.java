/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.Contact;
import java.util.List;

/**
 *
 * @author w-yan
 */
public interface ContactDao {
    //CRUD: 
    //Create: Create a location
    Contact addContact(Contact Contact);
    
    //Read: get all locations
    List<Contact> getAllContacts();
    Contact findContactById(int ContactId);

    //Update: Update a location
    boolean updateContact(Contact Contact);

    //Delete: Delete a location
    boolean deleteContactById(int contactId);
}
