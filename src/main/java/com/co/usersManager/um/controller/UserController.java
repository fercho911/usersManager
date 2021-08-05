/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.usersManager.um.controller;

import lombok.extern.slf4j.Slf4j;
import com.co.usersManager.um.dao.UsuariosDao;
import com.co.usersManager.um.domain.ResponseUserList;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Rog
 */
@Data
@Slf4j
@Controller

public class UserController {
    //depencies injection

    @Autowired
    UsuariosDao usuarioDao;
    
    public ResponseUserList getUserList() {
        log.info("Inicia ejecucion del controllador");
        ResponseUserList userList = new ResponseUserList();
        var usuarios = usuarioDao.findAll();
       System.out.println(usuarios);
        return userList;

    }

}
