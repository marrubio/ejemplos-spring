package app.san.servicios.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import app.san.servicios.ws.usuarios.GetUserRequest;
import app.san.servicios.ws.usuarios.GetUserResponse;
import app.san.servicios.repository.UsersRepository;

@Endpoint
public class UserEndpoint {
	private static final String NAMESPACE_URI = "http://san.app/servicios/ws/usuarios";

	private UsersRepository usersRepository;

	@Autowired
	public UserEndpoint(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getCountry(@RequestPayload GetUserRequest request) {
		GetUserResponse response = new GetUserResponse();
		response.setUser(usersRepository.findUsuario(request.getName()));

		return response;
	}
}
