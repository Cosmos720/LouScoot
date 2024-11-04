package Controler;

import Model.*;
import Vue.*;

import java.awt.event.*;
import javax.swing.*;

/**
 * Controleur de la fenetre de création de scooter ou de dépot
 */
public class ScooterCtl2 implements ActionListener{

    /**
	 * Le magasin de location que l'on gere ,la fenetre que l'on controle ainsi que la permiere partie de la fenetre pour recuperer les informations à l'enregistrement d'un scooter
	 */
    Magasin magasin;
    FenScoot1 scoot1;
    FenScoot2 scoot2;

    /**
     * Constructeur de la partie 2 de la fenetre de création d'un scooter
     * @param m  Magasin dans lequel je veux enregistrer le scooter
     * @param s1 Fenetre de création d'un scooter partie 1 pour pouvoir recuperer les informations
     * @param s2 Fenetre de création d'un scooter partie 2 pour pouvoir recuperer les informations
     */
    public ScooterCtl2(Magasin m, FenScoot1 s1,FenScoot2 s2){
        magasin=m;
        scoot1=s1;
        scoot2=s2;
    }


	/**
	 * Action que l'on va effectué lorsque l'on va appuyé sur un bouton
	 */
    public void actionPerformed(ActionEvent e) {

        JButton pressed=((JButton)e.getSource());// Recupération du bouton appuyé
        
        if(pressed.getName()=="Annuler"){ //Si le bouton annulé est pressé, fenscoot1 se réaffiche ,pour modifier des info par exemple
            scoot1.setVisible(true);

        }else if(pressed.getName()=="Submit"){ //si submit est appuyé un scooter est crée
            Marque marque=magasin.createMarque(scoot1.getMarque()); //recupere la marque selectionée
            Modele modele=magasin.createModele(scoot1.getNom(),scoot1.getCouleur(),scoot1.getPermis(),marque); //recupere le modele selectionée
            new Scooter(scoot1.getID(), scoot1.getPrix(), modele , scoot2.getDepot()); //crée un scooter avec les informations precedente
            scoot1.dispose(); //ferme la fenetre scoot 1
        }
        
        scoot2.setVisible(false); //rends invisible la fenetre scoot2
        scoot2.dispose(); //ferme la fenetre scoot 2
    }
}