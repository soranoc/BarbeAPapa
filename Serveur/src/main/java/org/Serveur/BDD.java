
package mainpack;

import java.util.Random;

import mainpack.Items.Item;

import com.adopt.bdd.ClientDao;
import com.adopt.bdd.GroupeDao;
import com.adopt.bdd.ProduitDao;
import com.adopt.bdd.ServiceDao;

public class BDD {

	Init init;

	public BDD() {
		init = Init.getInstance();
	}
}