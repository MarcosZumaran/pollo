package com.don.pollo.services;

import java.util.List;
import java.util.Map;

public interface PolloService {
    
    List<Map<String, Object>> getAllPollos(int pag);
    Map<String, Object> getPolloById(int id);
    String createPollo(Map<String,Object> pollo);
    String updatePollo(int id, Map<String, Object> pollo);
    String deletePollo(int id);
    int countPollos();
    
}
