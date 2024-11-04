package Model;

import java.util.*;

/**
 * La classe {@code Magasin} represente le magasin qui loue les scooter aux clients
 */
public class Magasin {

    /**
     * Constructeur de magasin
     * @param n nom du magasin
     */
    public Magasin(String n) {
        nom=n;
    }


    /**
     * Le nom du magasin
     */
    private String nom;

    /**
     *  Liste des clients du magasin
     */
    private Vector<Client> listClient= new Vector<Client>();

    /**
     *  Liste des employés du magasin
     */
    private Vector<Employe> listEmploye= new Vector<Employe>();

    /**
     *  Liste des dépots du magasin
     */
    private Vector<Depot> listDepot= new Vector<Depot>();


        /**
     * Permet d'obtenir le nom du magasin
     * @return nom magasin
     */
    public String getNom(){
        return nom;
    }

    /**
     * Renvoie la liste d'employé du magasin
     * @return la liste d'employé
     */
    public Vector<Employe> getListEmploye(){
        return listEmploye;
    }

    /**
     * Renvoie la liste des clients du magasin
     * @return la liste des clients
     */
    public Vector<Client> getListClient(){
        return listClient;
    }

    /**
     * Renvoie la liste des dépots du magasin
     * @return la liste des dépots
     */
    public Vector<Depot> getListDepot(){
        return listDepot;
    }

    /**
     * Permet d'obtenir la liste des marques de tous les scooter possédé par le magasin
     * @return La liste de toutes les marques de scooter différentes enregistrées
     */
    public Vector<Marque> getListMarque(){
        Vector<Marque> list=new Vector<Marque>(10,1);
        for(int i=0;i<listDepot.size();i++){
            Depot Dep=listDepot.get(i);
            for(int j=0;j<Dep.getListScoot().size();j++){
                Marque mar=Dep.getScoot(j).getModele().getMarque();
                if(!list.contains(mar)){
                    list.add(mar);
                }
            }
        }
        return list;
    }

    /**
     * Permet d'obtenir la liste des états possible des scooters
     */
    public Vector<Etat> getListEtat(){
        Vector<Etat> list=new Vector<Etat>(5);
        for(int i=0;i<5;i++){
            list.add(new Etat(i));
        }
        return list;
    }

    /**
     * Permet d'obtenir la liste des permis 
     */
    public Vector<Permis> getListPermis(){
        Vector<Permis> list=new Vector<Permis>(4);
        list.add(new Permis(0));
        list.add(new Permis(50));
        list.add(new Permis(125));
        list.add(new Permis(200));
        return list;
    }

    /**
     * Permet d'obtenir la liste de toutes les locations effectuées dans ce magasin
     * @return
     */
    public Vector<Location> getListLoc(){
        Vector<Location> listLocation=new Vector<Location>();
        for(int i=0;i<listEmploye.size();i++){
            Employe emp=listEmploye.get(i);
            for(int j=0;j<emp.getListLoc().size();j++){
                Location loc=emp.getListLoc().get(j);
                listLocation.add(loc);
            }
        }
        return listLocation;
    }
    

    /**
     * Permet d'ajouter un dépot au magasin
     * @param d depot 
     */
    public void addDepot(Depot d){
        listDepot.add(d);
    }

    /**
     * Permet d'ajouter un client au magasin
     * @param c client
     */
    public void addClient(Client c){
        listClient.add(c);
    }

    /**
     * Permet d'ajouter un employé au magasin
     * @param e employé
     */
    public void addEmploye(Employe e){
        listEmploye.add(e);
    }


    /**
     * Permet de savoir si l'ID du scooter est déjà pris où non
     * @param ID l'ID de scooter dont on veut connaitre la disponibilité
     */
    public boolean IdDispo(String ID){
        for(int i=0;i<listDepot.size();i++){
            Depot Dep=listDepot.get(i);
            for(int j=0;j<Dep.getListScoot().size();j++){
                Scooter Scoot=Dep.getScoot(j);
                if(Scoot.getID().equals(ID)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Permet de savoir s'il existe au moins un dépot avec de la place de libre pour enregistrer un scooter
     * @return true s'il y a bien un dépot avec de la place
     */
    public boolean hasDepotFree(){
        for(int i=0;i<listDepot.size();i++){
            Depot dep=listDepot.get(i);
            if(dep.getTaille()>dep.getListScoot().size()){
                return true;
            }
        }
        return false;
    }

    /**
     * Permet de savoir s'il existe au moins un scooter d'enregistrer
     * @return true s'il existe au moins un scooter d'enregistrer
     */
    public boolean hasScooter(){
        for(int i=0;i<listDepot.size();i++){
            Depot Dep=listDepot.get(i);
            if(Dep.getListScoot().size()>0){
                return true;
            }
        }
        return false;
    }

    /**
     * Permet de savoir si une location à déjà été retourné ou non
     * @param Id L'id de la location dont on veut savoir si elle à un retour
     * @return La location si elle existe et qu'elle n'est pas encore retournée
     */
    public Location isReturned(String Id){
        for(int i=0;i<listClient.size();i++){
            Client cli=listClient.get(i);
            for(int j=0;j<cli.GetListLoc().size();j++){
                Location loc=cli.GetListLoc().get(j);
                if(loc.getID().equals(Id) && loc.getRetour()==null){
                    return loc;
                } else if(loc.getID().equals(Id) && loc.getRetour()!=null){
                    return null;
                }
            }
        }
        return null;
    }


    /**
     * Permet de crée une marque de scooter si elle n'existe pas encore
     * @param n
     */
    public Marque createMarque(String n){
        for(int i=0;i<listDepot.size();i++){
            Depot Dep=listDepot.get(i);
            for(int j=0;j<Dep.getListScoot().size();j++){
                Marque marque =Dep.getScoot(j).getModele().getMarque();
                if(marque.getNom().equals(n)){
                    return marque;
                }
            }
        }
        return (new Marque(n));
    }
    
    /**
     * Permet de crée un modele de scooter si il n'existe pas encore
     * @param n nom du scooter
     * @param c couleur du scooter
     * @param permis permis necessaire pour louer le scooter
     * @param m marque du scooter
     */
    public Modele createModele(String n, String c, Permis p, Marque m){
        for(int i=0;i<listDepot.size();i++){
            Depot Dep=listDepot.get(i);
            for(int j=0;j<Dep.getListScoot().size();j++){
                Modele modele =Dep.getScoot(j).getModele();
                if(modele.getNom().equals(n) && modele.getCouleur().equals(c) && modele.getPermis().equals(p) && modele.getMarque().equals(m)){
                    return modele;
                }
            }
        }
        return (new Modele(n,c,p,m));
    }

    /**
     * Permet de crée un retour
     * @param Id ID du scooter qui sera retourné
     * @param km km du scooter au moment du retour
     * @param etat État du scooter au moment du retour 
     * @return Le prix de la location au retour si la location existe sinon 0
     */
    public int createRetour(String Id,int km,Etat etat){
        Location loc=isReturned(Id);
        if(loc!=null){
            Calendar date= new GregorianCalendar();
            loc.addRetour(km, date, etat);
            return loc.getRetour().PrixFinal();
        }
        return (0);
    }
}