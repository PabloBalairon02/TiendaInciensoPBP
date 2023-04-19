package rf.tienda.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rf.tienda.dominio.Producto;
import rf.tienda.dominio.Usuario;
import rf.tienda.exception.DomainException;
import rf.tienda.repository.UsuarioRepository;

public class UsuarioServicios implements IUsuarioServicios{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> leerUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario); 
	}

	@Override
	public ResponseEntity actualizarUsuario(Usuario usuarioNuevo, Integer id) throws DomainException {
		Optional<Usuario> user = usuarioRepository.findById(id);
		if(!user.isPresent()) {
			return new ResponseEntity("No existe el usuario con ese id", HttpStatus.NOT_FOUND) ;
		}
		user.get().setId(usuarioNuevo.getId());
		user.get().setNombre(usuarioNuevo.getNombre());
		user.get().setCorreoElectronico(usuarioNuevo.getCorreoElectronico());
		user.get().setContrasena(usuarioNuevo.getContrasena());
		user.get().setTipoUsuario(usuarioNuevo.getTipoUsuario());
		user.get().setNumDNI(usuarioNuevo.getNumDNI());
		user.get().setFechaAlta(usuarioNuevo.getFechaAlta());
		user.get().setFechaConfirmacion(usuarioNuevo.getFechaConfirmacion());
		
		usuarioRepository.save(user.get());
		return new ResponseEntity("Se ha actualizado", HttpStatus.OK);
	}

	@Override
	public ResponseEntity eliminarUsuario(Integer id) {
		Optional<Usuario> user = usuarioRepository.findById(id);
		if(!user.isPresent()) {
			return new ResponseEntity("No existe el producto con ese id", HttpStatus.NOT_FOUND) ;
		}
	
		usuarioRepository.deleteById(id);
		return new ResponseEntity("Se ha borrado", HttpStatus.OK);
	}

}
