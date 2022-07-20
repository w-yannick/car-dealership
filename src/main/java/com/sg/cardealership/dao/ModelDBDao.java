/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.Make;
import com.sg.cardealership.entity.Model;
import com.sg.cardealership.entity.Vehicule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class ModelDBDao implements ModelDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Model addModel(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Model> getAllModels() {
        final String SELECT_ALL_MODELS = "SELECT * FROM Model";
        List<Model> models = jdbcTemplate.query(SELECT_ALL_MODELS, new ModelMapper());
        for(Model model: models){
            associateMakeAndUser(model);
        }
        return models;
    }

    @Override
    public Model findModelById(int modelId) {
        try {
            final String SELECT_MODEL_BY_ID = "SELECT * FROM Model WHERE modelId = ?";
            Model model = jdbcTemplate.queryForObject(SELECT_MODEL_BY_ID, new ModelMapper(), modelId);
            associateMakeAndUser(model);
            return model;
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public boolean updateModel(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteModelById(int modelId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void associateMakeAndUser(Model model) {
        associateMake(model);
//        associateUser(model);
        
    }

    public void associateMake(Model model) {
        try {
            final String SELECT_MAKE_FOR_MODEL = "SELECT * FROM Make USING Model, Make WHERE makeId = Model.makeId";
            Make make = jdbcTemplate.queryForObject(SELECT_MAKE_FOR_MODEL, new MakeDBDao.MakeMapper());
            model.setMake(make);
        } catch(DataAccessException ex) {
        }
    }

    private void associateUser(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static final class ModelMapper implements RowMapper<Model> {

        @Override
        public Model mapRow(ResultSet rs, int index) throws SQLException {
            
            Model model = new Model();
            model.setId(rs.getInt("ModelId"));
            model.setName(rs.getString("Name"));
            model.setDateAdded(LocalDate.parse(rs.getDate("DateAdded").toString()));
            
            return model;
        }
    }
}
