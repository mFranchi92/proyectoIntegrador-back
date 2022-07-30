/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Dto.DtoHns;
import com.example.demo.Security.Controller.Message;
import com.example.demo.entity.HardNSoft;
import com.example.demo.service.SHardNSoft;
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
@RequestMapping("hardnsoft")
@CrossOrigin(origins = "http://localhost:4200")
public class HnsController {
    @Autowired
    SHardNSoft sHardNSoft;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HardNSoft>> list(){
        List<HardNSoft> list = sHardNSoft.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HardNSoft> getById(@PathVariable("id") int id){
        if(!sHardNSoft.existsById(id))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        HardNSoft hardNSoft = sHardNSoft.getOne(id).get();
        return new ResponseEntity(hardNSoft, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHns dtohns) {
        if(StringUtils.isBlank(dtohns.getNombreHns())){
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sHardNSoft.existsByNombreHns(dtohns.getNombreHns())){
            return new ResponseEntity(new Message("Ese skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        HardNSoft hardNSoft = new HardNSoft(dtohns.getNombreHns(), dtohns.getDescripcionHns());
        
        sHardNSoft.save(hardNSoft);
        
        return new ResponseEntity(new Message("Skill añadido"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHns dtohns){
        
        if(!sHardNSoft.existsById(id)){
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if(sHardNSoft.existsByNombreHns(dtohns.getNombreHns()) && sHardNSoft.getByNombreHns(dtohns.getNombreHns()).get().getId() != id ){
            return new ResponseEntity(new Message("Ese skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohns.getNombreHns())){
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        HardNSoft hardNSoft = sHardNSoft.getOne(id).get();
        
        hardNSoft.setNombreHns(dtohns.getNombreHns());
        
        hardNSoft.setDescripcionHns(dtohns.getDescripcionHns());
        
        sHardNSoft.save(hardNSoft);
        
        return new ResponseEntity(new Message("Skill actualizado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHardNSoft.existsById(id)) {
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        }
        sHardNSoft.delete(id);
        return new ResponseEntity(new Message("skill eliminado"), HttpStatus.OK);
    }
    
}
