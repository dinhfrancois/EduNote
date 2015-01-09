package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import composants.Matiere;
import composants.Note;
import personnes.*;
import systeme.*;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		ArrayList<Etudiant> tabUsers = new ArrayList<Etudiant>();
		ArrayList<Note> tabNotes = new ArrayList<Note>();
		ArrayList<Matiere> tabMatiere = new ArrayList<Matiere>();
		
		Etudiant u1 = new Etudiant("Dinh", "Francois");
		Etudiant u2 = new Etudiant("Chan", "Livio");
		Etudiant u3 = new Etudiant("Siva", "Garthi");
		Etudiant u4 = new Etudiant("Sandi","Marina");
		tabUsers.add(u1);
		tabUsers.add(u2);
		tabUsers.add(u3);
		tabUsers.add(u4);
		
		Note n1 = new Note(2, 15);
		Note n2 = new Note(1, 16);
		tabNotes.add(n1);
		tabNotes.add(n2);
		
		Matiere m1 = new Matiere("Maths", 2);
		m1.setTabNotes(tabNotes);
		Matiere m2 = new Matiere("Informatique", 3);
		m2.setTabNotes(tabNotes);
		tabMatiere.add(m1);
		tabMatiere.add(m2);

		u1.setTabMatiere(tabMatiere);
		u2.setTabMatiere(tabMatiere);
		u3.setTabMatiere(tabMatiere);
		u4.setTabMatiere(tabMatiere);
		*/
		while (true) {
			Utilisateur user = Fonctionalite.connexion();
			user.executerMenu();
			System.out.println("\n\n");
		}
		//Professeur moi = new Professeur("test","test",tabUsers);
		//System.out.println("");
		//moi.retirerEleve();
		//u4.afficherResultatEleve();
		
		//moi.saisieMatieresNotes(u1);
		//u4.afficherResultatEleve();
		
	}
}
