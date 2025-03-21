package com.don.pollo.services;

import java.util.List;
import java.util.Map;

public interface CorralService {
    
    List<Map<String, Object>> getAllCorrales(int pag);
    Map<String, Object> getCorralById(int id);
    String createCorral(Map<String, Object> corral);
    String updateCorral(int id, Map<String, Object> corral);
    String deleteCorral(int id);
    int countCorrales();
    
}
