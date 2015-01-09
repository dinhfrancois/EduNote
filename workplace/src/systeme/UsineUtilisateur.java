package systeme;

import java.io.*;
import java.util.Scanner;

import personnes.*;

public class UsineUtilisateur {
	
	public static final int ETUDIANT = 1;
	public static final int PROFESSEUR = 2;
	
	public static Utilisateur newUser(int type)
	{
		Scanner sc = new Scanner(System.in);
		String nom, prenom;
		Utilisateur user = null;
		
		System.out.print ("		Entrer un nom : ");
		nom = sc.next();
		System.out.print ("		Entrer un prenom : ");
		prenom = sc.next();

		if (type == ETUDIANT && saveUser(user = new Etudiant(nom, prenom), ETUDIANT))
			System.out.println("\n		Ajout de l'etudiant reussi.");
		if (type == PROFESSEUR && saveUser(user = new Professeur(nom, prenom), PROFESSEUR))
			System.out.print("\n		Vous pouvez maintenant vous connecter en tant que professeur.");
		
		return user;
	}
	
    public static boolean saveUser(Utilisateur user, int type) {

    	ObjectOutputStream fEcriture = null;
    	File dir = null;
    	if (type == UsineUtilisateur.ETUDIANT)
    		 dir = new File ("etudiant/");
    	else if (type == UsineUtilisateur.PROFESSEUR)
    		 dir = new File ("professeur/");
    	dir.mkdirs();
        String fichier = dir + "/" + user.getNom() + user.getPrenom() + ".txt";
        try
        {
            fEcriture = new ObjectOutputStream (new BufferedOutputStream (new FileOutputStream( new File(fichier))));
            fEcriture.writeInt(type);
            fEcriture.writeObject(user);
            fEcriture.close();
            
            return true;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public static Utilisateur loadUser(String fichier) {
        ObjectInputStream fLecture = null;
        Utilisateur user = null;
        int type;
        try
        {
            fLecture = new ObjectInputStream (new BufferedInputStream (new FileInputStream( new File(fichier))));

            type = fLecture.readInt();
            	
            if (type == ETUDIANT)
                user = (Etudiant)fLecture.readObject();
            else if (type == PROFESSEUR)
                user = (Professeur)fLecture.readObject();
                
            fLecture.close();
        }
        
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return user;
    }
	
}
