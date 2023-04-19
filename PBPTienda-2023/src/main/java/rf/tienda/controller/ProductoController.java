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

import rf.tienda.dominio.Producto;
import rf.tienda.exception.DomainException;
import rf.tienda.servicios.IProductoServicios;

@Controller
@RequestMapping(path="/producto")
public class ProductoController {
	@Autowired
	private IProductoServicios iProductoServicios;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewCategoria(@RequestBody Producto producto) {
		iProductoServicios.crearProducto(producto); 
		return "Saved";
	}
	
	@GetMapping(path="/all") 
	public @ResponseBody Iterable<Producto> getAllCategorias(){
		return iProductoServicios.leerProductos();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable String id) {
		return iProductoServicios.eliminarProducto(id);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> updateCategoria(@RequestBody Producto updatedProducto, @PathVariable String id) throws DomainException {
		return iProductoServicios.actualizarProducto(updatedProducto, id);
	}
}
