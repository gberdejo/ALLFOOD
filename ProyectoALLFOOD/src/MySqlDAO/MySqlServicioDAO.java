package MySqlDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.ServicioDAO;
import Entidades.Servicio;
import utilitarios.MysqlBDConexion;

public class MySqlServicioDAO implements ServicioDAO {

	
	Connection con = null;
	CallableStatement call = null;
	ResultSet rs = null;
	int salida = -1;
	@Override
	public int RegistrarServicio(Servicio registraServicio) {
		try {
			con=MysqlBDConexion.getConexion();
			call=con.prepareCall("call RegistraServicio(?,?,?,?,?,?)");
			call.setString(1,registraServicio.getNom_servico());
			call.setInt(2,registraServicio.getCod_chef());
			call.setInt(3,registraServicio.getCod_comida());
			call.setString(4,registraServicio.getDescripcion());
			call.setDouble(5,registraServicio.getPrecio_persona());
			call.setString(6,registraServicio.getFec_publicacion());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con !=null)con.close();
				if(call !=null)call.close();
				if(rs !=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Servicio> listarServicio(Servicio listarServicio) {
		ArrayList<Servicio>lista=new ArrayList<Servicio>();
		try {
			con=MysqlBDConexion.getConexion();
			call=con.prepareCall("call ListarServicio");
			rs=call.executeQuery();
			
		while(rs.next()){
			Servicio ser=new Servicio();
			
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
