/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.Car;
import com.sg.cardealership.entity.Make;
import com.sg.cardealership.entity.Model;
import com.sg.cardealership.entity.Vehicule;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author w-yan
 */
@Repository
public class VehiculeDBDao implements VehiculeDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        final String SELECT_ALL_VEHICULES = "SELECT * FROM Vehicule";
        List<Vehicule> vehicules = jdbcTemplate.query(SELECT_ALL_VEHICULES, new VehiculeMapper());
        for(Vehicule v: vehicules){
            associateModelAndMake(v);
        }
        return vehicules;
    }

    @Override
    public List<Vehicule> getFeaturedVehicules(){
        final String SELECT_ALL_VEHICULES = "SELECT * FROM Vehicule WHERE Featured = true";
        List<Vehicule> vehicules = jdbcTemplate.query(SELECT_ALL_VEHICULES, new VehiculeMapper());
        for(Vehicule v: vehicules){
            associateModelAndMake(v);
        }
        return vehicules;
    }
    
    @Override
    public Vehicule findVehiculeById(int vehiculeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateVehicule(Vehicule vehicule) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteVehiculeById(int vehiculeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void associateModelAndMake(Vehicule vehicule) {
        associateModel(vehicule);
        associateMake(vehicule.getModel());
        
    }

    private void associateModel(Vehicule vehicule) {
        final String SELECT_MODEL_FOR_VEHICULE = "SELECT MODEL.* FROM Model, VEHICULE WHERE Vehicule.vehiculeId = ? AND Vehicule.ModelId = Model.ModelId";
        Model model = jdbcTemplate.queryForObject(SELECT_MODEL_FOR_VEHICULE, new ModelDBDao.ModelMapper(), vehicule.getId());
        vehicule.setModel(model);
    }

    private void associateMake(Model model) {
        
        final String SELECT_MAKE_FOR_MODEL = "SELECT Make.* FROM Make,Model WHERE Make.makeId = Model.makeId AND Model.ModelId = ?";
        Make make = jdbcTemplate.queryForObject(SELECT_MAKE_FOR_MODEL, new MakeDBDao.MakeMapper(), model.getId());
        model.setMake(make);
       
    }
    
        //LocationMapper used to map a record from the location table to a location object.
    public static final class VehiculeMapper implements RowMapper<Vehicule> {

        @Override
        public Vehicule mapRow(ResultSet rs, int index) throws SQLException {
            
            Vehicule vehicule = new Vehicule();
            vehicule.setId(rs.getInt("VehiculeId"));
            vehicule.setType(rs.getString("Type"));
            vehicule.setBodyStyle(rs.getString("BodyStyle"));
            vehicule.setYear(rs.getInt("Year"));
            vehicule.setAutomatic(rs.getBoolean("Automatic"));
            vehicule.setExteriorColor(rs.getString("ExteriorColor"));
            vehicule.setInteriorColor(rs.getString("InteriorColor"));
            vehicule.setMileage(rs.getInt("Mileage"));
            vehicule.setVINNumber(rs.getString("VINNumber"));
            vehicule.setMSRP(rs.getBigDecimal("MSRP"));
            vehicule.setSalePrice(rs.getBigDecimal("SalePrice"));
            vehicule.setDescription(rs.getString("Description"));
            vehicule.setFeatured(rs.getBoolean("Featured"));
            vehicule.setAvailable(rs.getBoolean("Available"));
            return vehicule;
        }
    }
    
}
