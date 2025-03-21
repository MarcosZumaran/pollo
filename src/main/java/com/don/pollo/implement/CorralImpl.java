package com.don.pollo.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.don.pollo.services.CorralService;

@Service
public class CorralImpl implements CorralService{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllCorrales(int pag){
        if (pag <= 0) pag = 1;
        int limit = 10;
        int offset = (pag - 1) * limit;
        String sql = "SELECT id, nombre, ubicacion FROM corrales LIMIT ? OFFSET ?";
        return jdbcTemplate.queryForList(sql, limit, offset);
    }

    @Override
    public Map<String, Object> getCorralById(int id){
        String sql = "SELECT * FROM corrales WHERE id=?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    @Override
    public String createCorral(Map<String, Object> corral){
        String sql = "INSERT INTO corrales (nombre, ubicacion) VALUES(?, ?)";
        jdbcTemplate.update(sql, corral.get("nombre"), corral.get("ubicacion"));
        return "Corral Creado con éxito.";
    }

    @Override
    public String updateCorral(int id, Map<String, Object> corral){
        String sql = "UPDATE corrales SET nombre = ?, ubicacion = ? WHERE id = ?";
        jdbcTemplate.update(sql, corral.get("nombre"), corral.get("ubicacion"));
        return "Corral actualizado con éxito.";
    }

    @Override
    public String deleteCorral(int id){
        String sql = "DELETE FROM corrales WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return "Corral eliminado con éxito.";
    }

    @Override
    public int countCorrales(){
        String sql = "SELECT COUNT(id) FROM corrales";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return (count != null) ? count : 0;
    }

}
