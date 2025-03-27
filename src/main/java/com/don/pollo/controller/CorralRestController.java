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

import com.don.pollo.services.CorralService;

@RestController
@RequestMapping("/corrales")
public class CorralRestController {
    
    @Autowired
    private CorralService corralService;

    @GetMapping
    public List<Map<String, Object>> getAll(@RequestParam(defaultValue = "1") int page){
        return corralService.getAllCorrales(page);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getCorral(@PathVariable int id){
        return corralService.getCorralById(id);
    }

    @PostMapping
    public String create(@RequestBody Map<String, Object> corral){
        return corralService.createCorral(corral);
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Map<String, Object> corral){
        return corralService.updateCorral(id, corral);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return corralService.deleteCorral(id);
    }

}
