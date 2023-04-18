package rf.tienda.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rf.tienda.dominio.Categoria;
import rf.tienda.exception.DomainException;
import rf.tienda.repository.CategoriaRepository;

@Service
public class CategoriaServicios implements ICategoriaServicios{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> leerCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria); 
	}

	@Override
	public ResponseEntity actualizarCategoria(Categoria categoriaNueva, Integer id) throws DomainException {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(!categoria.isPresent()) {
			return new ResponseEntity("No existe el juego con ese id", HttpStatus.NOT_FOUND) ;
		}
		categoria.get().setCat_nombre(categoriaNueva.getCat_nombre());
		categoria.get().setCat_descripcion(categoriaNueva.getCat_descripcion());
		categoria.get().setId_categoria(categoriaNueva.getId_categoria());
		
		categoriaRepository.save(categoria.get());
		return new ResponseEntity("Se ha actualizado", HttpStatus.OK);
	}

	@Override
	public ResponseEntity eliminarCategoria(Integer id) {
		Optional<Categoria> videojuego = categoriaRepository.findById(id);
		if(!videojuego.isPresent()) {
			return new ResponseEntity("No existe la categoria con ese id", HttpStatus.NOT_FOUND) ;
		}
	
		categoriaRepository.deleteById(id);
		return new ResponseEntity("Se ha borrado", HttpStatus.OK);
	}

}
