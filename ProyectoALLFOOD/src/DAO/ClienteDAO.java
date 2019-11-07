package DAO;

import java.util.List;

import Entidades.Cliente;

public interface ClienteDAO {
	public abstract Cliente ValidarCliente(String usuario,String password);
	public abstract int RegistrarCliente(Cliente registraCli);
	public abstract List<Cliente>listarChef(Cliente listarCli);
}
