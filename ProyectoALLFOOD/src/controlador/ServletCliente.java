package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ChefDAO;
import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ServicioDAO;
import Entidades.Cliente;
import fabricas.ChefFabrica;
import fabricas.ClienteFabrica;
import fabricas.PedidoFabrica;
import fabricas.ServicioFabrica;

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
		}else if(tipo.equalsIgnoreCase("refrescar")){
			refrescar(request,response);
		}else if(tipo.equalsIgnoreCase("perfilchef")){
			perfilchef(request,response);
		}
	}
	private void perfilchef(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ChefFabrica cheffabrica = ChefFabrica.ElegirBaseDatos(ChefFabrica.MYSQL);
		ChefDAO chefDAO = cheffabrica.getChefDAO();
		//
		ServicioFabrica serFa = ServicioFabrica.TipoDeConexion(ServicioFabrica.MYSQL);
		ServicioDAO serDAO = serFa.getServicioDAO();
		
		try {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("CHEF", chefDAO.BuscarChefUsuario(request.getParameter("usuariochef")));
			sesion.setAttribute("LISTACHEF", serDAO.ListarServicioChef(request.getParameter("usuariochef")));
			request.getRequestDispatcher("/chef_perfil.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		Cliente cli = new Cliente();
		int respuesta = 1;
		try {
			cli.setUsuario(request.getParameter("usuario"));
			cli.setPassword(request.getParameter("password"));
			cli.setNom_cli(request.getParameter("nombre"));
			cli.setApe_cli(request.getParameter("apellido"));
			cli.setEdad(Integer.parseInt(request.getParameter("edad")));
			cli.setCelular_cli(request.getParameter("celular"));
			cli.setSaldo_cli(Double.parseDouble(request.getParameter("saldo")));
			respuesta =clienteDAO.BuscarCliente(request.getParameter("usuario"));
		
		} catch (Exception e) {
			e.getMessage();
		}
		if(respuesta == 0){
				try {
					clienteDAO.RegistrarCliente(cli);
					request.getRequestDispatcher("/usuario_login.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
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
		//conectanto con los servicios
		PedidoFabrica perdidoFabrica = PedidoFabrica.tipoConexion(PedidoFabrica.MYSQL);
		PedidoDAO pedidoDAO = perdidoFabrica.getPedidoDAO();
		
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
			sesion.setAttribute("LISTARCHEF", chefDAO.listarChef());
			request.getRequestDispatcher("/usuario_pagina.jsp").forward(request, response);
		}
		
		
		}

}
