package com.marugi.SpringConfig.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Usuario {

    String nombre;
    String clave;
    private static final Logger LOGGER=LoggerFactory.getLogger(Usuario.class);

    public Usuario() {
		LOGGER.info("Usuario creado");
		
    }
    

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        LOGGER.info("Usuario.setNombre(" + nombre + ")");

        this.nombre = nombre;
    }

    public String getClave(){
        return clave;        
    }

    public void setClave(String clave){
        LOGGER.info("Usuario.setClave(" + clave + ")");
        this.clave = clave;
    }

}