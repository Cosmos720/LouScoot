package Vue;

import Model.*;
import Controler.*;

import javax.swing.*;
import java.util.*;
import java.awt.*;

/**
 * La fenetre de création de scooter partie 2
 */
public class FenScoot2 extends JFrame{

    /**
     * Layout Fenetre
     */
    private GridBagLayout gbl=new GridBagLayout();
    private GridBagConstraints gbc=new GridBagConstraints();
    private JPanel pan=new JPanel();


    /**
     * Utile
     */     
    private Magasin magasin;
    private FenScoot1 scoot1;
    private ScooterCtl2 ctl;


    /**
     * Element de la fenetre
     */
    private JLabel dep=new JLabel("Depot");
    private JComboBox<Depot> dep_cb;

    private JButton submit=new JButton("Submit");

    private JButton annuler=new JButton("Annuler");
 

    /**
     * Création de la fenetre permettant de crée le scooter partie 2
     * @param s Le nom de la fenetre
     * @param m Le magasin dans lequel on veut enregistrer le scooter
     * @param s1 Le fenetre de création de scooter partie 1 pour recuperer les informations
     */
    public FenScoot2(String s,Magasin m,FenScoot1 s1){
        super(s);
        magasin=m;
        scoot1=s1;


        /**
         * Initialisation des éléments à afficher dans la liste déroulante
         */
        dep_cb=new JComboBox<Depot>(listDepots());


        
        /**
         * Fonctionnement des boutons
         */
        ctl=new ScooterCtl2(magasin, scoot1, this);
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
        pan.add(dep,gbc);

        gbc.fill=GridBagConstraints.BOTH;
        gbc.gridy=1;
        pan.add(dep_cb,gbc);

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
     * Renvoie la liste des dépots disponibles
     * @return liste des dépots
     */
    public Vector<Depot> listDepots(){
        Vector<Depot> listD=new Vector<Depot>(10,1);
        for(int i=0;i<magasin.getListDepot().size();i++){
            Depot dep=magasin.getListDepot().get(i);
            if(dep.getListScoot().size()<dep.getTaille()){
                listD.add(dep);
            }
        }
        return listD;
    }
    
    /**
     * Renvoie le dépot qui a été selectioné
     * @return dépot choisi dans la liste
     */
    public Depot getDepot(){
        return ((Depot) dep_cb.getSelectedItem());
    }
}