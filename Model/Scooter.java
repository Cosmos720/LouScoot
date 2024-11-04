package Model;

import java.util.*;

/**
 * La classe {@code Scooter} définie les scooter qui seront à louer dans le magasin
 */
public class Scooter {

    /**
     * Constructeur de l'objet {@code Scooter}
     * @param ID ID du scooter
     * @param prix prix de base du scooter
     * @param m modele du scooter
     * @param d depot où le scooter ce situe
     */
    public Scooter(String ID, int prix, Modele m, Depot d) {
        numID=ID;
        km=0;
        prixBase=prix;
        modele=m;
        modele.addScoot(this);
        depot=d;
        depot.addScoot(this);
        etat=new Etat(1);
    }
    

    /**
     * Le numero d'identification du scooter
     */
    private String numID;

    /**
     * Le kilometrage du scooter
     */
    private int km;

    /**
     * Le prix de base du scooter
     */
    private int prixBase;

    /**
     * Le modele du scooter
     */
    private Modele modele;

    /**
     * Le depot dans lequel le scooter se situe
     */
    private Depot depot;

    /**
     *  Liste de location auquel le scooter à participé
     */
    private Vector<Location> listLoc=new Vector<Location>();

    /**
     * Etat du scooter
     */
    private Etat etat;

    
    /**
     * Renvoie la valeur du permis necessaire pour le scooter
     * @return la valeur du permis necessaire pour le scooter
     */
    public int getValPermis(){
        return modele.getPermis().getCC();
    }
    
    /**
     * Renvoie l'identifiant du scooter
     * @return identifiant du scooter
     */
    public String getID(){
        return numID;
    }
    
    /**
     * Renvoie les kilometrage du scooter
     * @return kilometrage du scooter
     */
    public int getKm(){
        return km;
    }
    
    /**
     * Renvoie le prix de base du scooter
     * @return prix de base du scooter
     */
    public int getPrixBase(){
        return prixBase;
    }
    
    /**
     * Renvoie le modele du scooter
     * @return modele du scooter
     */
    public Modele getModele(){
        return modele;
    }
    
    /**
     * Renvoie le depot où se trouve ce scooter
     * @return depot du scooter
     */
    public Depot getDepot(){
        return depot;
    }
    
    /**
     * Renvoie l'etat du scooter
     * @return l'etat du scooter
     */
    public Etat getEtat(){
        return etat;
    }
    
    /**
     * Renvoie la liste des locations auquel le scooter à participé
     * @return liste des locations auquel le scooter à participé
     */
    public Vector<Location> getListLoc(){
        return listLoc;
    }

    /**
     * Permet de modifier l'etat du scooter
     * @param e le nouvel etat du scooter
     */
    public void setEtat(Etat e){
        etat=e;
    }

    /**
     * Initialise le prix de base du scooter
     * @param prix prix de base du scooter
     */
    public void setPrixbase(int prix){
        prixBase=prix;
    }
    
    
    /**
     * Ajoute les km parcouru au km du scooter
     * @param km km ajouté au km du scooter
     */
    public void addKm(int km){
        this.km+=km;
    }

    /**
     * Ajout d'une location à la liste des locations auquel le scooter à participé
     * @param l la location à ajouté
     */
    public void addLoc(Location l){
        listLoc.add(l);
    }
    
    
    /**
     * Verifie si le scooter peut être louer au date precisé
     * @param d Date de debut de location du scooter voulu
     * @param f Date de fin de location du scooter voulu
     */
    public boolean compatible(Calendar d,Calendar f){
        boolean dispo = true;
        for(int i=0;i<listLoc.size();i++){
            dispo = dispo && listLoc.get(i).compatible(d,f);
        }
        return dispo;
    }
    
    
    /**
     * Permet de représenter l'objet {@code Scooter} sous la forme d'une chaine de caractère
     * @return la marque, le nom du modele et la couleur du scooter
     */
    public String toString(){
        return modele.getMarque() +" "+ modele.getNom()+" : "+modele.getCouleur();
    }
}