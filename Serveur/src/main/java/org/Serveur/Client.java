package org.Serveur;

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
	 * @param entreprise
	 *            de l'entreprise ou du commer�ant
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
		String res = "� faire";
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

	public String getMdp() { // TODO : � enregistrer crypt�
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

}