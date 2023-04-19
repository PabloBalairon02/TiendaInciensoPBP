package rf.tienda.servicios;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rf.tienda.dominio.PedidoCarrito;
import rf.tienda.exception.DomainException;

public interface IPedidoCarritoServicios {
	public abstract List<PedidoCarrito> leerPedidoCarritos();
	public abstract PedidoCarrito crearCarrito(PedidoCarrito pedidoCarrito);
	public abstract ResponseEntity actualizarCarrito(PedidoCarrito pedidoCarritoNuevo, Integer id) throws DomainException;
	public abstract ResponseEntity eliminarCarrito(Integer id);
}
