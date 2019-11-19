package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ClienteDAO;
import Entidades.Cliente;
import fabricas.ClienteFabrica;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tipo = request.getParameter("tipo");
		if(tipo.equalsIgnoreCase("login")){
			login(request,response);
		}else if(tipo.equalsIgnoreCase("registro")){
			registro(request,response);
		}
	}
	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ClienteFabrica cliFabrica = ClienteFabrica.ElegirBaseDatos(ClienteFabrica.MYSQL);
		ClienteDAO clienteDAO = cliFabrica.getClienteDAO();
		Cliente cli = new Cliente();
		cli.setUsuario(request.getParameter("usuario"));
		cli.setPassword(request.getParameter("password"));
		cli.setNom_cli(request.getParameter("nombre"));
		cli.setApe_cli(request.getParameter("apellido"));
		cli.setEdad(Integer.parseInt("edad"));
		cli.setCelular_cli(request.getParameter("celular"));
		cli.setSaldo_cli(Double.parseDouble(request.getParameter("saldo")));
		int salida= -1;
		try {
			salida = clienteDAO.RegistrarCliente(cli);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(salida > 0){
			request.setAttribute("MENSAJE", "Error al Registrar");
			request.getRequestDispatcher("/usuario_usuario.jsp").forward(request, null);
			
		}else{
			request.getRequestDispatcher("/usuario_login.jsp").forward(request, null);
		}
		
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		ClienteFabrica cliFabrica = ClienteFabrica.ElegirBaseDatos(ClienteFabrica.MYSQL);
		ClienteDAO clienteDAO = cliFabrica.getClienteDAO();
		
		Cliente cliente = null;
		try {
			cliente = clienteDAO.ValidarCliente(usuario, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (cliente == null) {
			request.setAttribute("MENSASE", "El Usuario  no existe");
			request.getRequestDispatcher("/usuario_login.jsp").forward(request, response);
			
		}else{
			HttpSession sesion = request.getSession();
			
			sesion.setAttribute("USUARIO",cliente);
			request.getRequestDispatcher("/usuario_pagina.jsp").forward(request, response);
		}
			
		
		
	}

}
