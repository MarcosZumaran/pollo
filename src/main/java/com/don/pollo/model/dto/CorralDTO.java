package com.don.pollo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorralDTO {
    int id;
    String nombre;
    String ubicacion;
}
