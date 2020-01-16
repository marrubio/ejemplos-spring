package app.san.servicios.endpoint;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import app.san.servicios.ws.usuarios.ObtenerPrincipal;
import app.san.servicios.ws.usuarios.GetUserResponse;
import app.san.servicios.ws.usuarios.TipoUsuario;
import app.san.servicios.ws.usuarios.Usuario;

@Endpoint
public class MyEndpoint {
	private static final String NAMESPACE_URI = "http://san.app/servicios/ws/usuarios";
	private static final Logger LOGGER = LoggerFactory.getLogger(MyEndpoint.class);

	private ModelMapper modelMapper;

	@Autowired
	public MyEndpoint(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerPrincipal")
	@ResponsePayload
	public GetUserResponse getMy(@RequestPayload ObtenerPrincipal request) {
		LOGGER.info("getMy()");

		GetUserResponse response = new GetUserResponse();

		Usuario dev = new Usuario();
		dev.setNombre("Premoh");
		dev.setLogin("pre");
		dev.setPassword("pre123");
		dev.setTipo(TipoUsuario.DEV);
		response.setUser(dev);

		// Prueba de copia de objetos con modelMapper
		app.san.servicios.model.Usuario usuario2 = modelMapper.map(dev, app.san.servicios.model.Usuario.class);

		LOGGER.info(usuario2.getNombre());

		return response;
	}
}
