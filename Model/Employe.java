package Model;

import java.util.*;

/**
 * La classe {@code Employe} permet de créer un employe pouvant effectuer des locations
 */
public class Employe extends Personne {

    /**
     * Constructeur d'un objet {@code Employe}
     * @param n Le nom de l'employe
     * @param p Le prénom de l'employe
     * @param m Le magasin auquel appartient cet employe
     */
    public Employe(String n, String p, Magasin m) {
        super(n,p);
        m.addEmploye(this);         //Permet d'ajouter l'objet employe à la liste des employes du magasin
    }


    /**
     *Liste des locations que l'employé à effectuer
     */
    private Vector<Location> listLoc=new Vector<Location>();


    /**
     * Permet d'ajouter des location à la liste des locations effectuée par l'employé
     * @param l La location à ajouter
     */
    public void addLoc(Location l){
        listLoc.add(l);
    }
    
    /**
     * Permet de récuperer la liste des locations effectuée par l'employé
     * @return la liste des locations effectuée par l'employé
     */
    public Vector<Location> getListLoc(){
        return listLoc;
    }
}