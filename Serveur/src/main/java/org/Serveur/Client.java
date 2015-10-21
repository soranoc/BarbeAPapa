package mainpack.Items;

/**
 * 
 * @author jourdail La classe Client permet de créer des clients ainsi que leur
 *         attributs. Les getters permettent de récupérer ces derniers.
 */

public class Client extends Item {

	private String photo;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String mail;
	private String mdp;
	private String dateNaiss;
	private String tel;

	/**
	 * Constructeur
	 * 
	 * @param id
	 *            du client
	 * @param nom
	 *            du client
	 * @param prenom
	 *            du client
	 * @param entite
	 *            de l'entreprise ou du commerçant
	 */
	
	public Client(){}

	public Client(int idt, String photo, String prenom, String nom, String adresse, String codePostal, String ville,
			String mail, String mdp, String dateNaiss, String tel) {
		super(idt);
		this.setPhoto(photo);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setCodePostal(codePostal);
		this.setVille(ville);
		this.setMail(mail);
		this.setMdp(mdp);
		this.setDateNaiss(dateNaiss);
		this.setTel(tel);
	}

	
	public String toString() {
		return idt + "; " + nom + "; " + prenom ;
	}

	public String renderHTML() {
		String res = "à faire";
		return res;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMdp() { // TODO : à enregistrer crypté
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	@Override
	public String getTitle() {
		return "<span class='glyphicon glyphicon-user'></span> "+prenom+" "+nom;
	}

	///Renvoie le nom de la table dans laquelle doit être stockée l'Item
	@Override
	public String getType() {
		return "clients";
	}

}