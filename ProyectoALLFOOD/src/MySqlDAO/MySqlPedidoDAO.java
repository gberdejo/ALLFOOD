package MySqlDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.PedidoDAO;
import Entidades.Pedido;
import utilitarios.MysqlBDConexion;
import Entidades.Cliente;
import MySqlDAO.MySqlClienteDAO;

public class MySqlPedidoDAO implements PedidoDAO{

	
	Connection con = null;
	CallableStatement call = null;
	ResultSet rs = null;
	int salida = -1;
	@Override
	public int RegistrarPedido(Pedido registraPedido) {
		try {
			con=MysqlBDConexion.getConexion();
			call=con.prepareCall("call registrarPedido(?,?,?,?,?,?,?)");
			call.setString(1,registraPedido.getNom_cli());
			call.setString(2,registraPedido.getNom_chef());
			call.setString(3,registraPedido.getNom_servicio());
			call.setInt(4,registraPedido.getCant_personas());
			call.setString(5,registraPedido.getFec_entrega());
			call.setDouble(6,registraPedido.getPago_total());
			call.setInt(7,registraPedido.getValoracion());
			call.executeUpdate();
			System.out.print(call);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(con!=null)con.close();
				if(call!=null)call.close();
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Pedido> listarPedido(Pedido listarPedido) {
		ArrayList<Pedido> lista=new ArrayList<Pedido>();
		try {
			con=MysqlBDConexion.getConexion();
			call=con.prepareCall("call ListarPedido");
			rs=call.executeQuery();
			while(rs.next()){
				Pedido pe=new Pedido();
				pe.setCod_pedido(rs.getInt(1));
				pe.setNom_cli(rs.getString(2));
				pe.setNom_chef(rs.getString(3));
				pe.setNom_servicio(rs.getString(4));
				pe.setCant_personas(rs.getInt(5));
				pe.setFec_compra(rs.getString(6));
				pe.setFec_entrega(rs.getString(7));
				pe.setValoracion(rs.getInt(8));
				lista.add(pe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(con!=null)con.close();
				if(call!=null)call.close();
				if(rs!=null)rs.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

}
