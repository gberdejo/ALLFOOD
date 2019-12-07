package DAO;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import Entidades.Cliente;

public interface ClienteDAO {
	public abstract Cliente ValidarCliente(String usuario,String password);
	public abstract boolean RegistrarCliente(Cliente registraCli);
	public abstract boolean ActualizarCliente(Cliente cliente);
	public abstract List<Cliente>listarCliente();
	public abstract List<Cliente>listarClienteUltimos();
	public abstract Cliente BuscarClienteUsuario(String usuario);
	public abstract void ListarImagen(String usuario,HttpServletResponse response);
}
