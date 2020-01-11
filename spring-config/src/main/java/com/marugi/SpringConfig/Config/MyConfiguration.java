package com.marugi.SpringConfig.Config;

import java.util.HashMap;
import java.util.Map;
import com.marugi.SpringConfig.model.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mario Rubio
 * Clase de configuracion para cargar un fichero de propiedades de la aplicacion
 * Probamos los arrays de objetos (usuarios) en un fichero de configuracion tipo yaml
 * que sea distinto al aplicacion.properties o application.yaml que es donde 
 * me han aparecido problemas a la hora de convertir un map en un objeto especifico.
 * 
 * Se elimina referencia a propertySource, @PropertySource("configFile.yml") 
 * puesto que no se requiere ya que cargamos a nivel de aplicacion como fichero 
 * principal de configuracion el fichero configFile.yml 
 *
 */
@Configuration
@ConfigurationProperties
public class MyConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyConfiguration.class);

	@Value("${autor}")
	String autor;

	String empresa;

	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

	public Map<String, Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Map<String, Usuario> usuarios) {
		LOGGER.info("setUsuarios()" + usuarios);
		this.usuarios = usuarios;
	}

	public MyConfiguration() {
		LOGGER.info("MyConfiguration creado");

	}

	// companyia
	public String getEmpresa() {
		LOGGER.info("getEmpresa->" + empresa);

		return empresa;
	}

	public void setEmpresa(String empresa) {

		LOGGER.info("setEmpresa(" + empresa + ")");
		this.empresa = empresa;
	}

	// autor
	public String getAutor() {

		LOGGER.info("getAutor->" + autor);
		return autor;
	}

	public void setAutor(String autor) {

		LOGGER.info("setAutor(" + autor + ")");
		this.autor = autor;
	}

}