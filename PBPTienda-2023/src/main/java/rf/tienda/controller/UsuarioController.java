package rf.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import rf.tienda.dominio.Usuario;
import rf.tienda.exception.DomainException;
import rf.tienda.servicios.IUsuarioServicios;

@Controller
@RequestMapping(path="/usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioServicios iUsuarioServicios;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUsuario(@RequestBody Usuario usuario) {
		iUsuarioServicios.crearUsuario(usuario); 
		return "Saved";
	}
	
	@GetMapping(path="/all") 
	public @ResponseBody Iterable<Usuario> getAllUsuarios(){
		return iUsuarioServicios.leerUsuarios();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
		return iUsuarioServicios.eliminarUsuario(id);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario updatedUsuario, @PathVariable int id) throws DomainException {
		return iUsuarioServicios.actualizarUsuario(updatedUsuario, id);
	}
}
