package org.Serveur;

public class Barber extends Item {

	private String photo;
	private String nom;
	private String prenom;
	private String entreprise;
	private String site;
	private String adresse;
	private String codePostal;
	private String ville;
	private String mail;
	private String mdp;
	private String dateNaiss;
	private String tel;
	private String fax;
	private String description; // Comment voyez-vous votre m�tier?
	private String facebook;
	private String twitter;
	private String linkedIn;
	private String googlePlus;
	private String typeDePrestation; // Produits, services ou les deux?
	private boolean valide;

	
	public Barber(){}

	public Barber(int idt, String photo, String prenom, String nom, String entreprise, String site, String adresse, String codePostal, String ville,
			String mail, String mdp, String dateNaiss, String tel, String fax, String description, String facebook,
			String twitter, String linkedIn, String googlePlus, String typeDePrestation, boolean valide) {
		super(idt);
		this.setPhoto(photo);
		this.setNom(nom);
		this.setEntreprise(entreprise);
		this.setPrenom(prenom);
		this.setSite(site);
		this.setAdresse(adresse);
		this.setCodePostal(codePostal);
		this.setVille(ville);
		this.setMail(mail);
		this.setMdp(mdp);
		this.setDateNaiss(dateNaiss);
		this.setTel(tel);
		this.setFax(fax);
		this.setDescription(description);
		this.setFacebook(facebook);
		this.setTwitter(twitter);
		this.setLinkedIn(linkedIn);
		this.setGooglePlus(googlePlus);
		this.setTypeDePrestation(typeDePrestation);
		this.setValide(valide);
	}

	
	public String toString() {
		return idt + "; " + nom + "; " + prenom + ";";
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
	
	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public boolean equals(Object u) {
		return nom.equals(((Barber) u).nom);
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getMdp() { // TODO : � enregistrer crypt�
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getGooglePlus() {
		return googlePlus;
	}

	public void setGooglePlus(String googlePlus) {
		this.googlePlus = googlePlus;
	}

	public String getTypeDePrestation() {
		return typeDePrestation;
	}

	public void setTypeDePrestation(String typeDePrestation) {
		this.typeDePrestation = typeDePrestation;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}