package MySqlDAO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import Entidades.Cliente;
import utilitarios.MysqlBDConexion;

public class MySqlClienteDAO implements ClienteDAO{
	Connection con = null;
	CallableStatement call = null;
	ResultSet rs = null;
	
	
	@Override
	public boolean RegistrarCliente(Cliente registraCli) {
		boolean respuesta = false;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call RegistrarCliente(?,?,?,?,?,?,?,?)");
			call.setString(1, registraCli.getUsuario());
			call.setString(2, registraCli.getPassword());
			call.setString(3,registraCli.getNom_cli());
			call.setString(4,registraCli.getApe_cli());
			call.setBlob(5, registraCli.getAvatar());
			call.setInt(6, registraCli.getEdad());
			call.setString(7,registraCli.getCelular_cli());
			call.setDouble(8, registraCli.getSaldo_cli());
			call.executeUpdate();
			System.out.println("MySqlCliente - RegistrarCliente ==> "+call);
			respuesta = true;
		} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Fallo de sentencia Registrar");
				respuesta = false;
			}finally {
				try {
					if(con != null) con.close();
					if(call != null) call.close();
					if(rs != null) rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			
			
		}
		return respuesta;
	}

	@Override
	public List<Cliente> listarCliente() {
		List<Cliente> lista = new ArrayList<Cliente>();
		Cliente listarcli=null;
		try {
			con=MysqlBDConexion.getConexion();
			call= con.prepareCall("call ListarCliente");
			rs=call.executeQuery();
			while(rs.next()){
				listarcli=new Cliente();
				listarcli.setCod_cli(rs.getInt(1));
				listarcli.setUsuario(rs.getString(2));
				listarcli.setPassword(rs.getString(3));
				listarcli.setNom_cli(rs.getString(4));
				listarcli.setApe_cli(rs.getString(5));
				listarcli.setEdad(rs.getInt(6));
				listarcli.setCelular_cli(rs.getString(7));
				listarcli.setSaldo_cli(rs.getDouble(8));
				lista.add(listarcli);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(con !=null)con.close();
				if(call !=null)call.close();
				if(rs !=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
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
	@Override
	public Cliente BuscarClienteUsuario(String usuario){
		Cliente objCliente = null;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call BuscarClienteUsuario(?)");
			call.setString(1, usuario);
			rs = call.executeQuery();
			while(rs.next()){
				objCliente = new Cliente();
				objCliente.setCod_cli(rs.getInt("cod_cli"));
				objCliente.setUsuario(rs.getString("usuario"));
				objCliente.setPassword(rs.getString("contra"));
				objCliente.setNom_cli(rs.getString("nom_cli"));
				objCliente.setApe_cli(rs.getString("ape_cli"));
				objCliente.setEdad(rs.getInt("edad_cli"));
				objCliente.setCelular_cli(rs.getString("celular_cli"));
				objCliente.setSaldo_cli(rs.getDouble("saldo_cli"));
			}
			System.out.println("MySqlCliente - BuscarClienteUsuario ==> "+objCliente.getUsuario());
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
		return objCliente;
	}

	@Override
	public void ListarImagen(String usuario, HttpServletResponse response) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		PreparedStatement pre = null;
		response.setContentType("image/*");
		try {
			outputStream = response.getOutputStream();
			con= MysqlBDConexion.getConexion();
			pre = con.prepareStatement("select * from cliente where usuario = '"+usuario+"'");
			rs = pre.executeQuery();
			
			if(rs.next()) {
				inputStream= rs.getBinaryStream(6);
			}
			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			int i = 0;
			while((i=bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write(i);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}

}
