package fabricas;

import DAO.ClienteDAO;
import MySqlDAO.MySqlClienteDAO;

public class SubFabricaCLiente extends ClienteFabrica {

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new MySqlClienteDAO();
	}

}
