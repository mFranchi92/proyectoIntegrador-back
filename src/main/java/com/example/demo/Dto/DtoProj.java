/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProj {
    
    @NotBlank
    private String nombreProj;
    @NotBlank
    private String descripcionProj;

    public DtoProj() {
    }

    public DtoProj(String nombreProj, String descripcionProj) {
        this.nombreProj = nombreProj;
        this.descripcionProj = descripcionProj;
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
