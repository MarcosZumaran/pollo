package com.don.pollo.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.don.pollo.services.SalsaService;

@Service
public class SalsaImpl implements SalsaService{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllSalsas(int pag){
        if (pag <= 0) pag = 1;
        int limit = 10;
        int offset = (pag - 1) * limit;
        String sql = "SELECT id, nivel_picante, nombre FROM salsas LIMIT ? OFFSET ?";
        return jdbcTemplate.queryForList(sql, limit, offset);
    }

    @Override
    public Map<String, Object> getSalsaById(int id){
        String sql = "SELECT * FROM salsas WHERE id = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    @Override
    public String createSalsa(Map<String, Object> salsa){
        String sql = "INSERT INTO salsas(nivel_picante, nombre) VALUES(?, ?)";
        jdbcTemplate.update(sql, salsa.get("nivel_picante"), salsa.get("nombre"));
        return "Salsa creadaa con éxito.";
    }

    @Override
    public String updateSalsa(int id, Map<String, Object> salsa){
        String sql = "UPDATE salsas SET nivel_picante = ?, nombre = ? WHERE id = ?";
        jdbcTemplate.update(sql, salsa.get("nivel_picante"), salsa.get("nombre"), id);
        return "Salsa actuazliada con éxito.";
    }
    
    @Override
    public String deleteSalsa(int id){
        String sql = "DELETE FROM salsas WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return "Salsa eliminado con éxito.";
    }

    @Override
    public int countSalsas(){
        String sql = "SELECT COUNT(id) FROM salsas";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return (count != null) ? count : 0;
    }
}
