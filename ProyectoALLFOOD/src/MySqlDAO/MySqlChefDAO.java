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

import DAO.ChefDAO;
import Entidades.Chef;
import utilitarios.MysqlBDConexion;

public class MySqlChefDAO implements ChefDAO{

	Connection con = null;
	CallableStatement call = null;
	ResultSet rs = null;
	int salida = -1;
	
	@Override
	public boolean RegistrarChef(Chef registraChef) {
		boolean respuesta = false;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call RegistrarChef(?,?,?,?,?,?,?,?,?)");
			call.setString(1,registraChef.getUsuario());
			call.setString(2,registraChef.getPassword());
			call.setString(3,registraChef.getNom_chef());
			call.setString(4,registraChef.getApe_chef());
			call.setBlob(5, registraChef.getAvatar());
			call.setString(6, registraChef.getPresentacion());
			call.setInt(7,registraChef.getEdad());
			call.setString(8,registraChef.getCelular());
			call.setString(9, registraChef.getDieccion());
			
			call.executeUpdate();
			System.out.println("MySqlChef - RegistrarChef ==> "+call);
			respuesta = true;
		} catch (Exception e) {
			respuesta = false;
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
		return respuesta;
	}
	@Override
	public boolean ActualizarChef(Chef chef) {
		boolean respuesta = false;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call ActualizarChef(?,?,?,?,?,?,?,?)");
			call.setInt(1,chef.getCod_chef());
			call.setString(2, chef.getPassword());
			call.setString(3, chef.getNom_chef());
			call.setString(4, chef.getApe_chef());
			call.setBlob(5, chef.getAvatar());
			call.setString(6, chef.getPresentacion());
			call.setString(7, chef.getCelular());
			call.setString(8, chef.getDieccion());
			call.executeUpdate();
			System.out.println("MySqlChef - ActualizarChef ==> "+call);
			respuesta = true;
		} catch (Exception e) {
			respuesta = false;
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
		return respuesta;
	}
	@Override
	public List<Chef> listarChef() {
		ArrayList<Chef> lista = new ArrayList<Chef>();
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call ListarChef");
			rs = call.executeQuery();
			while(rs.next()){
				Chef objchef = new Chef();
				objchef.setCod_chef(rs.getInt(1));
				objchef.setUsuario(rs.getString(2));
				objchef.setPassword(rs.getString(3));
				objchef.setNom_chef(rs.getString(4));
				objchef.setApe_chef(rs.getString(5));
				objchef.setAvatar(rs.getBinaryStream(6));
				objchef.setPresentacion(rs.getString(7));
				objchef.setEdad(rs.getInt(8));
				objchef.setCelular(rs.getString(9));
				objchef.setDieccion(rs.getString(10));
				objchef.setSaldo_chef(rs.getDouble(11));
				lista.add(objchef);
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
		return lista;
	}

	@Override
	public Chef ValidarChef(String usuario, String password) {
		Chef objchef = null;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call ValidarChef(?,?)");
			call.setString(1, usuario);
			call.setString(2, password);
			rs = call.executeQuery();
			while(rs.next()){
				objchef = new Chef();
				objchef.setCod_chef(rs.getInt(1));
				objchef.setUsuario(rs.getString(2));
				objchef.setPassword(rs.getString(3));
				objchef.setNom_chef(rs.getString(4));
				objchef.setApe_chef(rs.getString(5));
				objchef.setPresentacion(rs.getString(7));
				objchef.setEdad(rs.getInt(8));
				objchef.setCelular(rs.getString(9));
				objchef.setDieccion(rs.getString(10));
			}
			System.out.println("MySqlChef - ValidarChef ==> "+objchef.getCod_chef()+", "+objchef.getUsuario()+", "+objchef.getPassword());
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
		return objchef;
	}

	@Override
	public Chef BuscarChefUsuario(String usuario) {
		Chef objchef = null;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call BuscarChefUsuario(?)");
			call.setString(1, usuario);
			rs = call.executeQuery();
			while(rs.next()){
				objchef = new Chef();
				objchef.setCod_chef(rs.getInt(1));
				objchef.setUsuario(rs.getString(2));
				objchef.setPassword(rs.getString(3));
				objchef.setNom_chef(rs.getString(4));
				objchef.setApe_chef(rs.getString(5));
				objchef.setEdad(rs.getInt(6));
				objchef.setDieccion(rs.getString(7));
				objchef.setCelular(rs.getString(8));
				objchef.setSaldo_chef(rs.getDouble(9));
			}
			System.out.println("MySqlChef - BuscarChefUsuario ==> "+objchef.getCod_chef()+", "+objchef.getUsuario()+", "+objchef.getPassword());

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
		return objchef;
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
			pre = con.prepareStatement("select * from chef where usuario = '"+usuario+"'");
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
