/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.usersManager.um.web;
import com.co.usersManager.um.domain.ResponseRolWS;
import com.co.usersManager.um.domain.ResponseUserList;
import com.co.usersManager.um.domain.Usuario;
import com.co.usersManager.um.service.RolService;
import com.co.usersManager.um.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rog
 */
@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/users")

public class UserWebController {

    @Autowired
    UserService user;
    
     @Autowired
     RolService rol;
    
    
    
    @GetMapping("/list")
    public ResponseUserList getUserList() {
        return user.findAll();
    }

    @GetMapping("/getUser/{id}")
    public ResponseUserList getUserByID(@PathVariable("id") int id) {
        return user.findByID(id);
    }
    
    @PostMapping("/create")
    public ResponseUserList createUser(@RequestBody Usuario newUser) {
        return user.save( new Usuario(newUser.getRol(), newUser.getNombre(), newUser.getActivo()));
    }
    
    @PostMapping("/update")
    public ResponseUserList updateUser(@RequestBody Usuario newUser) {
        
        System.out.println(newUser);
        return user.update(new Usuario(newUser.getId_usuario(),newUser.getRol(), newUser.getNombre(), newUser.getActivo()));
    }
    
    @GetMapping("/findByName/{name}")
    public ResponseUserList findByName(@PathVariable("name") String name) {
        return user.findByName(name);
    }
    
    
     @GetMapping("/rolList")
    public ResponseRolWS getRolList() {
        return rol.findAll();
    }
    
    @PostMapping("/delete")
    public ResponseUserList deleteUser(@RequestBody Usuario newUser) {
        System.out.println("com.co.usersManager.um.web.UserWebController.deleteUser()");
        return user.delete( new Usuario(newUser.getId_usuario(),newUser.getRol(), newUser.getNombre(), newUser.getActivo()));
        
    }
        
}
