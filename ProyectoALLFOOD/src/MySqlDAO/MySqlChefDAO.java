package MySqlDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
	public void RegistrarChef(Chef registraChef) {

		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call RegistrarCliente(?,?,?,?,?,?,?)");
			call.setString(1,registraChef.getUsuario());
			call.setString(2,registraChef.getPassword());
			call.setString(3,registraChef.getNom_chef());
			call.setString(4,registraChef.getApe_chef());
			call.setInt(5,registraChef.getEdad());
			call.setString(6,registraChef.getCelular());
			call.setString(7, registraChef.getDieccion());
			call.executeUpdate();
			System.out.println(call);
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
	}

	@Override
	public List<Chef> listarChef(Chef listarChef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chef ValidarChef(String usuario, String password) {
		Chef chef = null;
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call ValidarChef(?,?)");
			call.setString(1, usuario);
			call.setString(2, password);
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
