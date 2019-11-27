package controlador;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import DAO.ChefDAO;
import DAO.ServicioDAO;
import Entidades.Chef;
import fabricas.ChefFabrica;
import fabricas.ServicioFabrica;


/**
 * Servlet implementation class ServletLoginChef
 */
@WebServlet("/ServletChef")
@MultipartConfig
public class ServletChef extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		if(tipo.equalsIgnoreCase("login")){
			login(request,response);
		}else if(tipo.equalsIgnoreCase("registro")){
			registro(request,response);
		}else if(tipo.equalsIgnoreCase("imagen")){
			imagen(request,response);
		}else if(tipo.equalsIgnoreCase("perfil")){
			perfil(request,response);
		}
	}

	private void perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ChefFabrica chefFabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
		ChefDAO chefDAO = chefFabrica.getChefDAO();
		//
		ServicioFabrica serFa = ServicioFabrica.TipoDeConexion(ServicioFabrica.MYSQL);
		ServicioDAO serDAO = serFa.getServicioDAO();
		
		String chef = request.getParameter("chef");
		System.out.println(chef);
		HttpSession sesion = request.getSession();
		sesion.setAttribute("CHEF", chefDAO.BuscarChefUsuario(chef));
		sesion.setAttribute("LISTASERVICIOCHEF", serDAO.ListarServicioChef(chef));
		request.getRequestDispatcher("/chef_perfil.jsp").forward(request, response);
		
		
	}
	private void imagen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ChefFabrica chefFabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
		ChefDAO chefDAO = chefFabrica.getChefDAO();
		String usuario=request.getParameter("usuario");
		chefDAO.ListarImagen(usuario, response);
		
	}


	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChefFabrica chefFabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
		ChefDAO chefDAO = chefFabrica.getChefDAO();
		Chef objchef = new Chef();
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Part par = request.getPart("imagen");
		InputStream inputStream = par.getInputStream();
		String presentacion = request.getParameter("presentacion");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String direccion = request.getParameter("direccion");
		String celular = request.getParameter("celular");
		
		objchef.setUsuario(usuario);
		objchef.setPassword(password);
		objchef.setNom_chef(nombre);
		objchef.setApe_chef(apellido);
		objchef.setAvatar(inputStream);
		objchef.setPresentacion(presentacion);
		objchef.setEdad(edad);
		objchef.setDieccion(direccion);
		objchef.setCelular(celular);
			if(chefDAO.RegistrarChef(objchef)){
				request.getRequestDispatcher("/chef_login.jsp").forward(request, response);
			}else{
				request.setAttribute("MENSAJE", "Error al intentar Registrarse :C");
				request.getRequestDispatcher("/chef_registro.jsp").forward(request, response);
			}
		
		
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ChefFabrica chefFabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
		ChefDAO chefDAO = chefFabrica.getChefDAO();
		
		Chef objchef = null;
		try {
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			objchef = chefDAO.ValidarChef(usuario, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		if (objchef == null) {
			request.setAttribute("MENSASE", "El Usuario no existe");
			request.getRequestDispatcher("/chef_login.jsp").forward(request, response);
				
		}else{
			HttpSession sesion = request.getSession();
			sesion.setAttribute("USUARIOCHEF",objchef);
			request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
		}
	}

}
