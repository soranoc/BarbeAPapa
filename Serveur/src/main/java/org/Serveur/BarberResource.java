package org.Serveur;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/barber")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BarberResource {

	@POST
	public Barber createBarber(Barber barber) {
		int id = Init.getInstance().getBarberDao().insert(barber);
		barber.setIdt(id);
		return barber;
	}
	
	@GET
	@Path("/{id}")
	public Barber getBarber(@PathParam("id") int idt) {
		Barber barber = Init.getInstance().getBarberDao().findByIdt(idt);
		if (barber == null) {
			throw new WebApplicationException(404);
		}
		return barber;
	}

}
