package DAO;

import java.util.List;

import Entidades.Pedido;

public interface PedidoDAO {
	
	public abstract int RegistrarPedido(Pedido registraPedido);
	public abstract List<Pedido>listarPedido(Pedido listarPedido);
}
