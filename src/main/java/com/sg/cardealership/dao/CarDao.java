/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.Car;
import java.util.List;

/**
 *
 * @author w-yan
 */
public interface CarDao {
    //CRUD: 
    //Create: Create a location
    Car addCar(Car car);
    
    //Read: get all locations
    List<Car> getAllCars();
    Car findCarById(int carId);

    //Update: Update a location
    boolean updateCar(Car car);

    //Delete: Delete a location
    boolean deleteCarById(int carId);
}
