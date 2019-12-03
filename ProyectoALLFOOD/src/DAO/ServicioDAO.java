package DAO;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import Entidades.Servicio;

public interface ServicioDAO {
	
	public abstract boolean RegistrarServicio(Servicio registraServicio);
	public abstract List<Servicio>listarServicio( );
	public abstract List<Servicio> ListarServicioChef(String usuarioChef);
	public abstract void ListarImagen(Servicio servicio,HttpServletResponse response);
}
