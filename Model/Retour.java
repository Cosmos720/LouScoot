package Model;

import java.util.*;

/**
 * La classe {@code Retour} permet de définir le retour d'une location
 */
public class Retour{

    /**
     * Constructeur de l'objet {@code Retour}
     * @param km les km parcouru lors de la location du scooter jusqu'au retour
     * @param r date du retour
     * @param l location dont on veut faire le retour
     * @param etat etat du scooter au retour
     */
    public Retour(int km, Calendar r, Location l, Etat etat) {
        this.km=km;
        dateR=r;
        location=l;
        this.etat=etat;
        location.getScooter().setEtat(etat);
        location.getScooter().addKm(km);
    }


    /**
     * Les km parcouru lors de la location du scooter jusqu'au retour
     */
    private int km;

    /**
     * Date du retour
     */
    private Calendar dateR;

    /**
     * La location dont on fais le retour
     */
    private Location location;

    /**
     * L'etat du scooter au retour
     */
    private Etat etat;


    /**
     * Permet de calculer le prix à payer lors du retour du scooter
     * @return Prix à payer
     */
    public int PrixFinal(){
        int prixBase=location.getScooter().getPrixBase();
        int prix,penalite = 0,retard = 0,km = 0;
        if(dateR.after(location.getDateF())){
            Date r=dateR.getTime();
            Date f=location.getDateF().getTime();
            retard = (int) ((r.getTime()-f.getTime())/(1000*60*60*24)); //1 jour en ms
        }
        if((penalite=etat.getEtat() - location.getEtat())<=1){
            penalite=0;
        }
        km=this.km - location.getLimitKm();
        prix = prixBase + penalite*100 + retard*(prixBase*5/100) + km;  //prix de base + 100€ * le nombre de niveau d'etat de different par rapport au début de la location + 5% du prix de base en plus par jour de retard + 1€ par kilometre en trop
        return prix;
    }
}