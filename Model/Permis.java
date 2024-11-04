package Model;

/**
 * La classe {@code Permis} permet de définir les permis necessaire à la conduite des scooter
 */
public class Permis {

    /**
     * Constructeur d'un objet {@code Permis}
     * @param cc La valeur du permis
     */
    public Permis(int cc) {
        this.cc=cc;
    }


    /**
     * La valeur du permis
     */
    private int cc;
    

    /**
     * Permet de recuperer la valeur du permis
     * @return la valeur du permis
     */
    public int getCC(){
        return cc;
    }

    
    /**
     * Permet de représenter l'objet {@code Permis} sous la forme d'une chaine de caractère
     * @return la valeur du permis
     */
    public String toString(){
        return String.valueOf(cc);
    }
}