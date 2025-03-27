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
@Table(name = "corrales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorralModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "ubicacion", length = 150, nullable = false)
    private String ubicacion;

    @OneToMany(mappedBy = "corral", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PolloModel> pollos;

    public CorralModel(String nombre, String ubicacion, List<PolloModel> pollos) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.pollos = pollos;
    }

    public CorralModel(int id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public CorralModel(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }


    

}
