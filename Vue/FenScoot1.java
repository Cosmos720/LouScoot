package Vue;

import Model.*;
import Controler.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Fenetre d'ajout de scooter et d'ajout de dépots
 */
public class FenScoot1 extends JFrame{

    /**
     * Layout Fenetre
     */
    private GridBagLayout gbl=new GridBagLayout();
    private GridBagConstraints gbc=new GridBagConstraints();
    private JPanel pan=new JPanel();
    private JTabbedPane onglets=new JTabbedPane(SwingConstants.TOP);


    /**
     * Utile
     */    
    private Magasin magasin;
    private ScooterCtl1 ctl;


    /**
     * Element de l'onglet ajout scooter
     */
    private JPanel onglet1=new JPanel();

    private JLabel id=new JLabel("ID");
    private JTextField id_tf=new JTextField();

    private JLabel nomsc=new JLabel("Nom");
    private JTextField nomsc_tf=new JTextField();

    private JLabel per=new JLabel("Permis");
    private JComboBox<Permis> per_cb;

    private JLabel marque=new JLabel("Marque");
    private JTextField marque_tf=new JTextField();
    
    private JLabel prix=new JLabel("Prix");
    private JTextField prix_tf=new JTextField();

    private JLabel couleur=new JLabel("Couleur");
    private JTextField couleur_tf=new JTextField();
    
    private JButton submit1=new JButton("Submit");
    
    /**
     * Element de l'onglet ajout dépot
     */
    private JPanel onglet2=new JPanel(); 
    
    private JLabel nomdp=new JLabel("Nom");
    private JTextField nomdp_tf=new JTextField();

    private JLabel taille=new JLabel("Taille");
    private JTextField taille_tf=new JTextField();
    
    private JButton submit2=new JButton("Submit");


    public FenScoot1(String s,Magasin m){
        super(s);
        magasin=m;


        /**
         * Initialisation des éléments à afficher dans la liste déroulante
         */
        per_cb=new JComboBox<Permis>(magasin.getListPermis());





        /**
        * Oblige l'utilisateur de mettre uniquement des chiffres dans un FormatedTextField donné
        */
        KeyAdapter Digit=new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        };

        /**
         * Oblige l'utilisateur de mettre uniquement des charactere dans un FormatedTextField donnée
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
        prix_tf.addKeyListener(Digit);
        taille_tf.addKeyListener(Digit);
        couleur_tf.addKeyListener(Letter);

        /**
         * Fonctionnement des boutons
         */
        ctl=new ScooterCtl1(magasin, this);
        submit1.addActionListener(ctl);
        submit1.setName("Scooter");
        submit1.setBackground(Color.WHITE);
        submit1.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        submit2.addActionListener(ctl);
        submit2.setName("Depot");
        submit2.setBackground(Color.WHITE);
        submit2.setUI(new javax.swing.plaf.basic.BasicButtonUI());


        /**
         * Parametres du layout de la fenetre
         */
        getContentPane().add(pan);
        pan.add(onglets);
        pan.setBackground(Color.white);
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
        onglet1.add(id,gbc);
        onglet2.add(nomdp,gbc);

        gbc.gridx=1;
        onglet1.add(id_tf,gbc);
        onglet2.add(nomdp_tf,gbc);

        gbc.gridx=2;
        onglet1.add(nomsc,gbc);

        gbc.gridx=3;
        onglet1.add(nomsc_tf,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        onglet1.add(per,gbc);
        onglet2.add(taille,gbc);

        gbc.gridx=1;
        onglet1.add(per_cb,gbc);
        onglet2.add(taille_tf,gbc);

        gbc.gridx=2;
        onglet1.add(marque,gbc);

        gbc.gridx=3;
        onglet1.add(marque_tf,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        onglet1.add(prix,gbc);

        gbc.gridx=1;
        onglet1.add(prix_tf,gbc);

        gbc.gridx=2;
        onglet1.add(couleur,gbc);

        gbc.gridx=3;
        onglet1.add(couleur_tf,gbc);

        gbc.fill=GridBagConstraints.NONE;

        gbc.gridx=0;
        gbc.gridwidth=4;
        gbc.gridy=3;
        onglet1.add(submit1,gbc);
        onglet2.add(submit2,gbc);

        onglets.addTab("Ajouter un Scooter", onglet1);
        onglet2.setPreferredSize(new Dimension(575, 300));
        onglets.addTab("Ajouter un depôt", onglet2);


        /**
         * Parametre d'affichage de la fenetre
         */
        setBounds(750,300,600,375);
        setVisible(true);
        setResizable(false);
    }


    /**
     * Renvoie le nom du dépot entré
     * @return Nom dépot entré
     */
    public String getNomD(){
        return nomdp_tf.getText();
    }

    /**
     * Renvoie la taille du dépot entré
     * @return Taille dépot entré
     */
    public int getTailleD(){
        if(!taille_tf.getText().equals("")){
            return Integer.parseInt(taille_tf.getText());
        }else{
            return -1;
        }
    }

    /**
     * Renvoie la marque du scooter entré
     * @return Marque du scooter entré
     */
    public String getMarque(){
        return marque_tf.getText();
    }

    /**
     * Renvoie la couleur du scooter entré
     * @return Couleur du scooter entré
     */
    public String getCouleur(){
        return couleur_tf.getText();
    }

    /**
     * Renvoie l'ID du scooter entré
     * @return ID du scooter entré
     */
    public String getID(){
        return id_tf.getText();
    }

    /**
     * Renvoie prix du scooter entré
     * @return Prix du scooter entré
     */
    public int getPrix(){
        if(!prix_tf.getText().equals("")){
            return Integer.parseInt(prix_tf.getText());
        }else{
            return -1;
        }
    }

    /**
     * Renvoie permis du scooter entré
     * @return Permis du scooter entré
     */
    public Permis getPermis(){
        return ((Permis) per_cb.getSelectedItem());
    }
    
    /**
     * Renvoie le nom du scooter entré
     * @return Nom du scooter entré
     */
    public String getNom(){
        return nomsc_tf.getText();
    }
}
