import Model.*;
import Vue.*;

public class Main {
    public static void main(String args[]){
        Magasin m=new Magasin("LouScoot");//On créer le magasin LouScoot

        new FenAccueil("Accueil",m); // On lance le programme, avec la fenetre d'accueil
    }
}