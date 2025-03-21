package com.don.pollo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salsas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalsaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "nivel_picante", nullable = false)
    private int nivel_picante;

    @OneToMany(mappedBy = "salsa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PolloModel> pollos;

    public SalsaModel(String nombre, int nivel_picante, List<PolloModel> pollos) {
        this.nombre = nombre;
        this.nivel_picante = nivel_picante;
        this.pollos = pollos;
    }

    

}
