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

import com.sun.org.apache.bcel.internal.generic.IndexedInstruction;
import com.sun.xml.internal.fastinfoset.sax.SAXDocumentSerializer;

import DAO.ChefDAO;
import DAO.ServicioDAO;
import Entidades.Chef;
import Entidades.Servicio;
import fabricas.ChefFabrica;
import fabricas.ServicioFabrica;


/**
 * Servlet implementation class ServletLoginChef
 */
@WebServlet("/ServletChef")
@MultipartConfig
public class ServletChef extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ChefFabrica chefFabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
	ChefDAO chefDAO = chefFabrica.getChefDAO();
	//
	ServicioFabrica servicioFabnrica = ServicioFabrica.TipoDeConexion(ServicioFabrica.MYSQL);
	ServicioDAO servicioDAO = servicioFabnrica.getServicioDAO();
	Servicio servicio = new Servicio();
	
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
		}else if(tipo.equalsIgnoreCase("salir")){
			salir(request,response);
		}else if(tipo.equalsIgnoreCase("registraServicio")){
			registraServicio(request,response);
		}else if(tipo.equalsIgnoreCase("imagenServicio")){
			imagenServicio(request,response);
		}else if(tipo.equalsIgnoreCase("inicio")){
			inicio(request,response);
		}
	}
	private void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usuariochef  = request.getParameter("chef");
		HttpSession sesion = request.getSession();
		sesion.setAttribute("LISTASERVICIOCHEF", servicioDAO.ListarServicioChef(usuariochef));
		sesion.setAttribute("LISTASERVICIO", servicioDAO.ListarServicioUltimos());
		request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
		
	}
	private void registraServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		Part part = request.getPart("imagenser");
		InputStream imagen = part.getInputStream();
		String nombreSer = request.getParameter("nombreser");
		int codigochef = Integer.parseInt(request.getParameter("codigoChef"));
		String platillos = request.getParameter("platillos");
		String descripcion =request.getParameter("descripcionser");
		double precio = Double.parseDouble(request.getParameter("precioser"));
		String usuariochef = request.getParameter("usuariochef");
		
		System.out.println(
		"Servlet - nombre de servicio :"+nombreSer+","+codigochef+","+platillos+","
		+descripcion+","+imagen+","+precio);
		
		servicio.setNom_servico(nombreSer);
		servicio.setCod_chef(codigochef);
		servicio.setPlatillos(platillos);
		servicio.setDescripcion(descripcion);
		servicio.setLogo(imagen);
		servicio.setPrecio_persona(precio);
		HttpSession session = request.getSession();
		if(servicioDAO.RegistrarServicio(servicio)){
			HttpSession sesion = request.getSession();
			sesion.setAttribute("LISTASERVICIOCHEF", servicioDAO.ListarServicioChef(usuariochef));
			sesion.setAttribute("LISTASERVICIO", servicioDAO.ListarServicioUltimos());
			request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/servicio.jsp").forward(request, response);
			session.setAttribute("MENSAJEREGISTROSERVICIO", "El servicio no se ha registrado");
		}
		
	}
	private void salir(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	private void perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		String usuario=request.getParameter("usuario");
		chefDAO.ListarImagen(usuario, response);
	}
	private void imagenServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String servicio=request.getParameter("servicio");
		servicioDAO.ListarImagen(servicio, response);
	}
	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		Chef objchef = null;
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		try {
			objchef = chefDAO.ValidarChef(usuario, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		if (objchef == null) {
			request.setAttribute("MENSASE", "El Usuario no existe");
			request.getRequestDispatcher("/chef_login.jsp").forward(request, response);
				
		}else{
			HttpSession sesion = request.getSession();
			sesion.setAttribute("LISTASERVICIOCHEF", servicioDAO.ListarServicioChef(usuario));
			sesion.setAttribute("LISTASERVICIO", servicioDAO.ListarServicioUltimos());
			sesion.setAttribute("LISTACHEF", chefDAO.listarChef());
			sesion.setAttribute("USUARIOCHEF",objchef);
			request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
		}
	}

}
