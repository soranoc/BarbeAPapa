package org.Serveur;

import org.skife.jdbi.v2.DBI;
import org.sqlite.SQLiteDataSource;

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
			instance.initExemples();
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

	public ClientDao getClientDao() {
		return initClientDao();
	}

	public BarberDao initBarberDao() {
		return dbi.open(BarberDao.class);
	}

	public BarberDao getBarberDao() {
		return initBarberDao();
	}
	
	public RdvDao initRdvDao() {
		return dbi.open(RdvDao.class);
	}

	public RdvDao getRdvDao() {
		return initRdvDao();
	}

	private void initTables() {
		ClientDao cDao = getClientDao();
		cDao.dropClientTable();
		cDao.createClientTable();
		cDao.close();

		BarberDao bDao = getBarberDao();
		bDao.dropBarberTable();
		bDao.createBarberTable();
		bDao.close();
		
		RdvDao rDao = getRdvDao();
		rDao.dropRdvTable();
		rDao.createRdvTable();
		rDao.close();
	}

	public void initExemples() {
		exempleClient();
		exempleBarber();
	}

	private void exempleClient() {
		ClientDao cDao = getClientDao();

		cDao.insert(new Client(-1, null, "Fabian", "Avelin",
				"24 rue du grand poney", "59000", "Lille", "avelinf@gmail.com",
				"avelinf", "01/06/1995", "0612141518"));
		cDao.insert(new Client(-1, null, "Clément", "Sorano",
				"33 rue du Maréchal Citron", "59000", "Lille",
				"clement.sorano@wanadoo.fr", "soranoc", "14/06/1991", "0642424242"));
		cDao.insert(new Client(-1, null, "Max", "Cobol", "2 rue du gfi",
				"83000", "Toulon", "cobolm@gmail.com", "cobolm", "12/12/1992",
				"0610001000"));

		cDao.close();
	}

	private void exempleBarber() {
		BarberDao bDao = getBarberDao();

		bDao.insert(new Barber(-1, "http://www.taillersabarbe.fr/wp-content/uploads/2015/06/barbe-Nicolas-II.jpg", "Axel", "Monnier", "Mousta'shop",
				"www.moustashop.fr", "26 Avenue du colonel Moutarde", "12121",
				"Lelle", "barbapapatest1@gmail.com", "bptest1", "17/01/1994",
				"0606060606", null,
				"J'aime les grosses moustaches bien stylées.",
				"moustashop.facebook.com", null, null, null,
				"Coiffeur/Barbier", true));
		bDao.insert(new Barber(-1, "http://www.taillersabarbe.fr/wp-content/uploads/2015/06/barbe-Nicolas-II.jpg", "Th�o", "Ange", "Séville",
				"www.seville.fr", "37 rue paumée dans un coin", "32100",
				"Marrant-City", "angetheo@gmail.com", "anget", "20/20/2020",
				"06010003030", null,
				"La barbe, c'est barbant. Lol.",
				"seville.facebook.com", null, null, null,
				"Barbier", true));

		bDao.close();
	}
}