package rf.tienda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import rf.tienda.dominio.Categoria;
import rf.tienda.exception.DomainException;
import rf.tienda.repository.CategoriaRepository;
import rf.tienda.servicios.ICategoriaServicios;

@Controller
@RequestMapping(path="/categoria")
public class CategoriaController {
	@Autowired
	private ICategoriaServicios iCategoriaServicios;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewCategoria(@RequestBody Categoria categoria) {
		iCategoriaServicios.crearCategoria(categoria); 
		return "Saved";
	}
	
	@GetMapping(path="/all") 
	public @ResponseBody Iterable<Categoria> getAllCategorias(){
		return iCategoriaServicios.leerCategorias();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable Integer id) {
		return iCategoriaServicios.eliminarCategoria(id);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> updateCategoria(@RequestBody Categoria updatedCategoria, @PathVariable Integer id) throws DomainException {
		return iCategoriaServicios.actualizarCategoria(updatedCategoria, id);
	}
	
}
