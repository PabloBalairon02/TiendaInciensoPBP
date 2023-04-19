package rf.tienda.controller;

import java.util.List;

import rf.tienda.dominio.Producto;

public interface IProductoController {
	List<Producto>leerProductos();
	Producto crear();
}
