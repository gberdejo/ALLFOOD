package fabricas;

import DAO.ClienteDAO;

public abstract class ClienteFabrica {
	
	public static final int MYSQL = 0;
	
	public abstract ClienteDAO getClienteDAO(); 
	
	public static ClienteFabrica ElegirBaseDatos(int tipo){
		ClienteFabrica cliFabrica = null;
		switch(tipo){
		case MYSQL : cliFabrica = new SubFabricaCLiente();
		}
		return cliFabrica;
	}

}
