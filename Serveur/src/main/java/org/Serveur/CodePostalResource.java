package org.Serveur;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/cpdb")
@Produces(MediaType.APPLICATION_JSON)
public class CodePostalResource {

	private final InputStream fichier = getClass().getResourceAsStream(
			"../../villes_france.csv");

	private static CPDao dao = Init.getInstance().getCPDao();

	/**
	 * Permet d'envoyer les villes et les codes postaux à l'aide de la class App
	 * et de la classe CPDao
	 */
	public CodePostalResource() {
		dao.dropCpTable();
		dao.createCpTable();
		List<String> code = new ArrayList<String>();
		List<String> ville = new ArrayList<String>();
		try {
			InputStreamReader ipsr = new InputStreamReader(fichier);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				if (!ligne.substring(0,1).equals("#")) {
					System.out.println(ligne);
					String[] tab = ligne.split(";");
					System.out.println((tab[0]+tab[1]).toString());
					code.add(tab[0]);
					ville.add(tab[1]);
				}
			}
			br.close();
			dao.load(code, ville);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * getCp retourne une liste ville comprenant son nom et son code postal
	 * 
	 * @param name
	 *            correspond au code postal.
	 * @return Liste de ville
	 */
	@GET
	@Path("/{name}")
	public List<Ville> getCp(@PathParam("name") String name) {
		List<Ville> ville = dao.findByName(name);
		if (ville == null) {
			throw new WebApplicationException(404);
		}
		return ville;
	}

	/**
	 * getAllVill retourne toute les villes
	 * 
	 * @return liste de ville
	 */
	@GET
	public List<Ville> getAllVille() {
		return dao.all();
	}

}
