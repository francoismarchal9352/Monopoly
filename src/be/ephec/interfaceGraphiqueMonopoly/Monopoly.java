package be.ephec.interfaceGraphiqueMonopoly;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class Monopoly extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JButton buttonLancerDes;
	private JButton buttonAcheter;
	private JButton buttonVendre;
	private JButton buttonLoyer;
	private JButton buttonFinirTour;
	private JTextArea textAreaConsole;
	private JLabel labelD1;
	private JLabel labelD2;
	private JLabel labelValD2;
	private JLabel labelValD1;
	private JLabel labelSoldeJ1;
	private JLabel labelSoldeJ2;
	private JLabel labelValSoldeJ1;
	private JLabel labelValSoldeJ2;
	private JLabel labelCartePrison;
	private JLabel labelNbCartePrison;
	private JLabel labelTourPrison;
	private JLabel labelNbTourPrison;
	private JLabel labelTourSuite;
	private JLabel labelNbTourSuite;
	private JLabel labelPositionJ1;
	private JLabel labelPositionJ2;
	private JLabel labelValPositionJ1;
	private JLabel labelValPositionJ2;
	private JLabel labelJoueur;

	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monopoly frame = new Monopoly();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	*/

	/**
	 * Create the frame.
	 */
	public Monopoly(String nom) {
		setResizable(false);
		setTitle("Monopoly");
		setSize(1500,900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{22, 653, 32, 90, 130, 146, 96, 26, 0};
		gridBagLayout.rowHeights = new int[]{23, 341, 56, 32, 0, 21, 22, 0, 0, 15, 48, 0, 0, 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		JLabel background=new JLabel(new ImageIcon("./boardgame4.jpg"));
		GridBagConstraints gbc_background = new GridBagConstraints();
		gbc_background.gridheight = 20;
		gbc_background.anchor = GridBagConstraints.WEST;
		gbc_background.insets = new Insets(0, 0, 5, 5);
		gbc_background.gridx = 1;
		gbc_background.gridy = 1;
		getContentPane().add(background, gbc_background);
		background.setLayout(new FlowLayout());
		
		textAreaConsole = new JTextArea();
		textAreaConsole.setEditable(false);
		textAreaConsole.setTabSize(10);
		textAreaConsole.setRows(6);
		textAreaConsole.setColumns(3);
		GridBagConstraints gbc_textAreaConsole = new GridBagConstraints();
		gbc_textAreaConsole.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaConsole.gridwidth = 4;
		gbc_textAreaConsole.fill = GridBagConstraints.BOTH;
		gbc_textAreaConsole.gridx = 3;
		gbc_textAreaConsole.gridy = 1;
		getContentPane().add(textAreaConsole, gbc_textAreaConsole);
		
		buttonLancerDes = new JButton("Lancer les Dés");
		buttonLancerDes.addActionListener(this);
		
		labelJoueur = new JLabel(nom);
		GridBagConstraints gbc_labelJoueur = new GridBagConstraints();
		gbc_labelJoueur.gridwidth = 2;
		gbc_labelJoueur.insets = new Insets(0, 0, 5, 5);
		gbc_labelJoueur.gridx = 4;
		gbc_labelJoueur.gridy = 2;
		getContentPane().add(labelJoueur, gbc_labelJoueur);
		GridBagConstraints gbc_buttonLancerDes = new GridBagConstraints();
		gbc_buttonLancerDes.anchor = GridBagConstraints.NORTHWEST;
		gbc_buttonLancerDes.insets = new Insets(0, 0, 5, 5);
		gbc_buttonLancerDes.gridx = 3;
		gbc_buttonLancerDes.gridy = 3;
		getContentPane().add(buttonLancerDes, gbc_buttonLancerDes);
		
		buttonAcheter = new JButton("Acheter");
		buttonAcheter.addActionListener(this);
		buttonAcheter.setHorizontalAlignment(SwingConstants.LEADING);
		GridBagConstraints gbc_buttonAcheter = new GridBagConstraints();
		gbc_buttonAcheter.anchor = GridBagConstraints.NORTH;
		gbc_buttonAcheter.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAcheter.gridx = 4;
		gbc_buttonAcheter.gridy = 3;
		getContentPane().add(buttonAcheter, gbc_buttonAcheter);
		
		buttonVendre = new JButton("Vendre");
		buttonVendre.addActionListener(this);
		GridBagConstraints gbc_buttonVendre = new GridBagConstraints();
		gbc_buttonVendre.anchor = GridBagConstraints.NORTH;
		gbc_buttonVendre.insets = new Insets(0, 0, 5, 5);
		gbc_buttonVendre.gridx = 5;
		gbc_buttonVendre.gridy = 3;
		getContentPane().add(buttonVendre, gbc_buttonVendre);
		
		buttonLoyer = new JButton("Demander Loyer");
		buttonLoyer.addActionListener(this);
		GridBagConstraints gbc_buttonLoyer = new GridBagConstraints();
		gbc_buttonLoyer.anchor = GridBagConstraints.NORTHWEST;
		gbc_buttonLoyer.insets = new Insets(0, 0, 5, 5);
		gbc_buttonLoyer.gridx = 6;
		gbc_buttonLoyer.gridy = 3;
		getContentPane().add(buttonLoyer, gbc_buttonLoyer);
		
		labelSoldeJ1 = new JLabel("Solde Joueur 1");
		GridBagConstraints gbc_labelSoldeJ1 = new GridBagConstraints();
		gbc_labelSoldeJ1.anchor = GridBagConstraints.NORTH;
		gbc_labelSoldeJ1.insets = new Insets(0, 0, 5, 5);
		gbc_labelSoldeJ1.gridx = 4;
		gbc_labelSoldeJ1.gridy = 6;
		getContentPane().add(labelSoldeJ1, gbc_labelSoldeJ1);
		
		labelSoldeJ2 = new JLabel("Solde Joueur 2");
		GridBagConstraints gbc_labelSoldeJ2 = new GridBagConstraints();
		gbc_labelSoldeJ2.anchor = GridBagConstraints.NORTH;
		gbc_labelSoldeJ2.insets = new Insets(0, 0, 5, 5);
		gbc_labelSoldeJ2.gridx = 6;
		gbc_labelSoldeJ2.gridy = 6;
		getContentPane().add(labelSoldeJ2, gbc_labelSoldeJ2);
		
		labelValSoldeJ1 = new JLabel("X");
		GridBagConstraints gbc_labelValSoldeJ1 = new GridBagConstraints();
		gbc_labelValSoldeJ1.anchor = GridBagConstraints.NORTH;
		gbc_labelValSoldeJ1.insets = new Insets(0, 0, 5, 5);
		gbc_labelValSoldeJ1.gridx = 4;
		gbc_labelValSoldeJ1.gridy = 7;
		getContentPane().add(labelValSoldeJ1, gbc_labelValSoldeJ1);
		
		labelValSoldeJ2 = new JLabel("X");
		GridBagConstraints gbc_labelValSoldeJ2 = new GridBagConstraints();
		gbc_labelValSoldeJ2.anchor = GridBagConstraints.NORTH;
		gbc_labelValSoldeJ2.insets = new Insets(0, 0, 5, 5);
		gbc_labelValSoldeJ2.gridx = 6;
		gbc_labelValSoldeJ2.gridy = 7;
		getContentPane().add(labelValSoldeJ2, gbc_labelValSoldeJ2);
		
		labelD1 = new JLabel("de1");
		GridBagConstraints gbc_labelD1 = new GridBagConstraints();
		gbc_labelD1.anchor = GridBagConstraints.NORTH;
		gbc_labelD1.insets = new Insets(0, 0, 5, 5);
		gbc_labelD1.gridx = 3;
		gbc_labelD1.gridy = 8;
		getContentPane().add(labelD1, gbc_labelD1);
		
		labelPositionJ1 = new JLabel("Position Joueur 1");
		GridBagConstraints gbc_labelPositionJ1 = new GridBagConstraints();
		gbc_labelPositionJ1.insets = new Insets(0, 0, 5, 5);
		gbc_labelPositionJ1.gridx = 4;
		gbc_labelPositionJ1.gridy = 8;
		getContentPane().add(labelPositionJ1, gbc_labelPositionJ1);
		
		labelPositionJ2 = new JLabel("Position Joueur 2");
		GridBagConstraints gbc_labelPositionJ2 = new GridBagConstraints();
		gbc_labelPositionJ2.insets = new Insets(0, 0, 5, 5);
		gbc_labelPositionJ2.gridx = 6;
		gbc_labelPositionJ2.gridy = 8;
		getContentPane().add(labelPositionJ2, gbc_labelPositionJ2);
		
		labelValD1 = new JLabel("X");
		GridBagConstraints gbc_labelValD1 = new GridBagConstraints();
		gbc_labelValD1.anchor = GridBagConstraints.NORTH;
		gbc_labelValD1.insets = new Insets(0, 0, 5, 5);
		gbc_labelValD1.gridx = 3;
		gbc_labelValD1.gridy = 9;
		getContentPane().add(labelValD1, gbc_labelValD1);
		
		labelValPositionJ1 = new JLabel("X");
		GridBagConstraints gbc_labelValPositionJ1 = new GridBagConstraints();
		gbc_labelValPositionJ1.insets = new Insets(0, 0, 5, 5);
		gbc_labelValPositionJ1.gridx = 4;
		gbc_labelValPositionJ1.gridy = 9;
		getContentPane().add(labelValPositionJ1, gbc_labelValPositionJ1);
		
		labelValPositionJ2 = new JLabel("X");
		GridBagConstraints gbc_labelValPositionJ2 = new GridBagConstraints();
		gbc_labelValPositionJ2.insets = new Insets(0, 0, 5, 5);
		gbc_labelValPositionJ2.gridx = 6;
		gbc_labelValPositionJ2.gridy = 9;
		getContentPane().add(labelValPositionJ2, gbc_labelValPositionJ2);
		
		labelD2 = new JLabel("de2");
		GridBagConstraints gbc_labelD2 = new GridBagConstraints();
		gbc_labelD2.anchor = GridBagConstraints.NORTH;
		gbc_labelD2.insets = new Insets(0, 0, 5, 5);
		gbc_labelD2.gridx = 3;
		gbc_labelD2.gridy = 11;
		getContentPane().add(labelD2, gbc_labelD2);
		
		labelValD2 = new JLabel("X");
		GridBagConstraints gbc_labelValD2 = new GridBagConstraints();
		gbc_labelValD2.anchor = GridBagConstraints.NORTH;
		gbc_labelValD2.insets = new Insets(0, 0, 5, 5);
		gbc_labelValD2.gridx = 3;
		gbc_labelValD2.gridy = 12;
		getContentPane().add(labelValD2, gbc_labelValD2);
		
		labelCartePrison = new JLabel("Cartes Sortez de Prison");
		GridBagConstraints gbc_labelCartePrison = new GridBagConstraints();
		gbc_labelCartePrison.anchor = GridBagConstraints.NORTH;
		gbc_labelCartePrison.insets = new Insets(0, 0, 5, 5);
		gbc_labelCartePrison.gridx = 3;
		gbc_labelCartePrison.gridy = 14;
		getContentPane().add(labelCartePrison, gbc_labelCartePrison);
		
		labelNbCartePrison = new JLabel("X");
		GridBagConstraints gbc_labelNbCartePrison = new GridBagConstraints();
		gbc_labelNbCartePrison.anchor = GridBagConstraints.NORTH;
		gbc_labelNbCartePrison.insets = new Insets(0, 0, 5, 5);
		gbc_labelNbCartePrison.gridx = 4;
		gbc_labelNbCartePrison.gridy = 14;
		getContentPane().add(labelNbCartePrison, gbc_labelNbCartePrison);
		
		labelTourPrison = new JLabel("Tours en Prison");
		GridBagConstraints gbc_labelTourPrison = new GridBagConstraints();
		gbc_labelTourPrison.anchor = GridBagConstraints.NORTH;
		gbc_labelTourPrison.insets = new Insets(0, 0, 5, 5);
		gbc_labelTourPrison.gridx = 3;
		gbc_labelTourPrison.gridy = 16;
		getContentPane().add(labelTourPrison, gbc_labelTourPrison);
		
		labelNbTourPrison = new JLabel("X");
		GridBagConstraints gbc_labelNbTourPrison = new GridBagConstraints();
		gbc_labelNbTourPrison.anchor = GridBagConstraints.NORTH;
		gbc_labelNbTourPrison.insets = new Insets(0, 0, 5, 5);
		gbc_labelNbTourPrison.gridx = 4;
		gbc_labelNbTourPrison.gridy = 16;
		getContentPane().add(labelNbTourPrison, gbc_labelNbTourPrison);
		
		labelTourSuite = new JLabel("Tours de Suite");
		GridBagConstraints gbc_labelTourSuite = new GridBagConstraints();
		gbc_labelTourSuite.anchor = GridBagConstraints.NORTH;
		gbc_labelTourSuite.insets = new Insets(0, 0, 5, 5);
		gbc_labelTourSuite.gridx = 3;
		gbc_labelTourSuite.gridy = 18;
		getContentPane().add(labelTourSuite, gbc_labelTourSuite);
		
		labelNbTourSuite = new JLabel("X");
		GridBagConstraints gbc_labelNbTourSuite = new GridBagConstraints();
		gbc_labelNbTourSuite.anchor = GridBagConstraints.NORTH;
		gbc_labelNbTourSuite.insets = new Insets(0, 0, 5, 5);
		gbc_labelNbTourSuite.gridx = 4;
		gbc_labelNbTourSuite.gridy = 18;
		getContentPane().add(labelNbTourSuite, gbc_labelNbTourSuite);
		
		buttonFinirTour = new JButton("Finir Tour");
		buttonFinirTour.setEnabled(false);
		buttonFinirTour.addActionListener(this);
		GridBagConstraints gbc_buttonFinirTour = new GridBagConstraints();
		gbc_buttonFinirTour.insets = new Insets(0, 0, 5, 5);
		gbc_buttonFinirTour.gridx = 6;
		gbc_buttonFinirTour.gridy = 20;
		getContentPane().add(buttonFinirTour, gbc_buttonFinirTour);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				oos.write(e.getActionCommand());
				if(this.get)
				TimeUnit.MILLISECONDS.sleep(250);
				ois.readObject(partie);
				
				
		}

	public void run() {
		// TODO Auto-generated method stub
		
	}
}
