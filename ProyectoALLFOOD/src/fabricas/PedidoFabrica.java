package fabricas;

import DAO.PedidoDAO;

public abstract class PedidoFabrica {
	public static final int MYSQL = 0;
	public abstract PedidoDAO getPedidoDAO();
	
	public static PedidoFabrica tipoConexion(int tipo){
		PedidoFabrica pedFa = null;
		switch(tipo){
		case MYSQL: pedFa = new SubFabricaPedido();
		}
		return pedFa;
	}
}
