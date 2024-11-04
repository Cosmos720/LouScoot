package Model;

import java.util.*;

/**
 * La classe {@code Marque} permet de définir la marque d'un scooter
 */
public class Marque {

    /**
     * Constructeur d'un objet {@code Marque}
     * @param n le nom de la marque
     */
    public Marque(String n) {
        nom=n;
    }
    

    /**
     * Le nom de la marque
     */
    private String nom;

    /**
     * La liste des modeles de scooter de cette marque
     */
    private Vector<Modele> listModele= new Vector<Modele>();


    /**
     * Permet d'obtenir le nom de la marque
     * @return le nom de la marque
     */
    public String getNom(){
        return nom;
    }

    /**
     * Permet de recuperer la liste des modeles de scooter de la marque
     * @return la liste des modeles de scooter de la marque
     */
    public Vector<Modele> getListModele(){
        return listModele;
    }


    /**
     * Permet d'ajouter un modele
     * @param m Le modele à ajouter
     */
    public void addModele(Modele m){
        listModele.add(m);
    }


    /**
     * Permet de représenter l'objet {@code Marque} sous la forme d'une chaine de caractère
     * @return le nom de la marque
     */
    public String toString(){
        return nom;
    }
}
