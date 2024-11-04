package Model;

/**
 * La classe {@code Etat} permet de définir l'état d'un scooter
 */
public class Etat {

    /**
     * Constructeur d'un objet {@code Etat}
     * @param etat Une valeur entre 0 et 4 définissant l'état d'un scooter
     */
    public Etat(int etat) {
        nivEtat=etat;
        descEtat=desc();
    }


    /**
     * Description de l'état d'un scooter
     */
    private String descEtat; 

    /**
     * Niveau de l'état d'un scooter entre 0 et 4
     */
    private int nivEtat;


    /**
     * Permet de recuperer la valeur de l'état d'un scooter
     * @return Le niveau d'état d'un scooter
     */
    public int getEtat(){
        return nivEtat;
    }

    /**
     * Permet de recuperer la description de l'état d'un scooter 
     * @return La description de l'état d'un scooter
     */
    public String getDesc(){
        return descEtat;
    }


    /**
     * Permet de définir la description de l'état d'un scooter en fonction du niveau de l'état
     * @return la description de l'état d'un scooter
     */
    private String desc(){
        if(nivEtat==0){
            return "Neuf";
        } else if(nivEtat==1){
            return "Très Bien";
        } else if(nivEtat==2){
            return "Bon";
        } else if(nivEtat==3){
            return "Passable";
        } else {
            return "Mort";
        }
    }


    /**
     * Permet de représenter l'objet {@code Etat} sous la forme d'une chaine de caractère
     * @return le niveau de l'état et sa description
     */
    public String toString(){
        return nivEtat + ": " +descEtat;
    }
}