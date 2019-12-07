package DAO;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import Entidades.Chef;

public interface ChefDAO {
	public abstract Chef ValidarChef(String usuario,String password);
	public abstract boolean RegistrarChef(Chef registraChef);
	public abstract boolean ActualizarChef(Chef chef);
	public abstract List<Chef>listarChef();
	public abstract List<Chef>listarChefUltimos();
	public abstract List<Chef>listarTopChef();
	public abstract Chef BuscarChefUsuario(String usuario);
	public abstract void ListarImagen(String usuario,HttpServletResponse response);
}
