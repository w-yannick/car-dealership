/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.Sale;
import java.util.List;

/**
 *
 * @author w-yan
 */
public interface SaleDao {
    //CRUD: 
    //Create: Create a location
    Sale addSale(Sale sale);
    
    //Read: get all locations
    List<Sale> getAllSales();
    Sale findSaleById(int saleId);

    //Update: Update a location
    boolean updateSale(Sale sale);

    //Delete: Delete a location
    boolean deleteSaleById(int saleId);
}
