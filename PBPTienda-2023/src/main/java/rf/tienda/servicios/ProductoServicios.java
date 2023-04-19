package rf.tienda.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rf.tienda.dominio.Categoria;
import rf.tienda.dominio.Producto;
import rf.tienda.exception.DomainException;
import rf.tienda.repository.ProductoRepository;

@Service
public class ProductoServicios implements IProductoServicios{
	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public List<Producto> leerProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto crearProducto(Producto producto) {
		return productoRepository.save(producto); 
	}

	@Override
	public ResponseEntity actualizarProducto(Producto productoNuevo, String id) throws DomainException {
		Optional<Producto> producto = productoRepository.findById(id);
		if(!producto.isPresent()) {
			return new ResponseEntity("No existe el producto con ese id", HttpStatus.NOT_FOUND) ;
		}
		producto.get().setId_categoria(productoNuevo.getId_categoria());
		producto.get().setId_producto(productoNuevo.getId_producto());
		producto.get().setPro_descripcion(productoNuevo.getPro_descripcion());
		producto.get().setPro_desLarga(productoNuevo.getPro_desLarga());
		producto.get().setPro_stock(productoNuevo.getPro_stock());
		producto.get().setPro_fecRepos(productoNuevo.getPro_fecRepos());
		producto.get().setPro_fecActi(productoNuevo.getPro_fecActi());
		producto.get().setPro_fecDesacti(productoNuevo.getPro_fecDesacti());
		producto.get().setPro_uniVenta(productoNuevo.getPro_uniVenta());
		producto.get().setPro_cantXUniVenta(productoNuevo.getPro_cantXUniVenta());
		producto.get().setPro_uniUltNivel(productoNuevo.getPro_uniUltNivel());
		producto.get().setId_pais(productoNuevo.getId_pais());
		producto.get().setPro_usoRecomendado(productoNuevo.getPro_usoRecomendado());
		producto.get().setPro_stkReservado(productoNuevo.getPro_stkReservado());
		producto.get().setPro_nStkAlto(productoNuevo.getPro_nStkAlto());
		producto.get().setPro_nStkBajo(productoNuevo.getPro_nStkBajo());
		producto.get().setPro_stat(productoNuevo.getPro_stat());
		
		productoRepository.save(producto.get());
		return new ResponseEntity("Se ha actualizado", HttpStatus.OK);
	}

	@Override
	public ResponseEntity eliminarProducto(String id) {
		Optional<Producto> producto = productoRepository.findById(id);
		if(!producto.isPresent()) {
			return new ResponseEntity("No existe el producto con ese id", HttpStatus.NOT_FOUND) ;
		}
	
		productoRepository.deleteById(id);
		return new ResponseEntity("Se ha borrado", HttpStatus.OK);
	}
	
	
}
