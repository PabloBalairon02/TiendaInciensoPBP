package rf.tienda.controller;

import java.util.List;

import rf.tienda.dominio.PedidoCarrito;

public interface IPedidoCarritoController {
	List<PedidoCarrito>leerCarrito();
	PedidoCarrito crear();
}
