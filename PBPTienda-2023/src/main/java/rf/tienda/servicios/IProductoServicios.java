package rf.tienda.servicios;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rf.tienda.dominio.Producto;
import rf.tienda.exception.DomainException;

public interface IProductoServicios {
	public abstract List<Producto> leerProductos();
	public abstract Producto crearProducto(Producto producto);
	public abstract ResponseEntity actualizarProducto(Producto productoNuevo, String id) throws DomainException;
	public abstract ResponseEntity eliminarProducto(String id);
}
