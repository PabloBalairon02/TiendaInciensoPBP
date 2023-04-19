package rf.tienda.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rf.tienda.dominio.PedidoCarrito;
import rf.tienda.exception.DomainException;
import rf.tienda.repository.PedidoCarritoRepository;

public class PedidoCarritoServicios implements IPedidoCarritoServicios{
	@Autowired
	PedidoCarritoRepository pedidoCarritoRepository;
	
	@Override 
	public List<PedidoCarrito> leerPedidoCarritos() {
		return pedidoCarritoRepository.findAll();

	}

	@Override
	public PedidoCarrito crearCarrito(PedidoCarrito pedidoCarrito) {
		return pedidoCarritoRepository.save(pedidoCarrito);
	}

	@Override
	public ResponseEntity actualizarCarrito(PedidoCarrito pedidoCarritoNuevo, Integer id) throws DomainException {
		Optional<PedidoCarrito> pedidoCarrito = pedidoCarritoRepository.findById(id);
		if(!pedidoCarrito.isPresent()) {
			return new ResponseEntity("No existe el usuario con ese id", HttpStatus.NOT_FOUND) ;
		}
		pedidoCarrito.get().setId_usuario(pedidoCarritoNuevo.getId_usuario());
		pedidoCarrito.get().setId_producto(pedidoCarritoNuevo.getId_producto());
		pedidoCarrito.get().setCar_cantidad(pedidoCarritoNuevo.getCar_cantidad());
		pedidoCarrito.get().setCar_precio(pedidoCarritoNuevo.getCar_precio());
		pedidoCarrito.get().setCar_envio(pedidoCarritoNuevo.getCar_envio());
		pedidoCarrito.get().setCar_pago(pedidoCarritoNuevo.getCar_pago());
		pedidoCarrito.get().setCar_tarjeta(pedidoCarritoNuevo.getCar_tarjeta());
		pedidoCarrito.get().setCar_feCadud(pedidoCarritoNuevo.getCar_feCadud());
		pedidoCarrito.get().setCar_ccv(pedidoCarritoNuevo.getCar_ccv());
		pedidoCarrito.get().setCar_nombre(pedidoCarritoNuevo.getCar_nombre());
		pedidoCarrito.get().setCar_stat(pedidoCarritoNuevo.getCar_stat());
		pedidoCarrito.get().setCar_feCambio(pedidoCarritoNuevo.getCar_feCambio());
		
		pedidoCarritoRepository.save(pedidoCarrito.get());
		return new ResponseEntity("Se ha actualizado", HttpStatus.OK);
	}

	@Override
	public ResponseEntity eliminarCarrito(Integer id) {
		Optional<PedidoCarrito> carrito = pedidoCarritoRepository.findById(id);
		if(!carrito.isPresent()) {
			return new ResponseEntity("No existe el producto con ese id", HttpStatus.NOT_FOUND) ;
		}
	
		pedidoCarritoRepository.deleteById(id);
		return new ResponseEntity("Se ha borrado", HttpStatus.OK);
	}

}
