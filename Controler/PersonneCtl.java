package Controler;

import Model.*;
import Vue.*;

import java.awt.event.*;
import javax.swing.*;

/**
 * Controleur de la fenetre de clients/employé
 */
public class PersonneCtl implements ActionListener{

    /**
	 * Le magasin de location que l'on gere et la fenetre que l'on controle
	 */
    private Magasin magasin;
    private FenPersonne fenetre;


    /**
	 * Constructeur du controleur des boutons de la fenetre d'enregistrement d'une personne dans le magasin
	 * @param m Le magasin de location
	 * @param f La fenetre d'enregistrement d'une personne que l'on va controler
	 */
    public PersonneCtl(Magasin m, FenPersonne f){
        magasin=m;
        fenetre=f;
    }


    /**
	 * Action que l'on va effectué lorsque l'on va appuyé sur un bouton
	 */
    public void actionPerformed(ActionEvent e){

        JButton pressed = ((JButton)e.getSource());//Le bouton sur lequel l'utilisateur à appuyer

        if(pressed.getName()=="Employe"){ //si le bouton employé est appuyé il crée un employé
            new Employe(fenetre.getNomE(), fenetre.getPrenomE(), magasin);

        }else if(pressed.getName()=="Client"){ //si le bouton client est appuyé il crée un client
            new Client(fenetre.getNomC(), fenetre.getPrenomC(), magasin, fenetre.getPermisC());
        }
        
        fenetre.setVisible(false);  //rends la fenetre non visible
        fenetre.dispose(); //ferme la fenetre
    } 
}
