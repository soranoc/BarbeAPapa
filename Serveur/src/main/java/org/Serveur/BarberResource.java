package org.Serveur;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/barber")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BarberResource {

	@POST
	public Barber createBarber(Barber barber) {
		int id = getDao().insert(barber);
		barber.setIdt(id);
		return barber;
	}

	private BarberDao getDao() {
		return Init.getInstance().getBarberDao();
	}

	@GET
	@Path("/{id}")
	public Barber getBarber(@PathParam("id") int idt) {
		Barber barber = getDao().findByIdt(idt);
		if (barber == null) {
			throw new WebApplicationException(404);
		}
		return barber;
	}

	@GET
	public List<Barber> getAllBarber(@QueryParam("q") String query) {
		if (query != null) {
			System.out.println("query : " + query);
			return getDao().search("%"+query+"%");
		}
		return getDao().listerBarbers();
	}
	
	@GET
	@Path("/login")
	public Barber login(@QueryParam("login") String login, @QueryParam("mdp") String mdp)
	{
		return null;
	}
}

