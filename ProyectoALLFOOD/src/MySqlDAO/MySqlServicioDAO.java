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

import DAO.ServicioDAO;
import Entidades.Servicio;
import utilitarios.MysqlBDConexion;

public class MySqlServicioDAO implements ServicioDAO {

	
	Connection con = null;
	CallableStatement call = null;
	ResultSet rs = null;
	int salida = -1;
	
	@Override
	public boolean RegistrarServicio(Servicio registraServicio) {
		boolean respuesta = false;
		try {
			con=MysqlBDConexion.getConexion();
			call=con.prepareCall("call RegistrarServicio(?,?,?,?,?,?)");
			call.setString(1,registraServicio.getNom_servicio());
			call.setInt(2,registraServicio.getCod_chef());
			call.setString(3,registraServicio.getPlatillos());
			call.setString(4,registraServicio.getDescripcion());
			call.setBlob(5, registraServicio.getLogo());
			call.setDouble(6,registraServicio.getPrecio_persona());
			call.executeUpdate();
			System.out.println("MySqlServicio - RegistrarServicio ==> "+call);
			respuesta= true;
		} catch (Exception e) {
			e.printStackTrace();
			respuesta= false;
		}finally {
			try {
				if(con !=null)con.close();
				if(call !=null)call.close();
				if(rs !=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return respuesta;
	}
	@Override
	public boolean ActualizarServicio(Servicio servicio) {
		boolean respuesta = false;
		try {
			con=MysqlBDConexion.getConexion();
			call=con.prepareCall("call ActualizarServicio(?,?,?,?,?,?)");
			call.setInt(1, servicio.getCod_servicio());
			call.setString(2, servicio.getNom_servicio());
			call.setString(3, servicio.getPlatillos());
			call.setString(4, servicio.getDescripcion());
			call.setBlob(5, servicio.getLogo());
			call.setDouble(6, servicio.getPrecio_persona());
			call.executeUpdate();
			System.out.println("MySqlServicio - ActualizarServicio ==> "+call);
			respuesta= true;
		} catch (Exception e) {
			e.printStackTrace();
			respuesta= false;
		}finally {
			try {
				if(con !=null)con.close();
				if(call !=null)call.close();
				if(rs !=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return respuesta;
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
				ser.setNom_servicio(rs.getString(2));
				ser.setCod_chef(rs.getInt(3));
				ser.setNombre_chef(rs.getString(4));
				ser.setPlatillos(rs.getString(5));
				ser.setDescripcion(rs.getString(6));
				ser.setPrecio_persona(rs.getDouble(7));
				ser.setFec_publicacion(rs.getString(8));
				lista.add(ser);
				System.out.println("MySqlServicio - listarServicio ==> "+ser.getCod_servicio()+" - "+ser.getNom_servicio());
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

	@Override
	public List<Servicio> ListarServicioChef(String usuarioChef) {
		List<Servicio> lista = new ArrayList<Servicio>();
		try {
			con=MysqlBDConexion.getConexion();
			call = con.prepareCall("call ListarServicioChef(?)");
			call.setString(1, usuarioChef);
			rs = call.executeQuery();
			while(rs.next()){
				Servicio ser = new Servicio();
				ser.setCod_servicio(rs.getInt(1));
				ser.setNom_servicio(rs.getString(2));
				ser.setCod_chef(rs.getInt(3));
				ser.setNombre_chef(rs.getString(4));
				ser.setPlatillos(rs.getString(5));
				ser.setDescripcion(rs.getString(6));
				ser.setPrecio_persona(rs.getDouble(7));
				ser.setFec_publicacion(rs.getString(8));
				lista.add(ser);
				System.out.println("MySqlServicio - listarServicio ==> "+ser.getCod_servicio()+" - "+ser.getNom_servicio());

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

	@Override
	public void ListarImagen(String servicio, HttpServletResponse response) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		PreparedStatement pre = null;
		response.setContentType("image/*");
		try {
			outputStream = response.getOutputStream();
			con= MysqlBDConexion.getConexion();
			pre = con.prepareStatement("select * from servicio where nom_servicio = '"+servicio+"'");
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
		} finally {
			try {
				if(con !=null)con.close();
				if(pre !=null)pre.close();
				if(rs !=null)rs.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	@Override
	public List<Servicio> ListarServicioUltimos() {
		List<Servicio> lista = new ArrayList<Servicio>();
		try {
			con=MysqlBDConexion.getConexion();
			call = con.prepareCall("call ListarServicioUltimos");
			rs = call.executeQuery();
			while(rs.next()){
				Servicio ser = new Servicio();
				ser.setCod_servicio(rs.getInt(1));
				ser.setNom_servicio(rs.getString(2));
				ser.setCod_chef(rs.getInt(3));
				ser.setNombre_chef(rs.getString(4));
				ser.setPlatillos(rs.getString(5));
				ser.setDescripcion(rs.getString(6));
				ser.setPrecio_persona(rs.getDouble(7));
				ser.setFec_publicacion(rs.getString(8));
				lista.add(ser);
				System.out.println("MySqlServicio - listarServicio ==> "+ser.getCod_servicio()+" - "+ser.getNom_servicio());
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
	@Override
	public Servicio BuscarServicio(int codigo) {
		Servicio objServicio = new Servicio();
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call BuscarServicio(?)");
			call.setInt(1, codigo);
			rs = call.executeQuery();
			while(rs.next()){
				objServicio.setCod_servicio(rs.getInt(1));
				objServicio.setNom_servicio(rs.getString(2));
				objServicio.setCod_chef(rs.getInt(3));
				objServicio.setNombre_chef(rs.getString(4));
				objServicio.setPlatillos(rs.getString(5));
				objServicio.setDescripcion(rs.getString(6));
				objServicio.setPrecio_persona(rs.getDouble(7));
				objServicio.setFec_publicacion(rs.getString(8));
				
			}
			System.out.println("MySqlServicio - BuscarServicio ==> "+objServicio.getNom_servicio());
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
		return objServicio;
	}
	@Override
	public void EliminarServicio(int codigo) {
		try {
			con = MysqlBDConexion.getConexion();
			call = con.prepareCall("call EliminarServicio(?)");
			call.setInt(1, codigo);
			call.executeUpdate();
			System.out.println("MySqlServicio - EliminarServicio ==> "+call);
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
	

}
