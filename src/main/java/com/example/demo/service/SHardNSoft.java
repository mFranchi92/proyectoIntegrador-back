/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.HardNSoft;
import com.example.demo.repository.RHardNSoft;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHardNSoft {
    
    @Autowired
    RHardNSoft rHardNSoft;
    
    public List<HardNSoft> list(){
        return rHardNSoft.findAll();
    }
    
    public Optional<HardNSoft> getOne(int id){
        return rHardNSoft.findById(id);
    }
    
    public Optional<HardNSoft> getByNombreHns(String nombreHns) {
        return rHardNSoft.findByNombreHns(nombreHns);
    }
    
    public void save(HardNSoft hns){
        rHardNSoft.save(hns);
    }
    
    public void delete(int id){
        rHardNSoft.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rHardNSoft.existsById(id);
    }
    
    public boolean existsByNombreHns(String nombreHns){
        return rHardNSoft.existsByNombreHns(nombreHns);
    }
    
}
