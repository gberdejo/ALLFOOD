package DAO;

import java.util.List;

import Entidades.Chef;

public interface ChefDAO {
	public abstract Chef ValidarChef(String usuario,String password);
	public abstract void RegistrarChef(Chef registraChef);
	public abstract List<Chef>listarChef();
	public abstract Chef BuscarChefUsuario(String usuario);
}
