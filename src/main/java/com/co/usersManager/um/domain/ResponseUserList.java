/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.usersManager.um.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Rog
 */

@Data
public class ResponseUserList {
  
    public List userList;
    public Usuario user;
    private String errorCode;
    private String messageError;
    
}
 