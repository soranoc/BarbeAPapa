package org.Serveur;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

public class RdvTest extends JerseyTest{
	
	@Override
	protected Application configure() {
		return new Api();
	}
	
	@Before
	public void init() {
		Init.getInstance().initTables();
	}
	
	@Test
	public void should_return_an_id_for_new_rdv(){
		Rdv rdv = new Rdv();
		rdv.setDate("test");
		Entity<Rdv> rdvEntity = Entity.entity(rdv,
				MediaType.APPLICATION_JSON);
		Rdv savedRdv = target("/rdv").request().post(rdvEntity)
				.readEntity(Rdv.class);
		assertEquals(1, savedRdv.getIdt());
	}
	
	@Test
	public void should_return_good_rdv() {
		Rdv rdv = new Rdv();
		rdv.setDate("test2");
		Entity<Rdv> rdvEntity = Entity.entity(rdv,
				MediaType.APPLICATION_JSON);
		Rdv savedRdv = target("/rdv").request().post(rdvEntity)
				.readEntity(Rdv.class);

		Rdv readRdv = target("/rdv/" + savedRdv.getIdt()).request()
				.get(Rdv.class);
		assertEquals("foobar", readRdv.getDate());
	}
	

	@Test(expected=WebApplicationException.class)
	public void should_return_404_when_rdv_does_not_exist() {
		
		Rdv readRdv = target("/rdv/120").request()
				.get(Rdv.class);
		assertEquals("foobar", readRdv.getDate());
	}
	
}
