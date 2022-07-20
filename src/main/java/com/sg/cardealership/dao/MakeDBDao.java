/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.entity.Make;
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
public class MakeDBDao implements MakeDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Make addMake(Make make) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Make> getAllMakes() {
        final String SELECT_ALL_MAKES = "SELECT * FROM Make";
        List<Make> makes = jdbcTemplate.query(SELECT_ALL_MAKES, new MakeMapper());
//        associateUser();
        return makes;
    }

    @Override
    public Make findMakeById(int makeId) {
        try {
            final String SELECT_MAKE_BY_ID = "SELECT * FROM Make WHERE makeId = ?";
            Make make = jdbcTemplate.queryForObject(SELECT_MAKE_BY_ID, new MakeMapper(), makeId);
//            associateUser();
            return make;
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public boolean updateMake(Make make) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteMakeById(int makeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void associateUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //MakeMapper used to map a record from the location table to a location object.
    public static final class MakeMapper implements RowMapper<Make> {

        @Override
        public Make mapRow(ResultSet rs, int index) throws SQLException {
            
            Make make = new Make();
            
            make.setId(rs.getInt("MakeId"));
            make.setName(rs.getString("Name"));
            make.setDateAdded(LocalDate.parse(rs.getDate("DateAdded").toString()));
            
            return make;
        }
    }
    
}
