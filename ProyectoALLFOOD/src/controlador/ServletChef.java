package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ChefDAO;
import Entidades.Chef;
import fabricas.ChefFabrica;


/**
 * Servlet implementation class ServletLoginChef
 */
@WebServlet("/ServletChef")
public class ServletChef extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		if(tipo.equalsIgnoreCase("login")){
			login(request,response);
		}else if(tipo.equalsIgnoreCase("registro")){
			registro(request,response);
		}
	}


	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ChefFabrica chefFabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
		ChefDAO chefDAO = chefFabrica.getChefDAO();
		Chef chef = new Chef();
		chef.setUsuario(request.getParameter("usuario"));
		chef.setPassword(request.getParameter("password"));
		chef.setNom_chef(request.getParameter("nombre"));
		chef.setApe_chef(request.getParameter("apellido"));
		chef.setEdad(Integer.parseInt(request.getParameter("edad")));
		chef.setDieccion(request.getParameter("direccion"));
		chef.setCelular(request.getParameter("celular"));
		try {
			chefDAO.RegistrarChef(chef);
			request.getRequestDispatcher("/chef_login.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("MENSAJE", "Error al intentar Registrarse :C");
			request.getRequestDispatcher("/chef_registro.jsp").forward(request, response);
		}
		
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		ChefFabrica chefFabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
		ChefDAO chefDAO = chefFabrica.getChefDAO();
		
		Chef chef = null;
		try {
			chef = chefDAO.ValidarChef(usuario, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (chef == null) {
			request.setAttribute("MENSASE", "El Usuario '"+usuario+"' no existe");
			request.getRequestDispatcher("/chef_login.jsp").forward(request, response);
			
		}else{
			HttpSession sesion = request.getSession();
			
			sesion.setAttribute("CHEF",chef);
			request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
		}
	}

}
