package DAO;

import java.util.List;

import Entidades.Chef;
import Entidades.Cliente;

public interface ChefDAO {
	public abstract Chef ValidarChef(String usuario,String password);
	public abstract int RegistrarChef(Chef registraChef);
	public abstract List<Chef>listarChef(Chef listarChef);
}
