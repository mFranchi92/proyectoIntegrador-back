/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.repository.RProject;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProject {
    @Autowired
    RProject rProject;
    
    public List<Project> list(){
        
        return rProject.findAll();
    }
    
    public Optional<Project> getOne(int id){
        return rProject.findById(id);
    }
    
    public Optional<Project> getByNombreProj(String nombreProj) {
        return rProject.findByNombreProj(nombreProj);
    }
    
    public void save(Project proj){
        rProject.save(proj);
    }
    
    public void delete(int id){
        rProject.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rProject.existsById(id);
    }
    
    public boolean existsByNombreProj(String nombreProj){
        return rProject.existsByNombreProj(nombreProj);
    }
}
