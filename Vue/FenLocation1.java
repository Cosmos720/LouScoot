package Vue;

import javax.swing.*;

import Model.*;
import Controler.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

/**
 * Fenetre de location, avec retour et resume du scooter du programme 
 */
public class FenLocation1 extends JFrame{

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
    private LocationCtl1 ctl;
    
    /**
     * Element de l'onglet location
     */
    private JPanel onglet1=new JPanel();

    private JLabel emp1=new JLabel("Employé");
    private JComboBox<Employe> emp_cb1;

    private JLabel cli1=new JLabel("Client");
    private JComboBox<Client> cli_cb1;

    private JLabel dateD=new JLabel("Date début");
    private JFormattedTextField dateD_ftf=new JFormattedTextField(DateFormat.getDateInstance());

    private JLabel dateF=new JLabel("Date fin");
    private JFormattedTextField dateF_ftf=new JFormattedTextField(DateFormat.getDateInstance());

    private JLabel mar=new JLabel("Marque");
    private JComboBox<Marque> mar_cb;

    private JLabel km1=new JLabel("Km");
    private JTextField km1_tf=new JTextField();

    private JButton submit1=new JButton("Submit");

    /**
     * Element de l'onglet retour
     */
    private JPanel onglet2=new JPanel();

    private JLabel emp2=new JLabel("Employé");
    private JComboBox<Employe> emp_cb2;

    private JLabel cli2=new JLabel("Client");
    private JComboBox<Client> cli_cb2;

    private JLabel km2=new JLabel("Km");
    private JTextField km2_tf=new JTextField();

    private JLabel id=new JLabel("ID Location");
    private JTextField id_tf=new JTextField();

    private JLabel etat=new JLabel("Etat");
    private JComboBox<Etat> etat_cb;
    
    private JButton submit2=new JButton("Submit");

    /**
     * Element de l'onglet resume location
     */
    private JPanel onglet3=new JPanel();
    private JList<Location> listLocation;
    private JScrollPane scrollablePane=new JScrollPane();


    /**
     * Créer la fenetre de gestion des locations partie 1
     * @param s Le nom de la fenetre
     * @param m Magasin de location
     */
    public FenLocation1(String s,Magasin m){
        super(s);
        magasin=m;


        /**
         * Initialisation des éléments à afficher dans les listes déroulantes
         */
        emp_cb1=new JComboBox<Employe>(magasin.getListEmploye());
        emp_cb2=new JComboBox<Employe>(magasin.getListEmploye());
        cli_cb1=new JComboBox<Client>(magasin.getListClient());
        cli_cb2=new JComboBox<Client>(magasin.getListClient());
        mar_cb=new JComboBox<Marque>(magasin.getListMarque());
        etat_cb=new JComboBox<Etat>(magasin.getListEtat());

        /**
         * Initialisation des locations à afficher dans le resume des locations crées
         */
        listLocation=new JList<Location>(magasin.getListLoc());

        /**
         * Afficher le format de date initialisé a la date d'aujourd'hui
         */
        Calendar today=new GregorianCalendar();
        dateD_ftf.setValue(today.getTime());
        today.add(Calendar.DATE, 1);
        dateF_ftf.setValue(today.getTime());
        
        
        /**
         * Oblige l'utilisateur à mettre uniquement des chiffres dans une zone de texte
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
         * Ajout des contraintes d'écritures dans les zones de textes
         */
        km1_tf.addKeyListener(Digit);
        km2_tf.addKeyListener(Digit);
        id_tf.addKeyListener(Digit);

        /**
         * Fonctionnement des Boutons
         */
        ctl=new LocationCtl1(magasin,this);
        submit1.addActionListener(ctl);
        submit1.setName("Location");
        submit1.setBackground(Color.WHITE);
        submit1.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        submit2.addActionListener(ctl);
        submit2.setName("Retour");
        submit2.setBackground(Color.WHITE);
        submit2.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        
        
        /**
         * Parametre du layout de la fenetre
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
        onglet3.setPreferredSize(new Dimension(575, 300));
        onglet3.setLayout(new FlowLayout());  
        onglet3.setBackground(Color.white);  
        
        
        /**
         * Position des élements de la page
         */
        gbc.fill=GridBagConstraints.BOTH;

        gbc.gridx=0;
        gbc.gridy=0;
        onglet1.add(emp1,gbc);
        onglet2.add(emp2,gbc);
        
        gbc.gridx=1;
        onglet1.add(emp_cb1,gbc);
        onglet2.add(emp_cb2,gbc);
        
        gbc.gridx=2;
        onglet1.add(cli1,gbc);
        onglet2.add(cli2,gbc);
        
        gbc.gridx=3;
        onglet1.add(cli_cb1,gbc);
        onglet2.add(cli_cb2,gbc);
        
        gbc.gridx=0;
        gbc.gridy=1;
        onglet1.add(dateD,gbc);
        onglet2.add(id,gbc);
        
        gbc.gridx=1;
        onglet1.add(dateD_ftf,gbc);
        onglet2.add(id_tf,gbc);
        
        gbc.gridx=2;
        onglet1.add(dateF,gbc);
        onglet2.add(km2,gbc);
        
        gbc.gridx=3;
        onglet1.add(dateF_ftf,gbc);
        onglet2.add(km2_tf,gbc);
        
        gbc.gridx=0;
        gbc.gridy=2;
        onglet1.add(mar,gbc);
        onglet2.add(etat,gbc);
        
        gbc.gridx=1;
        onglet1.add(mar_cb,gbc);
        onglet2.add(etat_cb,gbc);
        
        gbc.gridx=2;
        onglet1.add(km1,gbc);
        
        gbc.gridx=3;
        onglet1.add(km1_tf,gbc);
        
        gbc.fill=GridBagConstraints.NONE;
        
        gbc.gridx=0;
        gbc.gridwidth=4;
        gbc.gridy=3;
        onglet1.add(submit1,gbc);
        onglet2.add(submit2,gbc);
        
        /**
         * Affichage de la liste des locations crées et ajout à l'onglet 3
         */
        scrollablePane.setViewportView(listLocation);
        scrollablePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollablePane.setPreferredSize(new Dimension(575, 290));
        onglet3.add(scrollablePane);
        
        
        /**
         * Ajout des onglets à la fenetre
         */
        onglets.addTab("Créer une location", onglet1);
        onglets.addTab("Retour", onglet2);
        onglets.addTab("Resume Location",onglet3);


        /**
         * Parametre d'affichage de la fenetre
         */
        setBounds(750,300,600,375);
        setVisible(true);
        setResizable(false);
    }


