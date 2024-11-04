package Model;

import java.util.*;

/**
 * La classe {@code Modele} permet de définir le modele d'un scooter
 */
public class Modele {

    /**
     * Constructeur d'un objet {@code Modele}
     * @param n le nom du modele
     * @param c la couleur du modele
     * @param p le permis necessaire pour conduire ce modele
     * @param m la marque de ce modele
     */
    public Modele(String n, String c, Permis p, Marque m) {
        nom=n;
        couleur=c;
        permis=p;
        marque=m;
        marque.addModele(this);         //Permet d'ajouter l'objet modele à la liste des modeles de la marque
    }
    

    /**
     * le nom du modele
     */
    private String nom;

    /**
     * la couleur du modele
     */
    private String couleur;

    /**
     * Contient tout les scooter de ayant ce modele
     */
    private Vector<Scooter> listScoot=new Vector<Scooter>();

    /**
     * Permis necessaire à la conduite de ce modele de scooter
     */
    private Permis permis;

    /**
     * La marque de ce modele
     */
    private Marque marque;


    /**
     * Permet d'obtenir le permis necessaire à la conduite de ce modele
     * @return le permis necessaire
     */
    public Permis getPermis(){
        return permis;
    }

    /**
     * Permet de recuperer le nom du modele
     * @return le nom du modele
     */
    public String getNom(){
        return nom;
    }
    
    /**
     * Permet de recuperer la couleur du modele
     * @return la couleur du modele
     */
    public String getCouleur(){
        return couleur;
    }
    
    /**
     * Permet de recuperer la marque du modele
     * @return la marque du modele
     */
    public Marque getMarque(){
        return marque;
    }
    
    /**
     * Permet de recuperer la liste des scooter ayant ce modele
     * @return la liste des scooter ayant ce modele
     */
    public Vector<Scooter> getListScoot(){
        return listScoot;
    }

    
    /**
     * Permet d'ajouter un scooter à la liste de scooter ayant ce modele
     * @param s le scooter à ajouté
     */
    public void addScoot(Scooter s){
        listScoot.add(s);
    }
}