/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreProj;
    
    private String descripcionProj;

    public Project() {
    }

    public Project(String nombreProj, String descripcionProj) {
        this.nombreProj = nombreProj;
        this.descripcionProj = descripcionProj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProj() {
        return nombreProj;
    }

    public void setNombreProj(String nombreProj) {
        this.nombreProj = nombreProj;
    }

    public String getDescripcionProj() {
        return descripcionProj;
    }

    public void setDescripcionProj(String descripcionProj) {
        this.descripcionProj = descripcionProj;
    }
    
    
    
}
