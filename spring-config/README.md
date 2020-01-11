## spring-boot-config

Pruebas para cargar con spring-boot mapas (arrays de valor-objeto) desde un fichero de propiedades de tipo yaml

Se detectan problemas si el fichero de configuracion tipo yaml esta cargado con el tag @PropertySource ya que fallan el mapeo del yml a los mapas de objetos de java.
Este problema no se da si los mapas de objetos estan definidos en el fichero principal de la configuracion de la aplicacion Spring (application.yml) y esta se carga por defecto en vez de mediante el tag @PropertySource.

Utilizamos un fichero distinto al application.yml o diferente al applicacion.properties cambiando el nombre mediante la variable de entorno spring.config.name que estableceremos con el nombre del nuevo fichero sin la extensión, en este caso "configFile".
De esta manera , en el arranque del contexto de Spring, utilizará el fichero configFile.yml de src/main/resources en vez del applicacion.yml.
