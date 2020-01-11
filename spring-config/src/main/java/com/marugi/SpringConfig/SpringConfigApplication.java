package com.marugi.SpringConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.marugi.SpringConfig.Config.MyConfiguration;

@SpringBootApplication
public class SpringConfigApplication extends SpringBootServletInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyConfiguration.class);

	private static final String SPRING_CONFIG_LOCATION = "spring.config.location";
	private static final String SPRING_CONFIG_NAME = "spring.config.name";
	private static final String JBOSS_SERVER_CONFIG_DIR = "jboss.server.config.dir";
	private static final String RUTA = "W:\\workspace\\Spring\\config\\";
	// El fichero debe de ser tener extension .properties, .yaml o .yml
	private static final String PROPERTIES_FILE = "configFile";

	/**
	 * Metodo main para el arranque de la aplicacion
	 * Para permitir que al ejecutar desde spring-boot se cargue
	 * el fichero de configuracion PROPERTIES_FILE como fichero
	 * principal de configuracion de Spring, la variable de entorno
	 * SPRING_CONFIG_NAME debe de contener el nombre del fichero
	 * sin extension.
	 * Si necesitamos externalizar la configuracion deberemos establecer
	 * la ruta de la carpeta de la configuracion de spring en la variable 
	 * de entorno SPRING_CONFIG_LOCATION
	 */
	public static void main(String[] args) {

		// Obligamos a buscar los ficheros de propiedades en la siguiente ruta
		// Si no se establece obtendra la configuracion de src/main/resources
		// System.setProperty(SPRING_CONFIG_LOCATION, RUTA);

		// Obligamos a que el fihero de propiedades se llame restapi
		// si no se establece se buscara el fichero application.*
		System.setProperty(SPRING_CONFIG_NAME, PROPERTIES_FILE);

		// Bloque para mostrar en el log el fichero cargado
		String ruta = System.getProperty(SPRING_CONFIG_LOCATION);
		if (ruta == null)
			ruta = "src/main/resources/";
		String fichero = System.getProperty(SPRING_CONFIG_NAME);
		if (fichero == null)
			fichero = "application";
		LOGGER.info("Fichero de configuracion de aplicacion: " + ruta + fichero + ".yml");

		// Arranque aplicacion spring
		SpringApplication sa = new SpringApplication(SpringConfigApplication.class);
		sa.run(args);

	}

	/**
	 * Este método solo se ejecuta cuando la aplicacion se ejecuta desde un war
	 * Requiere de una clase DefaultPropeties encargada de establecer el fichero
	 * principal de configuracion de la aplicacion Spring
	 */
	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) {
	 * 
	 * return application.sources(SpringConfigApplication.class) .properties(new
	 * DefaultProperties(PROPERTIES_FILE, JBOSS_SERVER_CONFIG_DIR,
	 * SPRING_CONFIG_LOCATION)); }
	 */

}
