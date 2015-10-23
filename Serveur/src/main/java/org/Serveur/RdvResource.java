package org.Serveur;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/rdv")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RdvResource {

	@POST
	public Rdv createRdv(Rdv rdv) {
		int id = Init.getInstance().getRdvDao().insert(rdv);
		rdv.setIdt(id);
		return rdv;
	}
	
	@GET
	@Path("/{id}")
	public Rdv getRdv(@PathParam("id") int idt) {
		Rdv rdv = Init.getInstance().getRdvDao().findByIdt(idt);
		if (rdv == null) {
			throw new WebApplicationException(404);
		}
		return rdv;
	}

    	@GET
	public List<Rdv> getRdvs(@QueryParam("idBarber") String idBbarbier, @QueryParam("client") String client) {
		if (barbier != null) {
		    return getDao().listerRdvByBarber(Interger.valueof(idBarbier);
		}
		return getDao().listerBarbers();
	}

}
