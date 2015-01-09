package personnes;

import java.util.ArrayList;
import java.util.Scanner;

import systeme.Affichage;
import systeme.UsineUtilisateur;
import composants.Matiere;

public class Etudiant extends Utilisateur{

	private ArrayList<Matiere> tabMatiere;
	
	public Etudiant(String nom, String prenom)
	{
		super(nom, prenom);
		this.setTabMatiere(new ArrayList<Matiere>());
	}
	
	public int menu()
	{
		Scanner sc = new Scanner(System.in);
		int choix;
		System.out.println (" 			**************************************************************			");
		System.out.println (" 			*		 	   MENU			             *");
		System.out.println (" 			*   1 - Visualiser mes notes                                 *			");
		System.out.println (" 			*   2 - Quitter                                              *			");
		System.out.println (" 			*                                                            *			");
		System.out.println (" 			**************************************************************			");
		do {
			System.out.print ("		Reponse : ");
			choix = sc.nextInt();
		} while (choix!=1 && choix !=2);
		
		if (choix == 1)
			Affichage.afficherResultatEleve(this);
		
		return choix;
	}
	
	public void executerMenu()
	{
		int choix;
		do {
			choix = this.menu();
		} while (choix!=2);
	}
	
	public void afficherResultatEleve()
	{
		System.out.println();
		Affichage.afficherMatieres(this.getTabMatiere());
		Affichage.afficherEleve(this);
		System.out.println();
	}
	
	public ArrayList<Matiere> getTabMatiere() {
		return tabMatiere;
	}

	public void setTabMatiere(ArrayList<Matiere> tabMatiere) {
		this.tabMatiere = tabMatiere;
	}

}
