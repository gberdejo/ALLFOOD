package fabricas;

import DAO.PedidoDAO;
import MySqlDAO.MySqlPedidoDAO;

public class SubFabricaPedido extends PedidoFabrica {

	@Override
	public PedidoDAO getPedidoDAO() {
		return new MySqlPedidoDAO();
	}

}
