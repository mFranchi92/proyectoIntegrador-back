/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.entity.Experiencia;
import com.example.demo.entity.HardNSoft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RHardNSoft extends JpaRepository<HardNSoft, Integer>{
        
        public Optional<HardNSoft> findByNombreHns(String nombreHns);
    
        public boolean existsByNombreHns(String nombreHns);
}
