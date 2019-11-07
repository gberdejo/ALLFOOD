package MySqlDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import DAO.ClienteDAO;
import Entidades.Cliente;
import utilitarios.MysqlBDConexion;

public class MySqlClienteDAO implements ClienteDAO{
	Connection con = null;
	CallableStatement call = null;
	ResultSet rs = null;
	int salida = -1;
	
	@Override
	public int RegistrarCliente(Cliente registraCli) {
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call RegistrarCliente(?,?,?,?,?,?,?)");
			call.setString(1, registraCli.getUsuario());
			call.setString(2, registraCli.getPassword());
			call.setString(3,registraCli.getNom_cli());
			call.setString(4,registraCli.getApe_cli());
			call.setInt(5, registraCli.getEdad());
			call.setString(6,registraCli.getCelular_cli());
			call.setDouble(7, registraCli.getSaldo_cli());
			salida=call.executeUpdate();
		} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(con != null) con.close();
					if(call != null) call.close();
					if(rs != null) rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			
			// TODO: handle exception
		}
			
		
	
		return 0;
	}

	@Override
	public List<Cliente> listarChef(Cliente listarCli) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente ValidarCliente(String usuario, String password) {
		Cliente cliente = null;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call ValidarCliente(?,?)");
			call.setString(1, usuario);
			call.setString(2, password);
			rs = call.executeQuery();
			while(rs.next()){
				cliente = new Cliente();
				cliente.setCod_cli(rs.getInt(1));
				cliente.setUsuario(rs.getString(2));
				cliente.setPassword(rs.getString(3));
				cliente.setNom_cli(rs.getString(4));
				cliente.setApe_cli(rs.getString(5));
				cliente.setEdad(rs.getInt(6));
				cliente.setCelular_cli(rs.getString(7));
				cliente.setSaldo_cli(rs.getDouble(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(call != null) call.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cliente;
	}

}
