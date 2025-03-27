package com.don.pollo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalsaDTO {
    int id;
    String nombre;
    int nivel_picante;
}
