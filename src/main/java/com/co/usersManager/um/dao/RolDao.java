/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.usersManager.um.dao;
import com.co.usersManager.um.domain.Roles;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rog
 */
public interface RolDao extends CrudRepository<Roles, Integer> {
    
}
