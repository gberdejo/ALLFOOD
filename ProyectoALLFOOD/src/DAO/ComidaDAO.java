package DAO;

import java.util.List;

import Entidades.Comida;

public interface ComidaDAO {
	
	public abstract int RegistrarComida(Comida registraComida);
	public abstract List<Comida>listarChef(Comida listarComida);
}
