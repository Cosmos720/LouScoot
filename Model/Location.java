package Model;

import java.util.*;

/**
 * La classe {@code Location} permet de créer une location d'un scooter enter un client et un employe
 */
public class Location {

    /**
     * Constructeur d'un objet {@code Location}
     * @param d Date du début de la location
     * @param f Date de fin de la location
     * @param km Limite de kilometarge de la location
     * @param c Client effectuant la location
     * @param s Scooter loué
     * @param e Employe effectuant la location
     */
    public Location(Calendar d, Calendar f, int km, Client c, Scooter s, Employe e) {
        ID=String.valueOf(compteur);        //ID définie automatiquement grâce à un compteur s'incrementant à chaque nouvelle location permettant un ID différent pour chaque location
        compteur++;
        dateDeb=d;
        dateFin=f;
        limitKm=km;
        client=c;
        client.addLoc(this);                //Permet d'ajouter l'objet location à la liste des locations du client
        scooter=s;
        scooter.addLoc(this);               //Permet d'ajouter l'objet location à la liste des locations du scooter
        employe=e;
        employe.addLoc(this);               //Permet d'ajouter l'objet location à la liste des locations de l'employe
        etat=s.getEtat();
    }


    /**
     * compteur de location qui s'incremente à chaque nouvelle location pour créer les ID de chaque location
     */
    private static int compteur=0;

    /**
     * Date du debut de la location
     */
    private Calendar dateDeb;

    /**
     * Date prévu de fin de la location
     */
    private Calendar dateFin;
   
    /**
     * Identifiant de la location
     */
    private String ID;

    /**
     * Limite de Km choisi par le client
     */
    private int limitKm;

    /**
     * Client qui effectue la location
     */
    private Client client;

    /**
     * Scooter qui va être louer
     */
    private Scooter scooter;

    /**
     * Employé qui effectue la location
     */
    private Employe employe;

    /**
     * Etat du scooter
     */
    private Etat etat;

    /**
     * Retour de la location
     */
    private Retour retour=null;


    /**
     * Permet de créer le retour de la location 
     * @param km km effectué pendant la location au retour
     * @param d date du retour
     * @param etat etat du scooter au retour
     */
    public void addRetour(int km, Calendar d, Etat etat){
        retour=new Retour(km,d,this,etat);
    }

    /**
     * Permet de récuperer le retour de la location
     * @return Retour de la location
     */
    public Retour getRetour(){
        return retour;
    }

    /**
     * Renvoie la date de début de location
     * @return la date de début de loc
     */
    public Calendar getDateD(){
        return dateDeb;
    }

    /**
     * Renvoie la date de fin de location prévu
     * @return la date de fin de location prévu
     */
    public Calendar getDateF(){
        return dateFin;
    }

    /**
     * Renvoie la limite de km prévu
     * @return limite de km
     */
    public int getLimitKm(){
        return limitKm;
    }

    /**
     * Renvoie le client qui a effectué une location
     * @return le client
     */
    public Client getClient(){
        return client;
    }

    /**
     * Renvoie le scooter de la location
     * @return le scooter
     */
    public Scooter getScooter(){
        return scooter;
    }

    /**
     * Renvoie l'employé qui effectue une location
     * @return l'employé
     */
    public Employe getEmploye(){
        return employe;
    }
    /**
     * Renvoie le niveau de l'etat du scooter au debut de la location
     * @return etat du scooter
     */
    public int getEtat(){
        return etat.getEtat();
    }

    /**
     * Renvoie l'ID de la location
     * @return ID de la location
     */
    public String getID(){
        return ID;
    }


    /**
     * Permet de verifier si un scooter est disponible pendant la durée demandée 
     * @param d Date de debut de location demandée
     * @param f Date de fin de location demandée
     */
    public boolean compatible(Calendar d,Calendar f){
        return !((d.after(dateDeb) && d.before(dateFin)) || (f.after(dateDeb) && f.before(dateFin)) || (dateDeb.after(d) && dateDeb.before(f)) || (d==dateDeb && f==dateFin));
    }
    

    /**
     * Permet de représenter l'objet {@code Location} sous la forme d'une chaine de caractère 
     * @return l'ID de location, l'employé qui l'a effectué, le client qui a effectué la location, le scooter loué, la date de debut et de fin de location et si il a été retourné ou non
     */
    public String toString(){
        return "Employe: " + employe + "  ID: " + ID +"  Client: "+client+"  Scooter: "+scooter+"  Début: "+dateDeb.get(Calendar.DATE)+"/"+
        (dateDeb.get(Calendar.MONTH)+1)+"/"+dateDeb.get(Calendar.YEAR)+"  Fin: "+dateFin.get(Calendar.DATE)+"/"+(dateFin.get(Calendar.MONTH)+1)+"/"+
        dateFin.get(Calendar.YEAR)+"  limite km: "+limitKm+"km  "+((retour!=null)?("est retourné"):("n'est pas retourné"));
    }
}