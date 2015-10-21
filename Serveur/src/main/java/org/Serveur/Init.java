import mainpack.Items.Client;
import mainpack.Items.Groupe;
import mainpack.Items.Produit;
import mainpack.Items.Promo;
import mainpack.Items.Service;

import org.skife.jdbi.v2.DBI;
import org.sqlite.SQLiteDataSource;

import com.adopt.bdd.ClientDao;
import com.adopt.bdd.GroupeDao;
import com.adopt.bdd.LikeDao;
import com.adopt.bdd.ProduitDao;
import com.adopt.bdd.PromoDao;
import com.adopt.bdd.ServiceDao;
import com.adopt.bdd.UtilisateurDao;

public class Init {

	private static Init instance = null;
	private static DBI dbi;

	private Init() {

	}

	public static synchronized Init getInstance() {
		if (instance == null) {
			instance = new Init();
			instance.initInit();
			instance.initTables();
			//instance.initExemples();
		}
		return instance;
	}

	protected void initInit() {
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:" + System.getProperty("java.io.tmpdir")
				+ System.getProperty("file.separator") + "data.db");
		dbi = new DBI(ds);
	}

	public ClientDao initClientDao() {
		return dbi.open(ClientDao.class);
	}

	public UtilisateurDao initUtilisateurDao() {
		return dbi.open(UtilisateurDao.class);
	}

	public UtilisateurDao getUtilisateurDao() {
		return initUtilisateurDao();
	}

	private void initTables() {
		ClientDao clientDao = getClientDao();
		clientDao.dropClientTable();
		clientDao.createClientTable();
		clientDao.close();

		getProduitDao().dropProductTable();
		getProduitDao().createProductTable();

		getServiceDao().dropServiceTable();
		getServiceDao().createServiceTable();

		getPromoDao().dropPromoTable();
		getPromoDao().createPromoTable();

		getLikeDao().dropLikeTable();
		getLikeDao().createLikeTable();

		getUtilisateurDao().dropUtilisateurTable();
		getUtilisateurDao().createUtilisateurTable();

		GroupeDao groupeDao = getGroupeDao();
		groupeDao.dropGroupeTable();
		groupeDao.createGroupeTable();
		groupeDao.close();
	}

	/*public void initExemples() {
		exempleClient();
		exempleProduit();
		exemplePromo();
		exempleService();
		exempleGroupe();
	}

	private void exempleClient() {
		ClientDao cd = getClientDao();
		cd.insert(new Client(-1, null, "Fabian", "AVELIN", "Adopt-1-com", null,
				"24 rue du grand poney", "59000", "Lille", "avelinf@gmail.com",
				"avelinf", "01/06/1995", "0612141518", "0404040404",
				"Etudiant", "Informatique", "J'aime beaucoup ce que l'on fait avec le DAO",
				"http://facebook/avelinf", "http://twitter/avelinf", null,
				null, "service", "dev", true));
		cd.insert(new Client(-1, null, "Clément", "SORANO", "Adopt-1-com", null,
				"33 rue du Maréchal Citron", "59000", "Lille", "soranoc@gmail.com",
				"soranoc", "14/06/1991", "0633475874", "0404040404",
				"Etudiant", "Informatique", "C'est le bootstrap qui me donne du courage",
				"http://facebook/soranoc", "http://twitter/soranoc", null,
				null, "service", "dev", true));
		cd.insert(new Client(-1, null, "Théo", "ANGE", "Adopt-1-com", null,
				"5 rue du dindon", "59000", "Lille", "anget@gmail.com",
				"anget", "31/07/1995", "0606060606", "0404040404",
				"Etudiant", "Informatique", "Ce que j'aime dans l'informatique, c'est le DAO",
				"http://facebook/anget", "http://twitter/anget", null,
				null, "service", "dev", true));
		cd.insert(new Client(-1, null, "Bourbie", "Rito", "Bourbie & co", null,
				"18 rue du pingouin", "59000", "Lille", "bourbie@gmail.com",
				"bourbue", "01/01/2015", "0606060606", "0404040404",
				"Bourbiste", "Bourbe", "Blblblblblb",
				"http://facebourbe/bourbie", "http://twitter/bourbie", null,
				null, "service", "talent", true));
		cd.close();
	}

	private void exempleProduit() {
		ProduitDao pd = getProduitDao();
		pd.insert(new Produit(-1, "Chaise", null, "18EUR",
				"Jolie chaise rouge de jardin", 1, 1, false, "Mobilier"));
		pd.insert(new Produit(-1, "Bureau", null, "50EUR",
				"Joli bureau rouge de jardin", 1, 0, false, "Mobilier"));
		pd.insert(new Produit(-1, "Lampe", null, "10EUR",
				"Jolie lampe rouge de jardin", 1, 0, false, "Mobilier"));
		pd.insert(new Produit(-1, "Jambon", null, "20EUR",
				"Joli jambon rouge de jardin", 1, 0, false, "Mobilier"));
		pd.insert(new Produit(-1, "Poulet", null, "1000EUR",
				"Jolie poulet rouge de compagnie", 1, 0, false, "Animaux"));
		pd.insert(new Produit(-1, "Poney", null, "273EUR",
				"Joli poney disco à paillettes de jardin", 1, 0, false,
				"Animaux"));
		pd.insert(new Produit(-1, "Pingouin", null, "10EUR",
				"Jolie pingouin bleu de cuisine", 1, 0, false, "Ustensiles"));
		pd.insert(new Produit(-1, "Paillon", null, "5EUR",
				"Joli paillon vert de compétition", 1, 0, false, "Mobilier"));
		pd.close();
	}

	private void exempleService() {
		ServiceDao sd = getServiceDao();
		sd.insert(new Service(-1, "Massage", null, "40EUR",
				"Massage plutot sympathique", 1, 2, false, "Bien-être"));
		sd.insert(new Service(-1, "Ménage", null, "20EUR",
				"Ménage plutot sympathique", 1, 0, false, "Entretien"));
		sd.insert(new Service(-1, "Restauration", null, "100EUR",
				"Resto plutot sympathique", 1, 0, false, "Nourriture"));
		sd.close();
	}

	private void exemplePromo() {
		PromoDao pd = getPromoDao();
		pd.insert(new Promo(-1, 1, -1, "14/06/2015", "12EUR",
				"Remise exceptionnelle sur les chaises de jardin"));
		pd.insert(new Promo(-1, -1, 1, "14/06/2015", "4EUR",
				"Remise exceptionnelle sur les massages de jardin"));
		pd.close();
	}

	private void exempleGroupe() {
		GroupeDao gd = getGroupeDao();
		gd.insert(new Groupe(-1, 2, -1, 10, "35EUR",
				"Remise sur les bureaux si vous venez nombreux!"));
		gd.close();
	}*/
}