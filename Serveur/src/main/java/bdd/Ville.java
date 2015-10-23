package bdd;
public class Ville {
	private String cp;
	private String ville;

	public Ville () {
		
	}
	
	public Ville(String cp, String ville) {
		this.cp = cp;
		this.ville = ville;
	}
	

	public String getCp() {
		return cp;
	}
	

	public void setCp(String cp) {
		this.cp = cp;
	}
	

	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}

	public boolean equals(Object u) {
		return ville.equals(((Ville) u).ville);
	}
	

	public String toString() {
		return cp + ": " + ville;
	}


}
