package Vue;

import Controler.*;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Fenetre d'ajout de client, et d'employé
 */
public class FenPersonne extends JFrame{

    /**
     * Layout Fenetre
     */
    private GridBagLayout gbl=new GridBagLayout();
    private GridBagConstraints gbc=new GridBagConstraints();
    private JPanel pan=new JPanel();
    private JTabbedPane onglets=new JTabbedPane(SwingConstants.TOP);


    /**
     * Element de l'onglet employé
     */
    private JPanel onglet1=new JPanel();

    private JLabel nome=new JLabel("Nom");
    private JTextField nome_tf=new JTextField();

    private JLabel prenome=new JLabel("Prénom");
    private JTextField prenome_tf=new JTextField();

    private JButton submit1=new JButton("Submit");
    
    /**
     * Element de l'onglet client
     */
    private JPanel onglet2=new JPanel();

    private JLabel nomc=new JLabel("Nom");
    private JTextField nomc_tf=new JTextField();

    private JLabel prenomc=new JLabel("Prénom");
    private JTextField prenomc_tf=new JTextField();

    private JLabel per=new JLabel("Permis");
    private JComboBox<Permis> per_cb;

    private JButton submit2=new JButton("Submit");


    /**
     * Utile
     */  
    private Magasin magasin;
    private PersonneCtl ctl;


    /**
     * Création de la fenetre d'enregistrement d'une personne
     * @param s Le nom de la fenetre
     * @param m Le magasin dans lequel on veut enregistrer la personne
     */
    public FenPersonne(String s,Magasin m){
        super(s);
        magasin=m;


        /**
         * Initialisation des éléments à afficher dans la liste déroulante
         */
        per_cb=new JComboBox<Permis>(magasin.getListPermis());


        
        
        /**
         * Oblige l'utilisateur à mettre uniquement des lettres dans une zone de texte
         */
        KeyAdapter Letter=new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(!Character.isAlphabetic(c)){
                    e.consume();
                }
            }
        };

        /**
         * Ajout des contraintes d'écritures dans les zones de textes
         */
        nomc_tf.addKeyListener(Letter);
        nome_tf.addKeyListener(Letter);
        prenomc_tf.addKeyListener(Letter);
        prenome_tf.addKeyListener(Letter);

        /**
         * Fonctionnement des boutons
         */
        ctl=new PersonneCtl(magasin, this);
        submit1.addActionListener(ctl);
        submit1.setName("Employe");
        submit1.setBackground(Color.WHITE);
        submit1.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        submit2.addActionListener(ctl);
        submit2.setName("Client");
        submit2.setBackground(Color.WHITE);
        submit2.setUI(new javax.swing.plaf.basic.BasicButtonUI());


        /**
         * Parametres du layout de la fenetre
         */
        getContentPane().add(pan);
        pan.add(onglets);
  
        gbl.columnWidths=new int[]{72,216,72,216};
        gbl.rowHeights=new int[]{60,60,60,60};
        gbc.insets=new Insets(15,15,15,15);
        onglet1.setPreferredSize(new Dimension(575, 300));
        onglet1.setLayout(gbl);
        onglet1.setBackground(Color.white);
        onglet2.setPreferredSize(new Dimension(575, 300));
        onglet2.setLayout(gbl);
        onglet2.setBackground(Color.white);

        
        /**
         * Position des élements de la page
         */
        gbc.fill=GridBagConstraints.BOTH;

        gbc.gridx=0;
        gbc.gridy=0;
        onglet1.add(nome,gbc);
        onglet2.add(nomc,gbc);

        gbc.gridx=1;
        onglet1.add(nome_tf,gbc);
        onglet2.add(nomc_tf,gbc);


        gbc.gridx=0;
        gbc.gridy=1;
        onglet1.add(prenome,gbc);
        onglet2.add(prenomc,gbc);

        gbc.gridx=1;
        onglet1.add(prenome_tf,gbc);
        onglet2.add(prenomc_tf,gbc);
      
        gbc.gridx=0;
        gbc.gridy=2;
        onglet2.add(per,gbc);

        gbc.gridx=1;
        onglet2.add(per_cb,gbc);

        gbc.fill=GridBagConstraints.NONE;

        gbc.gridx=0;
        gbc.gridwidth=4;
        gbc.gridy=3;
        onglet1.add(submit1,gbc);
        onglet2.add(submit2,gbc);


        /**
         * Ajout des onglets à la fenetre
         */
        onglets.addTab("Ajouter un Employé", onglet1);
        onglets.addTab("Ajouter un Client", onglet2);


        /**
         * Parametre d'affichage de la fenetre
         */
        setBounds(750,300,600,375);
        setVisible(true);
        setResizable(false);
    }


    /**
     * Renvoie le nom de l'employé entré
     * @return Nom employé entré
     */
    public String getNomE(){
        return nome_tf.getText();
    }

    /**
     * Renvoie le prenom de l'employé entré
     * @return Prenom employé entré
     */
    public String getPrenomE(){
        return prenome_tf.getText();
    }

    /**
     * Renvoie le prenom du client entré
     * @return Nomom client entré
     */
    public String getNomC(){
        return nomc_tf.getText();
    }

    /**
     * Renvoie le prenom de l'employé entré
     * @return Prenom client entré
     */
    public String getPrenomC(){
        return prenomc_tf.getText();
    }
    
    /**
     * Renvoie le permis du client entré
     * @return Permis client entré
     */
    public Permis getPermisC(){
        return ((Permis)per_cb.getSelectedItem());
    }
}