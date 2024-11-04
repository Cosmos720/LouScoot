package Model;

import java.util.*;

/**
 * La classe {@code Client} représente un client qui peut effectuer une location
 */
public class Client extends Personne {

    /**
     * Constructeur d'un objet {@code Client}
     * @param n Le nom du client
     * @param pr Le prenom du client
     * @param m Le magasin auquel appartient le client
     * @param pe Le permis du client
     */
    public Client(String n, String pr, Magasin m, Permis pe) {
        super(n, pr);
        m.addClient(this);        //Permet d'ajouter l'objet client à la liste des clients du magasin
        permis=pe;
    }


    /**
     * Contient la liste des locations effectuées par le client
     */
    private Vector<Location> listLoc= new Vector<Location>();

    /**
     * Permis du client
     */
    private Permis permis;
    

    /**
     * Permet d'ajouter une location effectué par le client dans la liste des locations faites par le client
     * @param l La location à ajouter
     */
    public void addLoc(Location l){
        listLoc.add(l);
    }

    /**
     * Permet d'obtenir la valeur du permis du client
     * @return la valeur du permis du client
     */
    public int getPermis(){
        return permis.getCC();
    }

    /**
     * Permet de recuperer la liste des locations du client
     * @return La liste des locations du client
     */
    public Vector<Location> GetListLoc(){
        return listLoc;
    }

}