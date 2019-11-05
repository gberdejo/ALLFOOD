package DAO;

import java.util.List;

import Entidades.Servicio;

public interface ServicioDAO {
	
	public abstract int RegistrarServicio(Servicio registraServicio);
	public abstract List<Servicio>listarServicio(Servicio listarServicio);
}
