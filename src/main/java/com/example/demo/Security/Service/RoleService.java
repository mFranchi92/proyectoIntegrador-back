/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Security.Service;

import com.example.demo.Security.Entity.Role;
import com.example.demo.Security.Enums.RoleName;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Security.Repository.IRoleRepository;
import java.util.Optional;

@Service
@Transactional
public class RoleService {
    @Autowired
    IRoleRepository iRoleRepository;
    
    public Optional<Role> getByRoleName(RoleName roleName){
        return iRoleRepository.findByRoleName(roleName);
    }
    
    public void save(Role role){
        iRoleRepository.save(role);
    }
}
