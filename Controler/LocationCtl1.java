package Controler;

import Model.*;
import Vue.*;

import java.awt.event.*;
import javax.swing.*;

/**
 * Controleur de la fenetre de création de location/retour/resume
 */
public class LocationCtl1 implements ActionListener {

	/**
	 * Le magasin de location que l'on gere et la fenetre que l'on controle
	 */
	private Magasin magasin;
	private FenLocation1 location1;
	
	/**
	 * Constructeur du controleur des boutons de la fenetre de location partie 1
	 * @param m Le magasin de location
	 * @param l1 La fenetre de location partie 1 que l'on va controler
	 */
	public LocationCtl1(Magasin m,FenLocation1 l1){
		magasin=m;
		location1=l1;
    }


	/**
	 * Action que l'on va effectué lorsque l'on va appuyé sur un bouton
	 */
	@Override	
	public void actionPerformed(ActionEvent e) {

		JButton pressed=((JButton)e.getSource());//Le bouton sur lequel l'utilisateur à appuyer

		if(pressed.getName()=="Location" && location1.getKmLoc()>=0){//verifie si l'utilisateur a rentrer une limite de km et appuyer sur le bouton location, pour crée une location
			Marque marque=location1.getMarque();
			new FenLocation2("Location",marque,location1);
			location1.setVisible(false); //rends invisible la fenetre fenlocation1

		}else if(pressed.getName()=="Location" && !(location1.getKmLoc()>0)){	//cas où l'utilisateur n'as pas entré de limite de kilometrage lors de la location
			JOptionPane.showMessageDialog(location1, "Vous n'avez pas entré de limite de Km","Km manquant",JOptionPane.WARNING_MESSAGE);//Warning

		}else if(pressed.getName()=="Retour" && !(location1.getKmRet()>0)){	//cas où l'utilisateur n'as pas entré le kilometrage du scooter lors du retour
			JOptionPane.showMessageDialog(location1, "Vous n'avez pas entré de limite de Km","Km manquant",JOptionPane.WARNING_MESSAGE);//Warning

		}else if(pressed.getName()=="Retour" && location1.getKmRet()>=0){ 	//verifie si l'utilisateur a rentrer un km et appuyer sur le bouton retour, pour crée un retour
			int prix=magasin.createRetour(location1.getID(), location1.getKmRet(), location1.getEtat());
			if(prix>0){ 	//cas ou le prix a payer est positif, il s'affiche dans un pop up avec le prix à payer
				JOptionPane.showMessageDialog(location1, "Net à payer :"+prix,"Prix",JOptionPane.INFORMATION_MESSAGE);//Information
				location1.setVisible(false);	//rends invisible la fenetre fenlocation1
				location1.dispose();//ferme la fenetre fenlocation1
			}else{	//cas où la location est déjà retourné ou que la location est introuvable
				JOptionPane.showMessageDialog(location1, "Location introuvable/Location déjà retournée","Retour impossible",JOptionPane.ERROR_MESSAGE);//Error
			}
		}	
	}
}