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
	public boolean RegistrarPedido(Pedido registraPedido) {
		boolean respuesta = false;
		try {
			con=MysqlBDConexion.getConexion();
			call=con.prepareCall("call registrarPedido(?,?,?,?,?,?)");
			call.setInt(1, registraPedido.getCodigo_cliente());
			call.setInt(2, registraPedido.getCodigo_servicio());
			call.setInt(3, registraPedido.getCantidad_personas());
			call.setString(4, registraPedido.getFecha_entrega());
			call.setDouble(5, registraPedido.getPago_total());
			call.setString(6, registraPedido.getDireccion_entrega());
			call.executeUpdate();
			respuesta = true;
			System.out.print("MySqlPedido - RegistrarPedido ==> "+call);
		} catch (Exception e) {
			respuesta = false;
			e.printStackTrace();
			System.out.println("Fallo en la sentencia");
		}finally{
			try {
				if(con!=null)con.close();
				if(call!=null)call.close();
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return respuesta;
	}
	@Override
	public List<Pedido> ListarPedido() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Pedido> ListarPedidoCliente(String codigoCliente) {
		List<Pedido> lista = new ArrayList<Pedido>();
		Pedido pedido=null;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call ListarPedidoCliente(?)");
			call.setString(1, codigoCliente);
			rs = call.executeQuery();
			while(rs.next()){
				pedido = new Pedido();
				pedido.setCodigo_pedido(rs.getInt(1));
				pedido.setCodigo_cliente(rs.getInt(2));
				pedido.setNombre_cliente(rs.getString(3));
				pedido.setApellido_cliente(rs.getString(4));
				pedido.setCodigo_servicio(rs.getInt(5));
				pedido.setNombre_servicio(rs.getString(6));
				pedido.setPrecio_persona(rs.getDouble(7));
				pedido.setCodigo_chef(rs.getInt(8));
				pedido.setUsuario_chef(rs.getString(9));
				pedido.setNombre_chef(rs.getString(10));
				pedido.setApellido_chef(rs.getString(11));
				pedido.setCantidad_personas(rs.getInt(12));
				pedido.setFecha_compra(rs.getString(13));
				pedido.setFecha_entrega(rs.getString(14));
				pedido.setDireccion_entrega(rs.getString(15));
				pedido.setPago_total(rs.getDouble(16));
				lista.add(pedido);
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
	@Override
	public List<Pedido> ListarPedidoChef(String codigoChef) {
		List<Pedido> lista = new ArrayList<Pedido>();
		Pedido pedido=null;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call ListarPedidoChef(?)");
			call.setString(1, codigoChef);
			rs = call.executeQuery();
			while(rs.next()){
				pedido = new Pedido();
				pedido.setCodigo_pedido(rs.getInt(1));
				pedido.setCodigo_cliente(rs.getInt(2));
				pedido.setNombre_cliente(rs.getString(3));
				pedido.setApellido_cliente(rs.getString(4));
				pedido.setCodigo_servicio(rs.getInt(5));
				pedido.setNombre_servicio(rs.getString(6));
				pedido.setPrecio_persona(rs.getDouble(7));
				pedido.setCodigo_chef(rs.getInt(8));
				pedido.setUsuario_chef(rs.getString(9));
				pedido.setNombre_chef(rs.getString(10));
				pedido.setApellido_chef(rs.getString(11));
				pedido.setCantidad_personas(rs.getInt(12));
				pedido.setFecha_compra(rs.getString(13));
				pedido.setFecha_entrega(rs.getString(14));
				pedido.setDireccion_entrega(rs.getString(15));
				pedido.setPago_total(rs.getDouble(16));
				lista.add(pedido);
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

	
	/*public List<Pedido> listarPedido(Pedido listarPedido) {
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
	}*/

}
