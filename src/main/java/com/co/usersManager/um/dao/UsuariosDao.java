/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.usersManager.um.dao;

import com.co.usersManager.um.domain.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rog
 * @comment crud repositori is a java class thah implements 
 */
public interface UsuariosDao extends CrudRepository<Usuario, Integer>{
 // spring create the implementation of this interface by default so it's not necesary to do that again   
    
   public List<Usuario> findByNombreContaining(String nombre);

    
}
