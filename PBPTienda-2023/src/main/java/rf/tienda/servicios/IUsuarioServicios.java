package rf.tienda.servicios;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rf.tienda.dominio.Usuario;
import rf.tienda.exception.DomainException;

public interface IUsuarioServicios {
	public abstract List<Usuario> leerUsuarios();
	public abstract Usuario crearUsuario(Usuario usuario);
	public abstract ResponseEntity actualizarUsuario(Usuario usuarioNuevo, Integer id) throws DomainException;
	public abstract ResponseEntity eliminarUsuario(Integer id);
}
