package rf.tienda.servicios;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rf.tienda.dominio.Categoria;
import rf.tienda.exception.DomainException;

public interface ICategoriaServicios {
	public abstract List<Categoria> leerCategorias();
	public abstract Categoria crearCategoria(Categoria categoria);
	public abstract ResponseEntity actualizarCategoria(Categoria categoriaNueva, Integer id) throws DomainException;
	public abstract ResponseEntity eliminarCategoria(Integer id);
}
