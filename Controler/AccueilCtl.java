package Controler;

import Model.*;
import Vue.*;

import java.awt.event.*;
import javax.swing.*;

/**
 * Controleur de la fenetre de Accueil
 */
public class AccueilCtl implements ActionListener {

	/**
	 * Le magasin de location que l'on gere et la fenetre que l'on controle
	 */
	private Magasin magasin;
	private FenAccueil accueil;
	

	/**
	 * Constructeur du controleur des boutons de la fenetre d'accueil
	 * @param m Le magasin de location
	 * @param a La fenetre d'accueil que l'on va controler
	 */
	public AccueilCtl(Magasin m,FenAccueil a){
		magasin=m;
		accueil=a;
    }
	
	/**
	 * Action que l'on va effectué lorsque l'on va appuyé sur un bouton
	 */
	@Override 
	public void actionPerformed(ActionEvent e) {

		JButton pressed=((JButton)e.getSource());//Le bouton sur lequel l'utilisateur à appuyer
		
		if(pressed.getName()=="Location" && magasin.getListClient().size()>0 && magasin.getListEmploye().size()>0 && magasin.hasScooter()){// Verifie si en appuyant sur location, il y a un client, un employé et un scooter
			new FenLocation1("Location",magasin);

		}else if(pressed.getName()=="Location" && !(magasin.getListClient().size()>0)){  //si il n'y a pas de client crée un popup affiche qu'il faut en renseigné un pour aller sur location
			JOptionPane.showMessageDialog(accueil, "Il n'y a aucun client d'enregistrer","Aucun Client",JOptionPane.WARNING_MESSAGE);//Warning

		}else if(pressed.getName()=="Location" && !(magasin.getListEmploye().size()>0)){ //si il n'y a pas de employé crée un popup affiche qu'il faut en renseigné un pour aller sur location
			JOptionPane.showMessageDialog(accueil, "Il n'y a aucun employe d'enregistrer","Aucun Employe",JOptionPane.WARNING_MESSAGE);// Warning

		}else if(pressed.getName()=="Location" && !(magasin.hasScooter())){  //si il n'y a pas de scooter  créee un popup affiche qu'il faut en renseigné un pour aller sur location
			JOptionPane.showMessageDialog(accueil, "Il n'y a aucun scooter d'enregistrer","Aucun Scooter",JOptionPane.WARNING_MESSAGE);//Warning

		} else if(pressed.getName()=="Personne"){ //Pour acceder a la fenetre personne
			new FenPersonne("Personne",magasin);

		} else if(pressed.getName()=="Scooter"){ //Pour acceder a la fenetre scooter
			new FenScoot1("Scooter",magasin);
		}
	}

}
