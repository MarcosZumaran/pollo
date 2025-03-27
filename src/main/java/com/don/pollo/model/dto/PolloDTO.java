package com.don.pollo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolloDTO {
    int id;
    String nombre;
    boolean picante;
    int id_corral;
    int id_salsa;
}
