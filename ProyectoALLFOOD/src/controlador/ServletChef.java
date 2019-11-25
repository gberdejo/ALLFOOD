package controlador;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


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


	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChefFabrica chefFabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
		ChefDAO chefDAO = chefFabrica.getChefDAO();
		Chef chef = new Chef();
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Part archivo = request.getPart("foto");
		InputStream foto = archivo.getInputStream();
		String presentacion = request.getParameter("presentacion");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String direccion = request.getParameter("direccion");
		String celular = request.getParameter("celular");
		
		System.out.println(""
				+ "Usuario: "+usuario+", "
				+ "password: "+password+", "
				+"nombre: "+nombre+", "
				+"apellido: "+apellido+", "
				+"presentacion: "+presentacion+", "
				+"edad: "+edad+", "
				+"celular: "+celular+", "
				+"direccion: "+direccion
				);
		
			chef.setUsuario(usuario);
			chef.setPassword(password);
			chef.setNom_chef(nombre);
			chef.setApe_chef(apellido);
			chef.setAvatar(foto);
			chef.setPresentacion(presentacion);
			chef.setEdad(edad);
			chef.setDieccion(direccion);
			chef.setCelular(celular);
			if(chefDAO.RegistrarChef(chef) == true){
				request.getRequestDispatcher("/chef_login.jsp").forward(request, response);
			}else{
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
		
			chef = chefDAO.ValidarChef(usuario, password);
			if (chef == null) {
				request.setAttribute("MENSASE", "El Usuario '"+usuario+"' no existe");
				request.getRequestDispatcher("/chef_login.jsp").forward(request, response);
				
			}else{
				HttpSession sesion = request.getSession();
				
				sesion.setAttribute("USUARIOCHEF",chef);
				request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
			}
	
		
		
	}

}
