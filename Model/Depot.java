package Model;

import java.util.*;

/**
 * La classe {@code Depot} représente un depot de scooter
 */
public class Depot {

    /**
     * Constructeur d'un objet {@code Depot}
     * @param n Le nom du Dépot
     * @param nb La taille du Dépot
     * @param m Le magasin auquel appartient le Dépot
     */
    public Depot(String n, int nb, Magasin m) {
        nom=n;
        taille=nb;
        magasin=m;
        magasin.addDepot(this);                 //Permet d'ajouter l'objet depot à la liste des depots du magasin
        listScoot= new Vector<Scooter>(taille);
    }


    /**
     *  Nom du dépot 
     */
    private String nom;

    /**
     *  Taille du dépot
     */
    private int taille;

    /**
     * Liste des scooter du dépot
     */
    private Vector<Scooter> listScoot;

    /**
     * Magasin auquel le dépot appartient
     */
    private Magasin magasin;


    /**
     * Permet d'ajouter un scooter dans le dépot si la taille de ce dernier est suffisante
     * @param s le scooter a ajouter
     */
    public void addScoot(Scooter s){
        if(listScoot.size()<taille){
            listScoot.add(s);
        } else {
            System.out.println("Le depot"+ nom + "est complet");
        }
    }

    /**
     * Renvoie la liste des scooter
     * @return la liste des scooter
     */
    public Vector<Scooter> getListScoot(){
        return listScoot;
    }
    /**
     * Renvoie un scooter qui est dans la listScoot a un indice donné
     * @param x l'indice du scooter à chercher dans la liste des scooter du dépot
     * @return le scooter à l'indice x
     */
    public Scooter getScoot(int x){
        return listScoot.get(x);
    }
    /**
     * Renvoie la taille du dépot
     * @return la taille du dépot
     */
    public int getTaille(){
        return taille;
    }
    

    /**
     * Permet de représenter l'objet {@code Depot} sous la forme d'une chaine de caractère 
     * @return le nom du dépot et sa taille
     */
    public String toString(){
        return nom+ " : " +(String.valueOf(taille-listScoot.size()));
    }
}