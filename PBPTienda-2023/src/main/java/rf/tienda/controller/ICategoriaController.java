package rf.tienda.controller;

import java.util.List;

import rf.tienda.dominio.Categoria;

public interface ICategoriaController {
	List<Categoria>leerCetegorias();
	Categoria crear();
}
