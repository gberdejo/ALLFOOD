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
@WebServlet("/ServletLoginChef")
public class ServletLoginChef extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

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
			
		
		
	
		// TODO Auto-generated method stub
	}

}
