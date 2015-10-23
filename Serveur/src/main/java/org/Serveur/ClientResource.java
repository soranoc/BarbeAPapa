package org.Serveur;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;



@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {

	@POST
	public Client createClient(Client client) {
		int id = Init.getInstance().getClientDao().insert(client);
		client.setIdt(id);
		return client;
	}
	
	@GET
	@Path("/{id}")
	public Client getClient(@PathParam("id") int idt) {
		Client client = Init.getInstance().getClientDao().findByIdt(idt);
		if (client == null) {
			throw new WebApplicationException(404);
		}
		return client;
	}

    	@GET
	public List<Client> getAllCLient() {
		return getDao().listerClients();
	}
}
