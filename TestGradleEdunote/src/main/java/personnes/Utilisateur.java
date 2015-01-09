package personnes;

import java.io.Serializable;

public abstract class Utilisateur implements Serializable {
	
	private String nom;
	private String prenom;
	
	public Utilisateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Utilisateur(String nom, String prenom, String login, String password) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public abstract int menu();
	public abstract void executerMenu();
	
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
}
