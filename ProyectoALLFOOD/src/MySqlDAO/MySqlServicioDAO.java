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
	public void RegistrarServicio(Servicio registraServicio) {
		try {
			//(nom_servicio,cod_chef,platillos ,descripcion ,precio_persona)
			con=MysqlBDConexion.getConexion();
			call=con.prepareCall("call RegistraServicio(?,?,?,?,?,?)");
			call.setString(1,registraServicio.getNom_servico());
			call.setInt(2,registraServicio.getCod_chef());
			call.setString(3,registraServicio.getPlatillos());
			call.setString(4,registraServicio.getDescripcion());
			call.setDouble(5,registraServicio.getPrecio_persona());
			System.out.println("===> "+call);
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
		
	}

	@Override
	public List<Servicio> listarServicio() {
		List<Servicio> lista = new ArrayList<Servicio>();
		try {
			con=MysqlBDConexion.getConexion();
			call = con.prepareCall("call ListarServicio");
			rs = call.executeQuery();
			while(rs.next()){
				Servicio ser = new Servicio();
				ser.setCod_chef(rs.getInt(1));
				ser.setNom_servico(rs.getString(2));
				ser.setCod_chef(rs.getInt(3));
				ser.setNombre_chef(rs.getString(4));
				ser.setPlatillos(rs.getString(5));
				ser.setDescripcion(rs.getString(6));
				ser.setPrecio_persona(rs.getDouble(7));
				ser.setFec_publicacion(rs.getString(8));
				lista.add(ser);
			}
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
		return lista;
	}

}
