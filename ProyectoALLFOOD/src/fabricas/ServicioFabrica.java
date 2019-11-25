package fabricas;

import DAO.ServicioDAO;

public abstract class ServicioFabrica {
	
	public static final int MYSQL = 0;
	
	public abstract ServicioDAO getServicioDAO();
	
	public static ServicioFabrica TipoDeConexion(int tipo){
		ServicioFabrica serFa = null;
		switch(tipo){
			case MYSQL :serFa = new SubFabricaServicio();break;
		}
		return serFa;
	}
}
