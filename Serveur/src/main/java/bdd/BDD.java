
package bdd;

import java.util.List;


public class BDD {

	Init init;

	public BDD() {
		init = Init.getInstance();
	}
	
	public List<Barber> getBarbers(){
		return init.getBarberDao().listerBarbers();
	}
	
	public List<Client> getClients(){
		return init.getClientDao().listerClients();
	}
}