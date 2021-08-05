/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.usersManager.um.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Rog
 */
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    
    @ManyToOne
    @JoinColumn(name="id_rol")
    private Roles rol;
    
    @Column(name ="nombre")   
    private String nombre;
    private String activo;
    
    public Usuario(){}


    public Usuario(Roles rol, String nombre, String activo) {

        this.nombre = nombre;
        this.rol = rol;
        this.activo = activo;
        }
    
    public Usuario(Integer id_usuario, Roles rol, String nombre, String activo) {

        this.nombre = nombre;
        this.rol = rol;
        this.activo = activo;
        this.id_usuario = id_usuario;
        }
    
    /*
     public Usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    */
    }


