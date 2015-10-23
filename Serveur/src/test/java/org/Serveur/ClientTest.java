package org.Serveur;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import bdd.Client;
import bdd.Init;

public class ClientTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new Api();
	}
	
	@Before
	public void init() {
		Init.getInstance().initTables();
	}
	
	@Test
	public void should_return_an_id_for_new_client(){
		Client client = new Client();
		client.setNom("foo");
		Entity<Client> clientEntity = Entity.entity(client,
				MediaType.APPLICATION_JSON);
		Client savedClient = target("/client").request().post(clientEntity)
				.readEntity(Client.class);
		assertEquals(1, savedClient.getIdt());
	}
	
	@Test
	public void should_return_good_client() {
		Client client = new Client();
		client.setNom("foobar");
		Entity<Client> clientEntity = Entity.entity(client,
				MediaType.APPLICATION_JSON);
		Client savedClient = target("/client").request().post(clientEntity)
				.readEntity(Client.class);

		Client readClient = target("/client/" + savedClient.getIdt()).request()
				.get(Client.class);
		assertEquals("foobar", readClient.getNom());
	}
	

	@Test(expected=WebApplicationException.class)
	public void should_return_404_when_client_does_not_exist() {
		
		Client readClient = target("/client/120").request()
				.get(Client.class);
		assertEquals("foobar", readClient.getNom());
	}
	
}
