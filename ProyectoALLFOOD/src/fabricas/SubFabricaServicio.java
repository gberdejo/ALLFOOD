package fabricas;

import MySqlDAO.MySqlServicioDAO;

public class SubFabricaServicio extends ServicioFabrica {

	
	@Override
	public DAO.ServicioDAO getServicioDAO() {
		
		return new MySqlServicioDAO();
	}

}
