package com.co.usersManager.um.service;

import com.co.usersManager.um.domain.ResponseUserList;
import com.co.usersManager.um.domain.Usuario;
import java.util.List;

/**
 *
 * @author Rog
 */
public interface UserService {

    public ResponseUserList findAll();

    public ResponseUserList findByID(int id);

    public ResponseUserList save(Usuario usuario);
    
    public ResponseUserList update(Usuario usuario);
    
    public ResponseUserList findByName(String name);
    
    public ResponseUserList delete(Usuario user);

    


}
