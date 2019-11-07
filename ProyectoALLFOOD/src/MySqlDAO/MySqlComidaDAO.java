package MySqlDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import DAO.ComidaDAO;
import Entidades.Comida;
import utilitarios.MysqlBDConexion;

public class MySqlComidaDAO implements ComidaDAO{

	Connection con = null;
	CallableStatement call = null;
	ResultSet rs = null;
	int salida = -1;
	
	@Override
	public int RegistrarComida(Comida registraComida) {
		try {
			con=MysqlBDConexion.getConexion();
			call=con.prepareCall("call RegistrarComida(?)");
			call.setString(1,registraComida.getNom_comida());
			
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
			// TODO: handle exception
		
		return 0;
	}

	@Override
	public List<Comida> listarChef(Comida listarComida) {
		// TODO Auto-generated method stub
		return null;
	}

}
