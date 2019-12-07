package DAO;

import java.util.List;

import Entidades.Pedido;

public interface PedidoDAO {
	
	public abstract boolean RegistrarPedido(Pedido registraPedido);
	public abstract List<Pedido> ListarPedido();
	public abstract List<Pedido> ListarPedidoCliente(String codigoCliente);
	public abstract List<Pedido> ListarPedidoChef(String codigoChef);
}
