package Vue;

import Controler.*;
import Model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Fenetre d'accueil du programme 
 */
public class FenAccueil extends JFrame{  

    /**
     * Element de la fenetre
     */
    private JLabel Titre;
    private JButton gLoc = new JButton("Gestion des locations"  );
    private JButton gPer = new JButton("Gestion des personnes");
    private JButton gSco = new JButton("Gestion des scooter");
    
    /**
     * Utile
     */
    private Magasin magasin;
    private AccueilCtl cld;
    
    /**
     * Layout de la fenetre
     */
    private GridBagConstraints gc=new GridBagConstraints();
    private GridBagLayout gbl=new GridBagLayout();
    private JPanel pan = new JPanel();
    
    /**
     * Permet de construire la fenetre d'accueil
     * @param s Nom de la fenetre
     * @param m Magasin de location
     */
    public FenAccueil(String s,Magasin m){
        super(s);
        magasin=m;


        /**
         * Parametre d'affichage des éléments
         */
        getContentPane().add(pan);
        pan.setLayout(gbl);
        gc.insets = new Insets(15,15,15,15);
        
        /**
         * Fonctionnement des boutons
         */
        cld=new AccueilCtl(magasin,this);
        gLoc.setName("Location");
        gLoc.setBackground(Color.WHITE);
        gLoc.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        gLoc.addActionListener(cld);
        gPer.setName("Personne");
        gPer.setBackground(Color.WHITE);
        gPer.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        gPer.addActionListener(cld);
        gSco.setName("Scooter");
        gSco.addActionListener(cld);
        gSco.setBackground(Color.WHITE);
        gSco.setUI(new javax.swing.plaf.basic.BasicButtonUI());


        /**
         * Recupération du nom du magasin pour l'afficher sur la page
         */
        Titre=new JLabel(magasin.getNom());
        Titre.setFont(new Font("Serif", Font.BOLD, 48));
        Titre.setForeground(Color.BLACK);
        pan.setBackground(Color.white);

        /**
         * Positionnement des élements de la page
         */
        gc.fill= GridBagConstraints.BOTH;

        Titre.setHorizontalAlignment(SwingConstants.CENTER);    
        gc.gridx=1;
        gc.gridy=0;
        pan.add(Titre,gc);
        
        gc.gridx=1;
        gc.gridy=1;
        pan.add(gLoc,gc);
        
        gc.gridx=1;
        gc.gridy=2;
        pan.add(gSco,gc);
        
        gc.gridx=1;
        gc.gridy=3;
        pan.add(gPer,gc);

        
        /**
         * Parametre d'affichage de la fenetre
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(750,300,600,375);
        setVisible(true);
        setResizable(false);
    }
}