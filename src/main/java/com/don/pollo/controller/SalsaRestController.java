package com.don.pollo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.don.pollo.services.SalsaService;

public class SalsaRestController {
    
    @Autowired
    private SalsaService salsaService;

    @GetMapping
    public List<Map<String, Object>> getAll(@RequestParam(defaultValue = "1") int page){
        return salsaService.getAllSalsas(page);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getSalsa(@PathVariable int id){
        return salsaService.getSalsaById(id);
    }

    @PostMapping
    public String create(@RequestBody Map<String, Object> salsa){
        return salsaService.createSalsa(salsa);
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Map<String, Object> salsa){
        return salsaService.updateSalsa(id, salsa);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return salsaService.deleteSalsa(id);
    }

}
