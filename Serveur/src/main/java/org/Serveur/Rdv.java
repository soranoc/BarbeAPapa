package org.Serveur;

public class Rdv extends Item {

	private int idClient;
	private int idBarber;
	private String date;
	private String heure;

	
	public Rdv(){}

	public Rdv(int idt, int idClient, int idBarber, String date, String heure) {
		super(idt);
		this.setIdClient(idClient);
		this.setIdBarber(idBarber);
		this.setDate(date);
		this.setHeure(heure);
	}


	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.nom = nom;
	}

	public int getIdBarber() {
		return idBarber;
	}

	public void setIdBarber(String prenom) {
		this.prenom = prenom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

}