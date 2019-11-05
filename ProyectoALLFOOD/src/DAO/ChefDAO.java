package DAO;

import java.util.List;

import Entidades.Chef;

public interface ChefDAO {

	public abstract int RegistrarChef(Chef registraChef);
	public abstract List<Chef>listarChef(Chef listarChef);
}
