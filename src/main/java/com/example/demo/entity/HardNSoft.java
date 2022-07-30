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
public class HardNSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreHns;
    
    private String descripcionHns;

    public HardNSoft() {
    }

    public HardNSoft(String nombreHns, String descripcionHns) {
        this.nombreHns = nombreHns;
        this.descripcionHns = descripcionHns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHns() {
        return nombreHns;
    }

    public void setNombreHns(String nombreHns) {
        this.nombreHns = nombreHns;
    }

    public String getDescripcionHns() {
        return descripcionHns;
    }

    public void setDescripcionHns(String descripcionHns) {
        this.descripcionHns = descripcionHns;
    }
    
    
}
