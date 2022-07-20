/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dao.CarDao;
import com.sg.cardealership.entity.Car;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author w-yan
 */
@Repository
public class CarDBDao implements CarDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Car addCar(Car car) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Car> getAllCars() {
        final String SELECT_ALL_CARS = "SELECT * FROM Cars";
        List<Car> locations = jdbcTemplate.query(SELECT_ALL_CARS, new CarMapper());
        return locations;
    }

    @Override
    public Car findCarById(int carId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCar(Car car) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCarById(int carId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //LocationMapper used to map a record from the location table to a location object.
    public static final class CarMapper implements RowMapper<Car> {

        @Override
        public Car mapRow(ResultSet rs, int index) throws SQLException {
            
            Car car = new Car();
            car.setId(rs.getInt("Id"));
            car.setBrand(rs.getString("Brand"));
            car.setPrice(rs.getBigDecimal("Price"));
            car.setIsNew(rs.getBoolean("isNew"));
            
            return car;
        }
    }
}
