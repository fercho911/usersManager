package com.co.usersManager.um.service;

import com.co.usersManager.um.dao.UsuariosDao;
import com.co.usersManager.um.domain.ResponseUserList;
import com.co.usersManager.um.domain.Usuario;
import java.util.List;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rog
 */
@Service
public class UserServiceIMP implements UserService {

    @Autowired
    UsuariosDao usuariosDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseUserList findAll() {
        ResponseUserList userList = new ResponseUserList();
        userList.setUserList((List<Usuario>) usuariosDao.findAll());
        return userList;
    }

    @Override
    @Transactional(readOnly = true)

    public ResponseUserList findByID(int id) {
        ResponseUserList userList = new ResponseUserList();
        userList.setUser(usuariosDao.findById(id).orElse(null));
        return userList;
    }

    @Override
    @Transactional
    public ResponseUserList save(Usuario usuario) {
        ResponseUserList userList = new ResponseUserList();
         
         /*
        var exist = false;
         usuariosDao.findByNombreContaining(usuario.getNombre()).forEach((t) -> {
             if (t.getNombre().equals(usuario.getNombre())){
                   exist = true;
             }
         }); */
           

        if (usuariosDao.findByNombreContaining(usuario.getNombre()).isEmpty()) {
            userList.setUser(usuariosDao.save(usuario));
            userList.setErrorCode("0");
            userList.setMessageError("Se creo el usuario exitosamente");
        } else {
            
        System.out.println("entra al else");
            userList.setErrorCode("205");
            userList.setMessageError("Ya existe un usuario creado con el nombre ingresado");
        }
        return userList;

    }

    @Override
    @Transactional
    public ResponseUserList update(Usuario usuario) {
        ResponseUserList userList = new ResponseUserList();
        //  usuariosDao.findByNombreContaining(usuario.getNombre())
        //if (usuariosDao.findByNombreContaining(usuario.getNombre()).isEmpty()) {
            userList.setUser(usuariosDao.save(usuario));
            System.out.println(userList.getUser().getId_usuario());
            if(userList.getUser().getId_usuario() != null ){
                userList.setErrorCode("0");
                userList.setMessageError("Se actualizo el usuario exitosamente");
            }
      /*  } else {
            userList.setErrorCode("205");
            userList.setMessageError("Ya existe un usuario creado con el nombre ingresado");
        }
*/
        return userList;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseUserList findByName(String name) {
        ResponseUserList userList = new ResponseUserList();
        userList.setUserList(usuariosDao.findByNombreContaining(name));
        return userList;
    }
    
       public ResponseUserList delete(Usuario user) {
        ResponseUserList userList = new ResponseUserList();
        usuariosDao.deleteById(user.getId_usuario());
        userList.setErrorCode("0");
        userList.setMessageError("Se elimino el usuario exitosamente");
           System.out.println("com.co.usersManager.um.service.UserServiceIMP.delete()");
        return userList;  
    }
    
}
