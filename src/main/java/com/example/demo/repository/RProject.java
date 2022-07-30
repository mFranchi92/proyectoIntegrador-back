/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RProject extends JpaRepository<Project, Integer>{
            
        public Optional<Project> findByNombreProj(String nombreProj);
    
        public boolean existsByNombreProj(String nombreProj);
}
