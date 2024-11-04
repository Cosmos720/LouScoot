package Model;

/**
 * La classe {@code Personne} permet de définir les {@code Client} et les {@code Employe}
 */
public class Personne {

    /**
     * Consctructeur de l'objet {@code Personne}
     *@param n nom de la personne
     *@param p prenom de la personne
     */
    public Personne(String n, String p) {
        nom=n;
        prenom=p;
    }

    
    /**
     * Le nom de la personne
     */
    private String nom;

    /**
     * Le prenom de la personne
     */
    private String prenom;


    /**
     * Permet de renvoyer le nom de la personne
     * @return le nom de la personne
     */
    public String getNom(){
        return nom;
    }
    
    /**
     * Permet de renvoyer le prenom de la personne
     * @return le prenom de la personne
     */
    public String getPrenom(){
        return prenom;
    }


    /**
     * Permet de représenter l'objet {@code Personne} sous la forme d'une chaine de caractère
     * @return le nom et prenom de la personne
     */
    public String toString(){
        return nom +" "+prenom;
    }
}