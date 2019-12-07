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
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLBoundFault;

import DAO.ChefDAO;
import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ServicioDAO;
import Entidades.Chef;
import Entidades.Servicio;
import fabricas.ChefFabrica;
import fabricas.ClienteFabrica;
import fabricas.PedidoFabrica;
import fabricas.ServicioFabrica;


/**
 * Servlet implementation class ServletLoginChef
 */
@WebServlet("/ServletChef")
@MultipartConfig
public class ServletChef extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ClienteFabrica cliFabrica = ClienteFabrica.ElegirBaseDatos(ClienteFabrica.MYSQL);
	ClienteDAO clienteDAO = cliFabrica.getClienteDAO();
	//
	ChefFabrica chefFabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
	ChefDAO chefDAO = chefFabrica.getChefDAO();
	//
	ServicioFabrica servicioFabnrica = ServicioFabrica.TipoDeConexion(ServicioFabrica.MYSQL);
	ServicioDAO servicioDAO = servicioFabnrica.getServicioDAO();
	//
	PedidoFabrica perdidoFabrica = PedidoFabrica.tipoConexion(PedidoFabrica.MYSQL);
	PedidoDAO pedidoDAO = perdidoFabrica.getPedidoDAO();
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
		}else if(tipo.equalsIgnoreCase("actualizarChef")){
			ActualizarChef(request,response);
		}else if(tipo.equalsIgnoreCase("eliminarServicio")){
			EliminarServicio(request,response);
		}else if(tipo.equalsIgnoreCase("irEditarServicio")){
			irEditarServicio(request,response);
		}else if(tipo.equalsIgnoreCase("EditarServicio")){
			EditarServicio(request,response);
		}
	}
	private void EditarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Servicio servicio = new Servicio();
		String usuariochef = request.getParameter("chef"); 
		servicio.setCod_servicio(Integer.parseInt(request.getParameter("codigo")));
		servicio.setNom_servicio(request.getParameter("nombre"));
		servicio.setPlatillos(request.getParameter("platos"));
		servicio.setDescripcion(request.getParameter("descrip"));
		Part part = request.getPart("imagen");
		InputStream imagen = part.getInputStream();
		servicio.setLogo(imagen);
		servicio.setPrecio_persona(Double.parseDouble(request.getParameter("precio")));
		if(servicioDAO.ActualizarServicio(servicio)){
			HttpSession sesion = request.getSession();
			sesion.setAttribute("LISTASERVICIOCHEF", servicioDAO.ListarServicioChef(usuariochef));
			sesion.setAttribute("LISTAPEDIDOSCHEF", pedidoDAO.ListarPedidoChef(usuariochef));

			//
			sesion.setAttribute("LISTATOPCHEF", chefDAO.listarTopChef());
			sesion.setAttribute("LISTASERVICIOULTIMOS", servicioDAO.ListarServicioUltimos());
			sesion.setAttribute("LISTACHEFULTIMOS", chefDAO.listarChefUltimos());
			sesion.setAttribute("LISTACLIENTE", clienteDAO.listarClienteUltimos());
			request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/servicio_editar.jsp").forward(request, response);
		}
		
	}
	private void irEditarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int codigoServicio = Integer.parseInt(request.getParameter("codigo"));
		HttpSession session = request.getSession();
		session.setAttribute("SERVICIO", servicioDAO.BuscarServicio(codigoServicio));
		request.getRequestDispatcher("/servicio_editar.jsp").forward(request, response);
	}
	private void EliminarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String usuariochef = request.getParameter("chef");
		servicioDAO.EliminarServicio(codigo);
		HttpSession sesion = request.getSession();
		sesion.setAttribute("LISTASERVICIOCHEF", servicioDAO.ListarServicioChef(usuariochef));
		sesion.setAttribute("LISTAPEDIDOSCHEF", pedidoDAO.ListarPedidoChef(usuariochef));

		//
		sesion.setAttribute("LISTATOPCHEF", chefDAO.listarTopChef());
		sesion.setAttribute("LISTASERVICIOULTIMOS", servicioDAO.ListarServicioUltimos());
		sesion.setAttribute("LISTACHEFULTIMOS", chefDAO.listarChefUltimos());
		sesion.setAttribute("LISTACLIENTE", clienteDAO.listarClienteUltimos());
		request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
		
	}
	private void ActualizarChef(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usuariochef = request.getParameter("chef"); 
		String codigo = request.getParameter("codigo");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Part part = request.getPart("imagen");
		InputStream imagen = part.getInputStream();
		String presentacion = request.getParameter("presentacion");
		String celular = request.getParameter("celular");
		String direccion = request.getParameter("direccion");
		System.out.println(
		"input:"+codigo+","+password+","+nombre+","+apellido+","+imagen+","+presentacion+","+celular+","+direccion);
		Chef chef = new Chef();
		chef.setCod_chef(Integer.parseInt(codigo));
		chef.setPassword(password);
		chef.setNom_chef(nombre);
		chef.setApe_chef(apellido);
		chef.setAvatar(imagen);
		chef.setPresentacion(presentacion);
		chef.setCelular(celular);
		chef.setDieccion(direccion);
		if(chefDAO.ActualizarChef(chef)){
			HttpSession sesion = request.getSession();
			sesion.setAttribute("LISTASERVICIOCHEF", servicioDAO.ListarServicioChef(usuariochef));
			sesion.setAttribute("LISTAPEDIDOSCHEF", pedidoDAO.ListarPedidoChef(usuariochef));

			//
			sesion.setAttribute("LISTATOPCHEF", chefDAO.listarTopChef());
			sesion.setAttribute("LISTASERVICIOULTIMOS", servicioDAO.ListarServicioUltimos());
			sesion.setAttribute("LISTACHEFULTIMOS", chefDAO.listarChefUltimos());
			sesion.setAttribute("LISTACLIENTE", clienteDAO.listarClienteUltimos());
			request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/chef_editar.jsp").forward(request, response);
		}

	}
	private void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usuariochef  = request.getParameter("chef");
		HttpSession sesion = request.getSession();
		sesion.setAttribute("LISTASERVICIOCHEF", servicioDAO.ListarServicioChef(usuariochef));
		sesion.setAttribute("LISTAPEDIDOSCHEF", pedidoDAO.ListarPedidoChef(usuariochef));

		//
		sesion.setAttribute("LISTATOPCHEF", chefDAO.listarTopChef());
		sesion.setAttribute("LISTASERVICIOULTIMOS", servicioDAO.ListarServicioUltimos());
		sesion.setAttribute("LISTACHEFULTIMOS", chefDAO.listarChefUltimos());
		sesion.setAttribute("LISTACLIENTE", clienteDAO.listarClienteUltimos());
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
		
		servicio.setNom_servicio(nombreSer);
		servicio.setCod_chef(codigochef);
		servicio.setPlatillos(platillos);
		servicio.setDescripcion(descripcion);
		servicio.setLogo(imagen);
		servicio.setPrecio_persona(precio);
		HttpSession session = request.getSession();
		if(servicioDAO.RegistrarServicio(servicio)){
			HttpSession sesion = request.getSession();
			sesion.setAttribute("LISTASERVICIOCHEF", servicioDAO.ListarServicioChef(usuariochef));
			sesion.setAttribute("LISTAPEDIDOSCHEF", pedidoDAO.ListarPedidoChef(usuariochef));
			//
			sesion.setAttribute("LISTATOPCHEF", chefDAO.listarTopChef());
			sesion.setAttribute("LISTASERVICIOULTIMOS", servicioDAO.ListarServicioUltimos());
			sesion.setAttribute("LISTACHEFULTIMOS", chefDAO.listarChefUltimos());
			sesion.setAttribute("LISTACLIENTE", clienteDAO.listarClienteUltimos());
			request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/servicio.jsp").forward(request, response);
		}
		
	}
	private void salir(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	private void perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String chef = request.getParameter("chef");
		HttpSession sesion = request.getSession();
		sesion.setAttribute("LISTAPEDIDOSCHEF", pedidoDAO.ListarPedidoChef(chef));
		sesion.setAttribute("CHEFPERFIL", chefDAO.BuscarChefUsuario(chef));
		sesion.setAttribute("LISTASERVICIOCHEF", servicioDAO.ListarServicioChef(chef));
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
			sesion.setAttribute("USUARIOCHEF",objchef);
			//
			sesion.setAttribute("LISTASERVICIOULTIMOS", servicioDAO.ListarServicioUltimos());
			sesion.setAttribute("LISTACHEFULTIMOS", chefDAO.listarChefUltimos());
			sesion.setAttribute("LISTACLIENTE", clienteDAO.listarClienteUltimos());
			sesion.setAttribute("LISTATOPCHEF", chefDAO.listarTopChef());
			sesion.setAttribute("LISTAPEDIDOSCHEF", pedidoDAO.ListarPedidoChef(usuario));
			request.getRequestDispatcher("/chef_pagina.jsp").forward(request, response);
		}
	}

}
