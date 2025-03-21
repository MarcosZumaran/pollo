package com.don.pollo.services;

import java.util.List;
import java.util.Map;

public interface SalsaService {
    
    List<Map<String, Object>> getAllSalsas(int pag);
    Map<String, Object> getSalsaById(int id);
    String createSalsa(Map<String, Object> salsa);
    String updateSalsa(int id, Map<String, Object> salsa);
    String deleteSalsa(int id);
    int countSalsas();
    
}
