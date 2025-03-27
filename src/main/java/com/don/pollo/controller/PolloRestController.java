package com.don.pollo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.don.pollo.services.PolloService;

@RestController
@RequestMapping("/pollos")
public class PolloRestController {
    
    @Autowired
    private PolloService polloService;

    @GetMapping
    public List<Map<String, Object>> getAll(@RequestParam(defaultValue = "1") int page){
        return polloService.getAllPollos(page);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getPollo(@PathVariable int id){
        return polloService.getPolloById(id);
    }

    @PostMapping
    public String create(@RequestBody Map<String, Object> pollo){
        return polloService.createPollo(pollo);
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Map<String, Object> pollo){
        return polloService.updatePollo(id, pollo);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return polloService.deletePollo(id);
    }

}
