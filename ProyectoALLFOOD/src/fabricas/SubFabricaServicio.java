package fabricas;

import DAO.ChefDAO;
import MySqlDAO.MySqlChefDAO;

public class SubFabricaServicio extends ServicioFabrica {

	@Override
	public ChefDAO getChefDAO() {
		return new MySqlChefDAO();
	}

}
