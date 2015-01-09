package systeme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import personnes.*;
import composants.Matiere;

public class Affichage {

	public static void afficherEntete()
	{
		System.out.println (" 			**************************************************************			");
		System.out.println (" 			*		 	 EDUNOTE			     *");
		System.out.println (" 			* Application de saisie de notes et de simulation de moyenne *			");
		System.out.println (" 			*                                         Version beta       *			");
		System.out.println (" 			**************************************************************			");
	}
	
	public static int demanderUtilisateur()
	{
		Scanner sc = new Scanner(System.in);
		int choix;
		System.out.println ("\n\n		Connexion en tant que : ");
		System.out.println (" 			1 - Etudiant     2 - Professeur");
		
		do {
			System.out.print ("		Reponse : ");
			choix = sc.nextInt();
			if (choix !=1 && choix !=2)
				System.out.println("		Choix inexistant, reconsidere ton choix.");
		} while (choix !=1 && choix !=2);
		
		return choix;
	}
	
	public static void connexionProfesseur()
	{
		Scanner sc = new Scanner(System.in);
		int choix; 
		System.out.println ("\n		1 - Professeur existant 	2 - Nouveau professeur");
		do {
			System.out.print ("		Reponse : ");
			choix = sc.nextInt();
		} while (choix!=1 && choix!=2);
		
		if (choix==2)
			UsineUtilisateur.newUser(UsineUtilisateur.PROFESSEUR);
	}
	
	public static Utilisateur choixUtilisateur(int choix) throws FileNotFoundException
	{
		String nom, prenom, fichier = null;
		boolean ok = false;
		Scanner sc = new Scanner(System.in);
		Utilisateur user = null;
		
		if (choix == UsineUtilisateur.ETUDIANT) {
			System.out.println ("\n\n		Connexion en tant que etudiant... ");
		}
		else if (choix == UsineUtilisateur.PROFESSEUR) {
			Affichage.connexionProfesseur();
			System.out.println ("\n\n		Connexion en tant que professeur... ");
		}
		
		do {
			System.out.print ("		Saisir votre nom : ");
			nom = sc.next();
			System.out.print (" 		Saisir votre prenom : ");
			prenom = sc.next();
			
			if (choix == UsineUtilisateur.ETUDIANT)
				fichier = "etudiant/"+ nom+prenom+".txt";
			else if (choix == UsineUtilisateur.PROFESSEUR)
				fichier = "professeur/"+ nom+prenom+".txt";
			
			File f = new File(fichier);
			
			if(f.exists() && !f.isDirectory())
			{
					System.out.println ("\n		Vous etes connecte ...\n");
					ok = true;
			}
			
		} while (!ok);
		
		if (ok)
		{
			if (choix == UsineUtilisateur.ETUDIANT)
				user = UsineUtilisateur.loadUser("etudiant/" + nom + prenom + ".txt");
			else if (choix == UsineUtilisateur.PROFESSEUR)
				user = UsineUtilisateur.loadUser("professeur/" + nom + prenom + ".txt");
		}
		return user;
	}
	
	
	public static int choixNouveau()
	{
		Scanner sc = new Scanner(System.in);
		int choix;
		
		System.out.println ("\n\n 			**************************************************************			");
		System.out.println ("			*       Bienvenue dans le monde d'EduNote ! Qui-es tu ?      *");
		System.out.println ("			*                1 - Etudiant     2 - Professeur             *");
		System.out.println (" 			**************************************************************			");
		
		do {
			System.out.print ("		Reponse : ");
			choix = sc.nextInt();
			if (choix !=1 && choix !=2)
				System.out.println("		Choix inexistant, reconsidere ton choix.");
		} while (choix !=1 && choix !=2);
		
		return choix;
	}
	
	public static void afficherMatieres(ArrayList<Matiere> tabMatieres)
	{
		System.out.print("\n		   |Eleve                |");
		for (Matiere m: tabMatieres) {
			String str;
			if (m.getNom().length() < 15)
			{
				str = m.getNom();
				for (int i=15-str.length(); i>0; i--)
					str += " ";
			}
			else
				str = m.getNom().substring(0, 15);
			System.out.print(str + "|");
		}
		if (tabMatieres.isEmpty())
			System.out.println("Aucun         |");
		else
			System.out.println("Moyenne        |");
	}
	
	public static void afficherEleve(Etudiant user)
	{
		String str = "		   |" + user.getNom() + " " + user.getPrenom();
		System.out.print(str);
		for (int i=25-str.length(); i>=0; i--)
			System.out.print(" ");
		System.out.print(" |");
		for (Matiere m: user.getTabMatiere()) {
			if(m.getMoyenne() < 10){
				System.out.print("            " + m.getMoyenne() + "|");
			}
			
			else{
				System.out.print("           " + m.getMoyenne() + "|");
			}
			
		}
		System.out.println("           " + Fonctionalite.calculResultatEleve(user.getTabMatiere()) + "|");
	}
	
	public static void afficherResultatEleve(Etudiant user)
	{
		System.out.println();
		Affichage.afficherMatieres(user.getTabMatiere());
		Affichage.afficherEleve(user);
		System.out.println();
	}
	
	public static void afficherResultatGroupe(ArrayList<Etudiant> tabEtudiant)
	{
		if (!tabEtudiant.isEmpty()) {
			System.out.println();
			Affichage.afficherMatieres(tabEtudiant.get(0).getTabMatiere());
			for (Etudiant e: tabEtudiant)
				afficherEleve(e);
			Affichage.afficherFooter(tabEtudiant);
			System.out.println();
		}
		else
			System.out.println("		Aucun etudiant est entre vos mains.\n");
	}
	
	public static void afficherFooter(ArrayList<Etudiant> tabEtudiant)
	{
		final int TAILLE = tabEtudiant.get(0).getTabMatiere().size();
		float[] tabRes = new float[TAILLE];
		float[] tabCoef = new float[TAILLE];
		float sommeCoef = 0;
		float resFinal =0;
		
		
		System.out.print("		   |             Moyenne |");
		
		for (int i=0; i<TAILLE; i++)
		{
			tabCoef[i] = tabEtudiant.get(0).getTabMatiere().get(i).getCoefficient();
			sommeCoef += tabCoef[i];
		}
		
		for (Etudiant e: tabEtudiant)
		{
			for (int i=0; i<TAILLE; i++)
				tabRes[i] += e.getTabMatiere().get(i).getMoyenne();
		}
		
		for (int i=0; i<TAILLE; i++)
		{
			tabRes[i] = (float)((int)(tabRes[i]*10))/10;
			resFinal += tabRes[i]*tabCoef[i];
			if (tabRes[i]<10)
				System.out.print("            " + tabRes[i] + "|");
			else
				System.out.print("           " + tabRes[i] + "|");
		}
		resFinal /= sommeCoef;
		resFinal = (float)((int)(resFinal*10))/10;
		if (resFinal<10)
			System.out.print("            " + resFinal + "|");
		else
			System.out.print("           " + resFinal + "|");
	}
}
