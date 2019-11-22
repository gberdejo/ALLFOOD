package fabricas;

import DAO.ChefDAO;

public abstract class ServicioFabrica {
	
	public static final int MYSQL = 0;
	
	public abstract ChefDAO getChefDAO();
	public static ServicioFabrica TipoDeConexion(int tipo){
		ServicioFabrica serFa = null;
		switch(tipo){
			case MYSQL :serFa = new SubFabricaServicio();break;
		}
		return serFa;
	}
}
