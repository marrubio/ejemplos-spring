package app.san.servicios.repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import app.san.servicios.ws.usuarios.Usuario;
import app.san.servicios.ws.usuarios.TipoUsuario;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UsersRepository {
	private static final Map<String, Usuario> usuarios = new HashMap<>();

	@PostConstruct
	public void initData() {
		Usuario admin = new Usuario();
		admin.setNombre("administrador");
		admin.setLogin("admin");
		admin.setPassword("admin123");
		admin.setTipo(TipoUsuario.ADMIN);

		usuarios.put(admin.getLogin(), admin);

		Usuario dev = new Usuario();
		dev.setNombre("developer");
		dev.setLogin("dev");
		dev.setPassword("dev123");
		dev.setTipo(TipoUsuario.DEV);

		usuarios.put(dev.getLogin(), dev);

		Usuario user = new Usuario();
		user.setNombre("usuario");
		user.setLogin("user");
		user.setPassword("user123");
		user.setTipo(TipoUsuario.USER);

		usuarios.put(user.getLogin(), user);
	}

	public Usuario findUsuario(String name) {
		Assert.notNull(name, "The user name must not be null");
		return usuarios.get(name);
	}
}
