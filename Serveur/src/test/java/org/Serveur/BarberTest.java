package org.Serveur;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

public class BarberTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new Api();
	}

	@Before
	public void init() {
		Init.getInstance().initTables();
	}

	@Test
	public void should_return_an_id_for_new_barber() {
		Barber barber = new Barber();
		barber.setNom("foo");
		Entity<Barber> barberEntity = Entity.entity(barber,
				MediaType.APPLICATION_JSON);
		Barber savedBarber = target("/barber").request().post(barberEntity)
				.readEntity(Barber.class);
		assertEquals(1, savedBarber.getIdt());
	}

	@Test
	public void should_return_good_barber() {
		Barber barber = new Barber();
		barber.setNom("foobar");
		Entity<Barber> barberEntity = Entity.entity(barber,
				MediaType.APPLICATION_JSON);
		Barber savedBarber = target("/barber").request().post(barberEntity)
				.readEntity(Barber.class);

		Barber readBarber = target("/barber/" + savedBarber.getIdt()).request()
				.get(Barber.class);
		assertEquals("foobar", readBarber.getNom());
	}
	

	@Test(expected=WebApplicationException.class)
	public void should_return_404_when_barber_does_not_exist() {
		
		Barber readBarber = target("/barber/120").request()
				.get(Barber.class);
		assertEquals("foobar", readBarber.getNom());
	}
}
