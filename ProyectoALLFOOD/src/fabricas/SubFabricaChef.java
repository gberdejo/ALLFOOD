package fabricas;

import DAO.ChefDAO;

import MySqlDAO.MySqlChefDAO;

public class SubFabricaChef extends ChefFabrica {

	@Override
	public ChefDAO getChefDAO() {
		// TODO Auto-generated method stub
		return new MySqlChefDAO();
	}

}
