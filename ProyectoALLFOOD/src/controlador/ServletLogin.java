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

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("password");
		ClienteFabrica cliFabrica = ClienteFabrica.ElegirBaseDatos(ClienteFabrica.MYSQL);
		ClienteDAO clienteDAO = cliFabrica.getClienteDAO();
		
		Cliente cliente = null;
		try {
			cliente = clienteDAO.ValidarCliente(usuario, contraseña);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (cliente == null) {
			request.setAttribute("MENSASE", "El Usuario '"+usuario+"' no existe");
			request.getRequestDispatcher("/usuario_login.jsp").forward(request, response);
			
		}else{
			HttpSession sesion = request.getSession();
			
			sesion.setAttribute("USUARIO",cliente);
			request.getRequestDispatcher("/usuario_pagina.jsp").forward(request, response);
		}
			
		
		
	}

}
