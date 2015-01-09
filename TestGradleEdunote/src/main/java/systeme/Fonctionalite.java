package systeme;

import java.io.FileNotFoundException;
import java.util.*;

import personnes.Etudiant;
import personnes.Utilisateur;
import composants.Matiere;

public class Fonctionalite {

	public static Utilisateur connexion() throws FileNotFoundException
	{
		Utilisateur user = null;
		int choix;
		Affichage.afficherEntete();
		choix = Affichage.demanderUtilisateur();
		if (choix == UsineUtilisateur.ETUDIANT || choix == UsineUtilisateur.PROFESSEUR)
			user = Affichage.choixUtilisateur(choix);
		
		return user;
	}
	
	public static float calculResultatEleve(ArrayList<Matiere> tabMatieres) 
	{
		float moyenne =0, coefficient=0;
		for (Matiere m: tabMatieres)
		{
			moyenne += m.getMoyenne() * m.getCoefficient();
			coefficient += m.getCoefficient();
		}
		moyenne /= coefficient;
		moyenne = (float)((int)(moyenne*10))/10;
		return moyenne;
	}
	
}
