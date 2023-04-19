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

import rf.tienda.dominio.PedidoCarrito;
import rf.tienda.exception.DomainException;
import rf.tienda.servicios.IPedidoCarritoServicios;

@Controller
@RequestMapping(path="/carrito")
public class PedidoCarritoController {

	@Autowired
	private IPedidoCarritoServicios iPedidoCarritoServicios;
		
	@PostMapping(path="/add")
	public @ResponseBody String addNewUsuario(@RequestBody PedidoCarrito carrito) {
		iPedidoCarritoServicios.crearCarrito(carrito); 
		return "Saved";
	}
		
	@GetMapping(path="/all") 
	public @ResponseBody Iterable<PedidoCarrito> getAllUsuarios(){
		return iPedidoCarritoServicios.leerPedidoCarritos();
	}
		
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
		return iPedidoCarritoServicios.eliminarCarrito(id);
	}
		
	@PutMapping(path="/{id}")
	public ResponseEntity<?> updateUsuario(@RequestBody PedidoCarrito updatedCarrito, @PathVariable int id) throws DomainException {
		return iPedidoCarritoServicios.actualizarCarrito(updatedCarrito, id);
	}
}
