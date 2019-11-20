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
		}else if(tipo.equalsIgnoreCase("salir")){
			salir(request,response);
		}
	}
	private void salir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sesion = request.getSession();
		
		sesion.invalidate();
		request.setAttribute("MENSAJESALIR", "SESION EXPERADA");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ClienteFabrica cliFabrica = ClienteFabrica.ElegirBaseDatos(ClienteFabrica.MYSQL);
		ClienteDAO clienteDAO = cliFabrica.getClienteDAO();
		Cliente cli = new Cliente();
		
		try {
			cli.setUsuario(request.getParameter("usuario"));
			cli.setPassword(request.getParameter("password"));
			cli.setNom_cli(request.getParameter("nombre"));
			cli.setApe_cli(request.getParameter("apellido"));
			cli.setEdad(Integer.parseInt(request.getParameter("edad")));
			cli.setCelular_cli(request.getParameter("celular"));
			cli.setSaldo_cli(Double.parseDouble(request.getParameter("saldo")));
			
			clienteDAO.RegistrarCliente(cli);
			
			request.getRequestDispatcher("/usuario_login.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("MENSAJEREGISTRO", "Error al intentar Registrarse :C");
			request.getRequestDispatcher("/usuario_registra.jsp").forward(request, response);
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
			
			if (cliente == null) {
				request.setAttribute("MENSASE", "El Usuario o Contraseña no existen");
				request.getRequestDispatcher("/usuario_login.jsp").forward(request, response);
				
			}else{
				HttpSession sesion = request.getSession();
				
				sesion.setAttribute("USUARIOCLIENTE",cliente);
				request.getRequestDispatcher("/usuario_pagina.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		
		
	}

}