    /**
     * Renvoie l'employé qui a été selectioné dans location
     * @return Employé choisi dans la liste
     */
    public Employe getEmpLoc(){
        return ((Employe)emp_cb1.getSelectedItem());
    }

    /**
     * Renvoie l'employé qui a été selectioné dans retour
     * @return Employé choisi dans la liste
     */
    public Employe getEmpRet(){
        return ((Employe)emp_cb2.getSelectedItem());
    }

    /**
     * Renvoie le client qui a été selectioné dans location
     * @return Client choisi dans la liste
     */
    public Client getCliLoc(){
        return ((Client)cli_cb1.getSelectedItem());
    }

    /**
     * Renvoie le client qui a été selectioné dans retour
     * @return Client choisi dans la liste
     */
    public Client getCliRet(){
        return ((Client)cli_cb2.getSelectedItem());
    }

    /**
     * Renvoie la date de debut de location choisie
     * @return Date de location choisie
     */
    public Calendar getDateD(){
        Calendar dateD=Calendar.getInstance();
        dateD.setTime((Date)dateD_ftf.getValue());
        return dateD;
    }

    /**
     * Renvoie la date retour choisie
     * @return Date de retour choisie
     */
    public Calendar getDateF(){
        Calendar dateF=Calendar.getInstance();
        dateF.setTime((Date)dateF_ftf.getValue());
        return dateF;
    }

    /**
     * Renvoie le nombre de KM choisi par le client
     * @return Km choisi par le client
     */
    public int getKmLoc(){
        if(!km1_tf.getText().equals("")){
            return Integer.parseInt(km1_tf.getText());
        }else{
            return -1;
        }
    }

    /**
     * Renvoie le nombre de KM du scooter lors du retour
     * @return Km du scooter au retour
     */
    public int getKmRet(){
        if(!km2_tf.getText().equals("")){
            return Integer.parseInt(km2_tf.getText());
        }else{
            return -1;
        }
    }

    /**
     * Renvoie la marque choisie dans la liste
     * @return Marque choisie par client
     */
    public Marque getMarque(){
        return ((Marque)mar_cb.getSelectedItem());
    }

    /**
     * Renvoie l'ID de location 
     * @return ID de location
     */
    public String getID(){
        return id_tf.getText();
    }

    /**
     * Renvoie l'etat du scooter au moment du retour
     * @return Etat du scooter au retour
     */
    public Etat getEtat(){
        return ((Etat)etat_cb.getSelectedItem());
    }
}
