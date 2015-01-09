package composants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Matiere implements Serializable {
	
	private String nom;
	private float coefficient;
	private ArrayList <Note> tabNotes;
	
	
	public Matiere(String s, float coef){
		this.nom = s;
		this.coefficient = coef;
		this.tabNotes = new ArrayList<Note>();
	}
	
	public void init(){ //saisie de notes
		boolean boucle = true;
		Scanner input = new Scanner(System.in);
		while(boucle){
			Note note = new Note();
			note.init();
			this.tabNotes.add(note);
			
			System.out.println(" 		Voulez-vous arreter de saisir des notes ? Si oui taper 1 ");
			
			int reponse = input.nextInt();
			if(reponse == 1){
				boucle = false;
			}
			
		}	
	}
	
	
	public float getMoyenne() {
		float moyenne =0, coefficient =0;
		for (Note n: tabNotes)
		{
			moyenne += n.getNombre() * n.getCoefficient();
			coefficient += n.getCoefficient();
		}
		moyenne /= coefficient;
		moyenne = (float)((int)(moyenne*10))/10;
		return moyenne;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}
	public ArrayList<Note> getTabNotes() {
		return tabNotes;
	}
	public void setTabNotes(ArrayList<Note> tabNotes) {
		this.tabNotes = tabNotes;
	}
}
