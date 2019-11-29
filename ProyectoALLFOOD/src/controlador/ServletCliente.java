package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.ChefDAO;
import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ServicioDAO;
import Entidades.Cliente;
import Entidades.Servicio;
import fabricas.ChefFabrica;
import fabricas.ClienteFabrica;
import fabricas.PedidoFabrica;
import fabricas.ServicioFabrica;

@WebServlet("/ServletCliente")
@MultipartConfig
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
		}else if(tipo.equalsIgnoreCase("refrescar")){
			refrescar(request,response);
		}else if(tipo.equalsIgnoreCase("imagen")){
			imagen(request,response);
		}else if(tipo.equalsIgnoreCase("perfil")){
			perfil(request,response);
		}
	}
	private void imagen(HttpServletRequest request, HttpServletResponse response) {
		ClienteFabrica cliFabrica = ClienteFabrica.ElegirBaseDatos(ClienteFabrica.MYSQL);
		ClienteDAO clienteDAO = cliFabrica.getClienteDAO();
		String nombreUsuario =request.getParameter("usuario");
		clienteDAO.ListarImagen(nombreUsuario, response);
		
	}
	private void perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ClienteFabrica cliFabrica = ClienteFabrica.ElegirBaseDatos(ClienteFabrica.MYSQL);
		ClienteDAO clienteDAO = cliFabrica.getClienteDAO();
		//
		String usuario = request.getParameter("usuario");
		Cliente objCliente = clienteDAO.BuscarClienteUsuario(usuario);
		HttpSession sesion = request.getSession();
		request.getRequestDispatcher("/usuario_perfil.jsp").forward(request, response);
		
		
	}
	
	private void refrescar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		//conectando con el chef
		
			ChefFabrica cheffabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
			ChefDAO chefDAO = cheffabrica.getChefDAO();
			HttpSession sesion = request.getSession();
			sesion.setAttribute("LISTARCHEF", chefDAO.listarChef());
			request.getRequestDispatcher("/usuario_pagina.jsp").forward(request, response);
			
					
	}
	private void salir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ClienteFabrica cliFabrica = ClienteFabrica.ElegirBaseDatos(ClienteFabrica.MYSQL);
		ClienteDAO clienteDAO = cliFabrica.getClienteDAO();
		Cliente objCliente = new Cliente();
	
	
		objCliente.setUsuario(request.getParameter("usuario"));
		objCliente.setPassword(request.getParameter("password"));
		objCliente.setNom_cli(request.getParameter("nombre"));
		objCliente.setApe_cli(request.getParameter("apellido"));
		Part part = request.getPart("imagen");
		InputStream inputStream = part.getInputStream();
		objCliente.setAvatar(inputStream);
		objCliente.setEdad(Integer.parseInt(request.getParameter("edad")));
		objCliente.setCelular_cli(request.getParameter("celular"));
		objCliente.setSaldo_cli(Double.parseDouble(request.getParameter("saldo")));		
		
		if(clienteDAO.RegistrarCliente(objCliente) == true){	
			request.getRequestDispatcher("/usuario_login.jsp").forward(request, response);
				
		}else{
			request.setAttribute("MENSAJEREGISTRO", "Error al intentar Registrarse :C");
			request.getRequestDispatcher("/usuario_registra.jsp").forward(request, response);
		}
		
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteFabrica cliFabrica = ClienteFabrica.ElegirBaseDatos(ClienteFabrica.MYSQL);
		ClienteDAO clienteDAO = cliFabrica.getClienteDAO();
		//conectando con el chef
		ChefFabrica cheffabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
		ChefDAO chefDAO = cheffabrica.getChefDAO();
		//conectanto con los pedido
		PedidoFabrica perdidoFabrica = PedidoFabrica.tipoConexion(PedidoFabrica.MYSQL);
		PedidoDAO pedidoDAO = perdidoFabrica.getPedidoDAO();
		//conectando con el servicio
		ServicioFabrica servicioFabnrica = ServicioFabrica.TipoDeConexion(ServicioFabrica.MYSQL);
		ServicioDAO servicioDAO = servicioFabnrica.getServicioDAO();
		
		Cliente cliente = null;
				
		try {
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			cliente = clienteDAO.ValidarCliente(usuario, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (cliente == null) {
			request.setAttribute("MENSASE", "El Usuario o Contraseña no existen");
			request.getRequestDispatcher("/usuario_login.jsp").forward(request, response);
			
		}else{
			HttpSession sesion = request.getSession();
			sesion.setAttribute("USUARIOCLIENTE",cliente);
			//ENVIANDO LA LISTA DE SERVICIO PEDIDOS CHEFS
			sesion.setAttribute("LISTASERVICIO", servicioDAO.listarServicio());
			sesion.setAttribute("LISTARCHEF", chefDAO.listarChef());
			request.getRequestDispatcher("/usuario_pagina.jsp").forward(request, response);
		}
		
		
		}

}
