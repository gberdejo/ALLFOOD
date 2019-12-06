package DAO;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import Entidades.Servicio;

public interface ServicioDAO {
	
	public abstract boolean RegistrarServicio(Servicio registraServicio);
	public abstract List<Servicio>listarServicio( );
	public abstract List<Servicio>ListarServicioUltimos( );
	public abstract List<Servicio> ListarServicioChef(String usuarioChef);
	public abstract void ListarImagen(String servicio,HttpServletResponse response);
	public abstract Servicio BuscarServicio(int codigo);
	public abstract void EliminarServicio(int codigo);
	public abstract boolean ActualizarServicio(Servicio servicio);
}
