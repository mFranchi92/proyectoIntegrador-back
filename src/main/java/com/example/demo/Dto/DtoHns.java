/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Dto;

import javax.validation.constraints.NotBlank;

public class DtoHns {
    @NotBlank
    private String nombreHns;
    @NotBlank
    private String descripcionHns;

    public DtoHns() {
    }

    public DtoHns(String nombreHns, String descripcionHns) {
        this.nombreHns = nombreHns;
        this.descripcionHns = descripcionHns;
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
