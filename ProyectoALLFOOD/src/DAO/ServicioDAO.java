package DAO;

import java.util.List;

import Entidades.Servicio;

public interface ServicioDAO {
	
	public abstract void RegistrarServicio(Servicio registraServicio);
	public abstract List<Servicio>listarServicio( );
	public abstract List<Servicio> ListarServicioChef(String usuarioChef);
}
