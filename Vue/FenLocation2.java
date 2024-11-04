package Vue;

import Model.*;
import Controler.*;

import javax.swing.*;
import java.util.*;
import java.awt.*;

/**
 * Fenetre de validation de location 
 */
public class FenLocation2 extends JFrame{
   
    /**
     * Layout Fenetre
     */
    private GridBagLayout gbl=new GridBagLayout();
    private GridBagConstraints gbc=new GridBagConstraints();
    private JPanel pan=new JPanel();


    /**
     * Utile
     */   
    private Marque marque;
    private LocationCtl2 ctl;
    private FenLocation1 loc1;

    /**
     * Element de la fenetre
     */
    private JLabel scoot=new JLabel("Scooter");
    private JComboBox<Scooter> scoot_cb;

    private JButton submit=new JButton("Submit");

    private JButton annuler=new JButton("Annuler");
    
    /**
     * Création de la fenetre permettant la création d'une location
     * @param s Le nom de la fenetre
     * @param marque La marque de scooter choisie
     * @param l1 La fenetre de création de location partie 1 pour recuperer toutes les informations
     */
    public FenLocation2(String s,Marque marque,FenLocation1 l1){
        super(s);
        this.marque=marque;
        loc1=l1;


        /**
         * Initialisation des éléments à afficher dans la liste déroulante
         */
        scoot_cb=new JComboBox<Scooter>(listScoots());



        /**
         * Fonctionnement des boutons
         */
        ctl=new LocationCtl2(loc1, this);
        annuler.setName("Annuler");
        annuler.addActionListener(ctl);
        submit.setName("Submit");
        submit.addActionListener(ctl);
        submit.setBackground(Color.WHITE);
        submit.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        annuler.setBackground(Color.WHITE);
        annuler.setUI(new javax.swing.plaf.basic.BasicButtonUI());


        /**
         * Parametres du layout de la fenetre
         */
        getContentPane().add(pan);
        pan.setBackground(Color.white);
        gbl.columnWidths=new int[]{165,165};
        gbl.rowHeights=new int[]{80,80,80};
        gbc.insets=new Insets(15,15,15,15);
        pan.setLayout(gbl);

        /**
         * Position des élements de la page
         */

        gbc.gridx=0;
        gbc.gridwidth=2;
        gbc.gridy=0;
        pan.add(scoot,gbc);
        
        gbc.fill=GridBagConstraints.BOTH;
        gbc.gridy=1;
        pan.add(scoot_cb,gbc);
        
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=1;
        gbc.gridy=2;
        pan.add(submit,gbc);

        gbc.gridx=1;
        pan.add(annuler,gbc);


        /**
         * Parametre d'affichage de la fenetre
         */
        setBounds(750,300,325,280);
        setVisible(true);
        setResizable(false);
    }
    

    /**
     * Renvoie la liste des scooter çelon la marque
     * @return liste de scooter çelon la marque
     */
    public Vector<Scooter> listScoots(){
        Vector<Scooter> list=new Vector<Scooter>(10,1);
        for(int i=0;i<marque.getListModele().size();i++){
            Modele modele=marque.getListModele().get(i);
            for(int j=0;j<modele.getListScoot().size();j++){
                Scooter scoot=modele.getListScoot().get(j);
                list.add(scoot);
            }
        }
        return list;
    }
    
    /**
     * Renvoie le scooter qui a été selectioné
     * @return Scooter choisi dans la liste
     */
    public Scooter getScoot(){
        return ((Scooter)scoot_cb.getSelectedItem());
    }
}
