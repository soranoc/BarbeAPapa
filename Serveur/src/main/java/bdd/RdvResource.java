package bdd;

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

	private RdvDao getDao() {
		return Init.getInstance().getRdvDao();
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
	public List<Rdv> getAllRdv(@QueryParam("idbarber") String idBarbier,
			@QueryParam("idclient") String idClient) {
		if (idBarbier != null) {
			return getDao().listerRdvByBarber(Integer.valueOf(idBarbier));
		} else if (idClient != null) {
			return getDao().listerRdvByClient(Integer.valueOf(idClient));
		}
		return null;
	}

//	@GET
//	public List<Rdv> getRdvs(@QueryParam("idBarber") String idBarbier,
//			@QueryParam("client") String idClient) {
//		if (idBarbier != null) {
//			return getDao().listerRdvByBarber(Integer.valueOf(idBarbier));
//		} else if (idClient != null) {
//			return getDao().listerRdvByClient(Integer.valueOf(idClient));
//
//		}
//		return null;
//	}

}
