/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.usersManager.um.domain;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Rog
 */@Data
public class ResponseRolWS {
        
    private String errorCode;
    private String messageError;
    public List rolList;
    public Roles rol;
    
        
}
