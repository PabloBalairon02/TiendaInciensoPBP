package rf.tienda.controller;

import java.util.List;

import rf.tienda.dominio.Usuario;

public interface IUsuarioController {
	List<Usuario>leerUsuarios();
	Usuario crear();
}
