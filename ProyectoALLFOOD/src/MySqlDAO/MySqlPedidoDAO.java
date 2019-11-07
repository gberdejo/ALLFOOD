package MySqlDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import DAO.PedidoDAO;
import Entidades.Pedido;
import utilitarios.MysqlBDConexion;

public class MySqlPedidoDAO implements PedidoDAO{

	
	Connection con = null;
	CallableStatement call = null;
	ResultSet rs = null;
	int salida = -1;
	@Override
	public int RegistrarPedido(Pedido registraPedido) {
		try {
			con=MysqlBDConexion.getConexion();
			call=con.prepareCall("call registrarPedido(?,?,?,?,?,?)");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<Pedido> listarPedido(Pedido listarPedido) {
		// TODO Auto-generated method stub
		return null;
	}

}
