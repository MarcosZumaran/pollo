package com.don.pollo.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.don.pollo.services.PolloService;

@Service
public class PolloImpl implements PolloService{
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllPollos( int pag){
        if (pag <= 0) pag = 1;
        int limit = 10;
        int offset = (pag - 1) * limit;
        String sql = "SELECT id, nombre, picante, id_corral, id_salsa FROM pollos LIMIT ? OFFSET ?";
        return jdbcTemplate.queryForList(sql, limit, offset);
    }

    public List<Map<String, Object>> getAllPollosNotForeigns( int pag){
        if (pag <= 0) pag = 1;
        int limit = 10;
        int offset = (pag - 1) * limit;
        String sql = "SELECT id, nombre, picante FROM pollos LIMIT ? OFFSET ?";
        return jdbcTemplate.queryForList(sql, limit, offset);
    }

    @Override
    public Map<String, Object> getPolloById(int id){
        String sql = "SELECT * FROM pollos WHERE id = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    @Override
    public String createPollo(Map<String, Object> pollo){
        String sql = "INSERT INTO pollos (nombre, picante, id_corral, id_salsa) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, pollo.get("nombre"), pollo.get("picante"), pollo.get("id_corral"), pollo.get("id_salsa"));
        return "Pollo creado con éxito.";
    }

    @Override
    public String updatePollo(int id, Map<String, Object> pollo){
        String sql = "UPDATE pollos SET nombre = ?, picante = ?, id_corral = ?, id_salsa = ? WHERE id = ?";
        jdbcTemplate.update(sql, pollo.get("nombre"), pollo.get("picante"), pollo.get("id_corral"), pollo.get("id_salsa"), id);
        return "Pollo actualizado con éxito.";
    }

    @Override
    public String deletePollo(int id){
        String sql = "DELETE FROM pollos WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return "Pollo eliminado con éxito.";
    }

    
    @Override
    public int countPollos(){
        String sql = "SELECT COUNT(id) FROM pollos";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return (count != null) ? count : 0;
    }

}
