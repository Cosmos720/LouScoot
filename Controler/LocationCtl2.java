package Controler;

import Model.*;
import Vue.*;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Controleur de la fenetre de création d'une location
 */
public class LocationCtl2 implements ActionListener {

    /**
	 * Les deux partie de la fenetre de création d'une location pour pouvoir recuperer toutes les informations utiles à la création de cette derniere 
	 */
	private FenLocation1 location1;
    private FenLocation2 location2;
	
    /**
	 * Constructeur du controleur des boutons de la fenetre de location partie 2
	 * @param l1 Le fenetre de location partie 1 pour pouvoir recuperer toutes les informations
	 * @param l2 La fenetre de location partie 2 que l'on va controler
	 */
	public LocationCtl2(FenLocation1 l1,FenLocation2 l2){
		location1=l1;
        location2=l2;
    }


	/**
	 * Action que l'on va effectué lorsque l'on va appuyé sur un bouton
	 */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton pressed=((JButton)e.getSource());//Le bouton sur lequel l'utilisateur à appuyer

        /**
         * Recupération des parametres necessaire à la création d'un location
         */
        Scooter scooter=location2.getScoot();
        Calendar dateD=location1.getDateD();
        Calendar dateF=location1.getDateF();
        Employe employe=location1.getEmpLoc();
        Client client=location1.getCliLoc();
        int km=location1.getKmLoc();

        if(pressed.getName()=="Submit" && scooter.compatible(dateD,dateF) && (client.getPermis()>125 || client.getPermis()>=scooter.getValPermis())){ //verifie si les dates selectionné sont compatible avec le scooter et le permis du client compatible avec le scooter
            new Location(dateD, dateF, km, client, scooter, employe);
            location1.dispose(); //ferme la fenetre location 1
            location2.setVisible(false);//rends la fenetre location2 invisible
            location2.dispose();//ferme la fenetre location 2

        }else if(pressed.getName()=="Submit" && !scooter.compatible(dateD,dateF)){ //cas où le scooter n'est pas disponible aux dates voulu
            JOptionPane.showMessageDialog(location2, "La date de location pour ce scooter est indisponible","Date indisponible",JOptionPane.ERROR_MESSAGE); //error

        }else if(pressed.getName()=="Submit" && !(client.getPermis()>125 || client.getPermis()>=scooter.getValPermis())){//cas où le permis du client est insufisant pour conduire le scooter
            JOptionPane.showMessageDialog(location2, "Le client n'as pas le permis necessaire pour louer ce scooter","Permis insufisant",JOptionPane.ERROR_MESSAGE);//error
        
        }else if(pressed.getName()=="Annuler"){//Si bouton annulé est pressé, fenloc1 se raffiche pour modifier des info par exemple 
            location1.setVisible(true); //rends la fenetre location1 visible
            location2.setVisible(false);//rends la fenetre location2 invisible
            location2.dispose();//ferme la fenetre location2
        }
    }
}