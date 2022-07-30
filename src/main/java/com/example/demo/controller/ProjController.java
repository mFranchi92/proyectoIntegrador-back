/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Dto.DtoProj;
import com.example.demo.Security.Controller.Message;
import com.example.demo.entity.Project;
import com.example.demo.service.SProject;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("projects")
@CrossOrigin(origins = "https://apfrontproj.web.app/")
public class ProjController {
    @Autowired
    SProject sProject;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Project>> list(){
        List<Project> list = sProject.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id){
        if(!sProject.existsById(id))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        Project project = sProject.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProj dtoproj) {
        if(StringUtils.isBlank(dtoproj.getNombreProj())){
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sProject.existsByNombreProj(dtoproj.getNombreProj())){
            return new ResponseEntity(new Message("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Project project = new Project(dtoproj.getNombreProj(), dtoproj.getDescripcionProj());
        
        sProject.save(project);
        
        return new ResponseEntity(new Message("Proyecto añadido"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProj dtoproj){
        
        if(!sProject.existsById(id)){
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if(sProject.existsByNombreProj(dtoproj.getNombreProj()) && sProject.getByNombreProj(dtoproj.getNombreProj()).get().getId() != id ){
            return new ResponseEntity(new Message("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproj.getNombreProj())){
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Project project = sProject.getOne(id).get();
        
        project.setNombreProj(dtoproj.getNombreProj());
        
        project.setDescripcionProj(dtoproj.getDescripcionProj());
        
        sProject.save(project);
        
        return new ResponseEntity(new Message("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        }
        sProject.delete(id);
        return new ResponseEntity(new Message("Proyecto eliminado"), HttpStatus.OK);
    }
    
}
