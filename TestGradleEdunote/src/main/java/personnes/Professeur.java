package personnes;

import java.util.*;
import java.util.Scanner;

import composants.Matiere;
import systeme.Affichage;
import systeme.UsineUtilisateur;

public class Professeur extends Utilisateur {

	private ArrayList<Etudiant> tabEtudiant = new ArrayList<Etudiant>() ;
	
	public Professeur(String nom, String prenom)
	{
		super(nom, prenom);
		this.setTabEtudiant(new ArrayList<Etudiant>());
	}
	
	public Professeur(String nom, String prenom, ArrayList <Etudiant> tab)
	{
		super(nom, prenom);
		this.setTabEtudiant(tab);
	}
	
	public int menu()
	{
		Scanner sc = new Scanner(System.in);
		int choix;
		System.out.println (" 			**************************************************************			");
		System.out.println (" 			*		 	   MENU			             *");
		System.out.println (" 			*   1 - Ajouter un etudiant                                  *			");
		System.out.println (" 			*   2 - Visualiser la liste des etudiants                    *			");
		System.out.println (" 			*   3 - Saisir des notes                                     *			");
		System.out.println (" 			*   4 - Quitter                                              *			");
		System.out.println (" 			*                                                            *			");
		System.out.println (" 			**************************************************************			");
		
		do {
			System.out.print ("		Reponse : ");
			choix = sc.nextInt();
		} while (choix!=1 && choix!=2 && choix!=3 && choix!=4);
		
		if (choix == 1)
		{
			tabEtudiant.add((Etudiant)UsineUtilisateur.newUser(UsineUtilisateur.ETUDIANT));
			UsineUtilisateur.saveUser(this, UsineUtilisateur.PROFESSEUR);
		}
		else if (choix == 2)
			Affichage.afficherResultatGroupe(this.getTabEtudiant());
		else if (choix == 3)
		{
			int i = 1;
			Scanner input = new Scanner(System.in);
			int choixEtudiant;
			System.out.println ("		Choisir l'etudiant a qui la note va etre saisie : ");
			for(Etudiant e : this.getTabEtudiant()){
				System.out.println("			Rang : " + i + " " + e.getNom() + " " + e.getPrenom());
				i++;
			}
			do {
				System.out.print (" 		Reponse : ");
				choixEtudiant = input.nextInt() -1;
			} while (choixEtudiant > this.getTabEtudiant().size() && choixEtudiant < 0);
			this.saisieMatieresNotes(this.getTabEtudiant().get(choixEtudiant));
			UsineUtilisateur.saveUser(this, UsineUtilisateur.PROFESSEUR);
			UsineUtilisateur.saveUser(this.getTabEtudiant().get(choixEtudiant), UsineUtilisateur.ETUDIANT);
			
		}
		return choix;
	}
	
	public void executerMenu()
	{
		int choix;
		do {
			choix = this.menu();
		} while (choix!=4);
	}
	
	public ArrayList<Etudiant> getTabEtudiant() {
		return tabEtudiant;
	}

	public void setTabEtudiant(ArrayList<Etudiant> tabEtudiant) {
		this.tabEtudiant = tabEtudiant;
	}
	
	public void saisieMatieresNotes(Etudiant e){
		boolean boucle = true;
		Scanner input = new Scanner(System.in);
		int i = 0;
		while(boucle){
			System.out.print(" 		Entrez matiere : ");
			String s = input.nextLine();
			System.out.print(" 		Entrez coefficient de cette matiere : ");
			float coef = input.nextFloat();
			Matiere matiere = new Matiere(s,coef);
			
			matiere.init();
			
			System.out.println(" 		Voulez-vous arreter de saisir des matiere ? Si oui taper 1 ");
			
			int reponse = input.nextInt();
			if(reponse == 1){
				boucle = false;
			}
			e.getTabMatiere().add(matiere);
			i++;
			s = null;
			input.nextLine();
		}	
	}
	
	public void retirerEleve(){
		int i = 1;
		Scanner input = new Scanner(System.in);
		for(Etudiant e : this.getTabEtudiant()){
			System.out.println(" 		Rang : " + i + " " + e.getNom() + " " + e.getPrenom());
			i++;
		}
		
		System.out.println(" 		Veuillez entrez le rang de l'etudiant a retirer de la liste : ");
		int reponse = 1 -  input.nextInt();
		this.getTabEtudiant().remove(reponse);
		this.getTabEtudiant().trimToSize();
		System.out.println(" 		Nouvelle liste etudiants");
		i = 1;
		
		for(Etudiant e : this.getTabEtudiant()){
			System.out.println(" 		Rang : " + i + " " + e.getNom() + " " + e.getPrenom());
			i++;
		}
	}
	
}
