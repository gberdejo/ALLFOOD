package fabricas;

import DAO.ChefDAO;

public abstract class ChefFabrica {

	public static final int MYSQL = 0;
	
	public abstract ChefDAO getChefDAO(); 
	
	public static ChefFabrica ElegirBaseDatos(int tipo){
		ChefFabrica chefFabrica = null;
		switch(tipo){
		case MYSQL : chefFabrica = new SubFabricaChef();
		}
		return chefFabrica;
	}



}
