package com.don.pollo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pollos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolloModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "picante", nullable = false)
    private boolean picante;

    @ManyToOne
    @JoinColumn(name = "id_corral", nullable = false)
    private CorralModel corral;

    @ManyToOne
    @JoinColumn(name = "id_salsa", nullable = false)
    private SalsaModel salsa;

    public PolloModel(String nombre, boolean picante, CorralModel corral, SalsaModel salsa) {
        this.nombre = nombre;
        this.picante = picante;
        this.corral = corral;
        this.salsa = salsa;
    }

    public PolloModel(int id, String nombre, boolean picante) {
        this.id = id;
        this.nombre = nombre;
        this.picante = picante;
    }

    public PolloModel(String nombre, boolean picante) {
        this.nombre = nombre;
        this.picante = picante;
    }
 
    

}
