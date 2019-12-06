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

import com.mysql.fabric.xmlrpc.Client;

import DAO.ChefDAO;
import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ServicioDAO;
import Entidades.Cliente;
import Entidades.Pedido;
import Entidades.Servicio;
import fabricas.ChefFabrica;
import fabricas.ClienteFabrica;
import fabricas.PedidoFabrica;
import fabricas.ServicioFabrica;
import javafx.geometry.Side;

@WebServlet("/ServletCliente")
@MultipartConfig
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
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

	Cliente objCliente = new Cliente();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tipo = request.getParameter("tipo");
		if(tipo.equalsIgnoreCase("login")){
			login(request,response);
		}else if(tipo.equalsIgnoreCase("registro")){
			registro(request,response);
		}else if(tipo.equalsIgnoreCase("salir")){
			salir(request,response);
		}else if(tipo.equalsIgnoreCase("inicio")){
			inicio(request,response);
		}else if(tipo.equalsIgnoreCase("imagen")){
			imagen(request,response);
		}else if(tipo.equalsIgnoreCase("perfil")){
			perfil(request,response);
		}else if (tipo.equalsIgnoreCase("irpedido")) {
			irpedido(request,response);
		}else if (tipo.equalsIgnoreCase("compra")){
			CompraPedido(request,response);
		}else if(tipo.equalsIgnoreCase("actualizarCliente")){
			ActualizarCliente(request,response);
		}
	}
	private void ActualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Cliente cliente = new Cliente();
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String celular = request.getParameter("celular");
		Part part = request.getPart("imagen");
		InputStream imagen = part.getInputStream();
		//
		cliente.setCod_cli(codigo);
		cliente.setPassword(password);
		cliente.setNom_cli(nombre);
		cliente.setApe_cli(apellido);
		cliente.setAvatar(imagen);
		cliente.setCelular_cli(celular);
		if(clienteDAO.ActualizarCliente(cliente)){
			inicio(request,response);
		}else{
			request.getRequestDispatcher("/usuario_editar.jsp").forward(request, response);
		}
			
		
		
	}
	private void CompraPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Pedido pedido = new Pedido();
		int codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
		int codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double total = Double.parseDouble(request.getParameter("total"));
		String direccion = request.getParameter("direccion");
		String fecha = request.getParameter("fecha");
		System.out.println("entrada: "+codigoCliente+" - "+codigoServicio+" - "+fecha);
		pedido.setCodigo_cliente(codigoCliente);
		pedido.setCodigo_servicio(codigoServicio);
		pedido.setCantidad_personas(cantidad);
		pedido.setPago_total(total);
		pedido.setDireccion_entrega(direccion);
		pedido.setFecha_entrega(fecha);
		if(pedidoDAO.RegistrarPedido(pedido)){
			inicio(request,response);
		}else {
			request.getRequestDispatcher("/pedidos.jsp").forward(request, response);
		}
			
		
		
	}
	private void irpedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		System.out.println("codigo de servicio: "+codigo);
		HttpSession session = request.getSession();
		session.setAttribute("OBJSERVICIO", servicioDAO.BuscarServicio(codigo));
		request.getRequestDispatcher("/pedidos.jsp").forward(request, response);
		
	}
	private void imagen(HttpServletRequest request, HttpServletResponse response) {
		String nombreUsuario =request.getParameter("usuario");
		clienteDAO.ListarImagen(nombreUsuario, response);
		
	}
	private void perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String usuario = request.getParameter("usuario");
		Cliente objCliente = clienteDAO.BuscarClienteUsuario(usuario);
		HttpSession sesion = request.getSession();
		request.getRequestDispatcher("/usuario_perfil.jsp").forward(request, response);
			
	}
	private void inicio(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{

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
			sesion.setAttribute("LISTASERVICIO", servicioDAO.ListarServicioUltimos());
			sesion.setAttribute("LISTACHEF", chefDAO.listarChef());
			request.getRequestDispatcher("/usuario_pagina.jsp").forward(request, response);
		}
		
		
		}

}
