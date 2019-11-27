package MySqlDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("====>"+call);
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
				Chef ch = new Chef();
				ch.setCod_chef(rs.getInt(1));
				ch.setUsuario(rs.getString(2));
				ch.setPassword(rs.getString(3));
				ch.setNom_chef(rs.getString(4));
				ch.setApe_chef(rs.getString(5));
				ch.setEdad(rs.getInt(6));
				ch.setCelular(rs.getString(7));
				ch.setDieccion(rs.getString(8));
				ch.setSaldo_chef(rs.getDouble(9));
				lista.add(ch);
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
			call = con.prepareCall("call ValidarChef (?,?)");
			call.setString(1, usuario);
			call.setString(2, password);
			rs = call.executeQuery();
			while(rs.next()){
				objchef = new Chef();
				objchef.setCod_chef(rs.getInt("cod_chef"));
				objchef.setUsuario(rs.getString("usuario"));
				objchef.setPassword(rs.getString("contra"));
			}
			System.out.println("MySqlChef: "+objchef.getCod_chef()+", "+objchef.getUsuario()+", "+objchef.getPassword());
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
		Chef chef = null;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call BuscarChefUsuario(?)");
			call.setString(1, usuario);
			rs = call.executeQuery();
			while(rs.next()){
				chef = new Chef();
				chef.setCod_chef(rs.getInt(1));
				chef.setUsuario(rs.getString(2));
				chef.setPassword(rs.getString(3));
				chef.setNom_chef(rs.getString(4));
				chef.setApe_chef(rs.getString(5));
				chef.setEdad(rs.getInt(6));
				chef.setDieccion(rs.getString(7));
				chef.setCelular(rs.getString(8));
				chef.setSaldo_chef(rs.getDouble(9));
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
		return chef;
	}

	

}
