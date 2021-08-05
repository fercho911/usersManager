/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.usersManager.um.service;

import com.co.usersManager.um.dao.RolDao;
import com.co.usersManager.um.domain.ResponseRolWS;
import com.co.usersManager.um.domain.Roles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rog
 */
@Service
public class RolServiceIMP  implements RolService{

    @Autowired
    RolDao rol;
    
    public ResponseRolWS findAll() {
        
        ResponseRolWS response = new ResponseRolWS();
        response.setRolList((List<Roles>) rol.findAll() );
        
        return  response ;
    }
    
}
