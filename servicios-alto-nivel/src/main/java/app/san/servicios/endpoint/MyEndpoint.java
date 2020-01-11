package app.san.servicios.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MyEndpoint {
	private static final String NAMESPACE_URI = "http://san.app/servicios/ws/my";
	

	@Autowired
	public MyEndpoint() {		
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMy")
	@ResponsePayload
	public String getMy(@RequestPayload String request) {
		String response = "Hola " + request + " !!";		
		return response;
	}
}
