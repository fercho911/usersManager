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
        try {
            userList.setUserList((List<Usuario>) usuariosDao.findAll());
        } catch (Exception e) {
            userList.setMessageError(e.getMessage());
            userList.setErrorCode("505");
        }
        return userList;

    }

    @Override
    @Transactional(readOnly = true)

    public ResponseUserList findByID(int id) {

        ResponseUserList userList = new ResponseUserList();
        try {
            userList.setUser(usuariosDao.findById(id).orElse(null));
        } catch (Exception e) {
            userList.setMessageError(e.getMessage());
            userList.setErrorCode("505");
        }
        return userList;
    }

    @Override
    @Transactional
    public ResponseUserList save(Usuario usuario) {
        ResponseUserList userList = new ResponseUserList();
        boolean existe = false;
        var lista = usuariosDao.findByNombreContaining(usuario.getNombre());
        for (Usuario user : lista) {
            if (user.getNombre().equals(usuario.getNombre())) {
                existe = true;
            }
        }

        try {

            if (existe == false) {
                userList.setUser(usuariosDao.save(usuario));
                userList.setErrorCode("0");
                userList.setMessageError("Se creo el usuario exitosamente");
            } else {

                System.out.println("entra al else");
                userList.setErrorCode("205");
                userList.setMessageError("Ya existe un usuario creado con el nombre ingresado");
            }
        } catch (Exception e) {
            userList.setMessageError(e.getMessage());
            userList.setErrorCode("505");
        }
        return userList;

    }

    @Override
    @Transactional
    public ResponseUserList update(Usuario usuario) {
        ResponseUserList userList = new ResponseUserList();
        try {

            boolean existe = false;
            var lista = usuariosDao.findByNombreContaining(usuario.getNombre());
            System.out.println(lista);
            for (Usuario user : lista) {
                if (user.getNombre().equals(usuario.getNombre()) && user.getId_usuario() != usuario.getId_usuario() ) {
                    existe = true;
                }
            }
            
            if (existe == false){  
                userList.setUser(usuariosDao.save(usuario));
                userList.setErrorCode("0");
                userList.setMessageError("Se actualizo el usuario exitosamente");
            }else {
                System.out.println("else no existe");
                userList.setErrorCode("205");
                userList.setMessageError("Ya existe un usuario creado con el nombre ingresado");
            }

        } catch (Exception e) {
            userList.setMessageError(e.getMessage());
            userList.setErrorCode("505");
        }
        
        return userList;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseUserList findByName(String name) {
        ResponseUserList userList = new ResponseUserList();
        try {
            userList.setUserList(usuariosDao.findByNombreContaining(name));
        } catch (Exception e) {
            userList.setMessageError(e.getMessage());
            userList.setErrorCode("505");
        }
        return userList;
    }

    public ResponseUserList delete(Usuario user) {
        ResponseUserList userList = new ResponseUserList();
        try {
            usuariosDao.deleteById(user.getId_usuario());
            userList.setErrorCode("0");
            userList.setMessageError("Se elimino el usuario exitosamente");
            System.out.println("com.co.usersManager.um.service.UserServiceIMP.delete()");
        } catch (Exception e) {
            userList.setMessageError(e.getMessage());
            userList.setErrorCode("505");
        }
        return userList;
    }

}
