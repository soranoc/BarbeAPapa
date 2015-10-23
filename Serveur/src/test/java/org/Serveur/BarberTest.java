package org.Serveur;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
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
		Barber savedBarber = createBarber();

		Barber readBarber = target("/barber/" + savedBarber.getIdt()).request()
				.get(Barber.class);
		assertEquals("foobar", readBarber.getNom());
	}
	
	@Test
	public void should_return_2_barber() {
		createBarber();
		createBarber("footest");
		createBarber("bartest");
		List<Barber> barbers = target("/barber").queryParam("q", "foo").request().get(new GenericType<List<Barber>>(){});
		assertEquals(2, barbers.size());
	}

	private Barber createBarber() {
		return createBarber("foobar");	
	}
	
	private Barber createBarber(String entreprise){
			Barber barber = new Barber();
		barber.setEntreprise(entreprise);
		Entity<Barber> barberEntity = Entity.entity(barber,
				MediaType.APPLICATION_JSON);
		Barber savedBarber = target("/barber").request().post(barberEntity)
				.readEntity(Barber.class);
		return savedBarber;
	}

	@Test(expected=WebApplicationException.class)
	public void should_return_404_when_barber_does_not_exist() {
		
		Barber readBarber = target("/barber/120").request()
				.get(Barber.class);
		assertEquals("foobar", readBarber.getNom());
	}
	
	
}
