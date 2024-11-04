package Controler;

import Model.*;
import Vue.*;

import java.awt.event.*;
import javax.swing.*;

/**
 * Controleur de la fenetre de création de scooter ou de dépot
 */
public class ScooterCtl1 implements ActionListener{

    /**
	 * Le magasin de location que l'on gere et la fenetre que l'on controle
	 */
    Magasin magasin;
    FenScoot1 scoot1;

    /**
	 * Constructeur du controleur des boutons de la fenetre d'enregistrement d'un scooter ou d'un dépot dans le magasin de location
	 * @param m Le magasin de location
	 * @param s1 La fenetre d'enregistrement d'une personne partie 1 que l'on va controler
	 */
    public ScooterCtl1(Magasin m, FenScoot1 s1){
        magasin=m;
        scoot1=s1;
    }


	/**
	 * Action que l'on va effectué lorsque l'on va appuyé sur un bouton
	 */
    public void actionPerformed(ActionEvent e) {

        JButton pressed=((JButton)e.getSource());//Le bouton sur lequel l'utilisateur à appuyer

        if(pressed.getName()=="Scooter" && magasin.IdDispo(scoot1.getID()) && magasin.hasDepotFree() && scoot1.getPrix()>0){//verifie si  l'id, le depot et le prix est rempli pour faire une location
            new FenScoot2("Scooter", magasin ,scoot1);
            scoot1.setVisible(false); // rends invisible la fenetre si on a besoin de revenir dessus

        }else if(pressed.getName()=="Scooter" && !(magasin.IdDispo(scoot1.getID()))){ //cas où l'id du scooter est déjà reservé
            JOptionPane.showMessageDialog (scoot1, "L'ID de scooter rentré est déjà utiliser", "ID reservé", JOptionPane.ERROR_MESSAGE);//Error

        }else if(pressed.getName()=="Scooter" && !magasin.hasDepotFree()){ //cas où le magasin ne possède aucun dépot avec de la place de libre
            JOptionPane.showMessageDialog (scoot1, "Le magasin ne possède aucun dépot avec de la place de libre pour enregistrer un autre scooter", "Dépot Manquant", JOptionPane.WARNING_MESSAGE);//Warning

        }else if(pressed.getName()=="Scooter" && scoot1.getPrix()<0){ //cas où l'utilisateur n'as pas entré de prix
            JOptionPane.showMessageDialog (scoot1, "Vous n'avez pas donné de prix", "Prix Manquant", JOptionPane.WARNING_MESSAGE);//Warning

        }else if(pressed.getName()=="Depot" && scoot1.getTailleD()<0){ //cas où l'utilisateur n'as pas entré de taille
            JOptionPane.showMessageDialog (scoot1, "Vous n'avez pas donné de taille", "Taille Manquante", JOptionPane.WARNING_MESSAGE); //Warning

        }else if(pressed.getName()=="Depot" && scoot1.getTailleD()>0){ //verifie si l'utilisateur à rentré une taille de dépot et appuyé sur le bouton permettant la création d'un dépot
            new Depot(scoot1.getNomD(), scoot1.getTailleD(),magasin);
            scoot1.setVisible(false); // rends invisible la fenetre
            scoot1.dispose(); //ferme la fenetre 
        }
        
    }
    
}
