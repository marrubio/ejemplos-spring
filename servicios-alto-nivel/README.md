## Ejemplo uso Spring Web Services



Ejemplo peticion

http://localhost:8080/ws/usuarios

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://san.app/servicios/ws/usuarios">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getUserRequest>
         <gs:name>dev</gs:name>
      </gs:getUserRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

```xml
   <soapenv:Body>
      <gs:obtenerPrincipal><gs:name>admin</gs:name></gs:obtenerPrincipal>
   </soapenv:Body>
```
