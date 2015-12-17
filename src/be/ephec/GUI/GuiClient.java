/**
 * @author Marchal François & Massart Florian
 * @version 1.0
 */

package be.ephec.GUI;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import be.ephec.application.ApplicationClient;
import be.ephec.network.*;

public class GuiClient extends JFrame implements ActionListener{
	private ApplicationClient applicationClient;
	private JButton buttonLancerDes;
	private JButton buttonAcheter;
	private JButton buttonVendre;
	private JButton buttonLoyer;
	private JButton buttonFinirTour;
	private JButton jButtonConnecter;
	private JTextArea textAreaConsole;
	private JLabel labelD1;
	private JLabel labelD2;
	private JLabel labelValD1;
	private JLabel labelValD2;
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
	private JTextField jTextFieldPort;
	private JLabel JLabelInfo;
	private JTextField jTextFieldIP;
	private JLabel jLabelAdrIP;
	
	
	/**
	 * Create the frame.
	 * @param applicationClient 
	 */
	public GuiClient(ApplicationClient applicationClient) {
		this.applicationClient = applicationClient;
		setResizable(false);
		setTitle("Monopoly");
		setSize(1500,900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{22, 653, 32, 90, 130, 146, 96, 26, 0};
		gridBagLayout.rowHeights = new int[]{23, 341, 56, 32, 0, 21, 22, 0, 0, 15, 29, 0, 0, 51, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		JLabel background=new JLabel(new ImageIcon("./PlateauFinal.png"));
		GridBagConstraints gbc_background = new GridBagConstraints();
		gbc_background.gridheight = 21;
		gbc_background.anchor = GridBagConstraints.WEST;
		gbc_background.insets = new Insets(0, 0, 5, 5);
		gbc_background.gridx = 1;
		gbc_background.gridy = 1;
		getContentPane().add(background, gbc_background);
		background.setLayout(new FlowLayout());
		
		textAreaConsole = new JTextArea();
		JScrollPane scroll = new JScrollPane(textAreaConsole, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
		getContentPane().add(scroll, gbc_textAreaConsole);
		
		buttonLancerDes = new JButton("Lancer les dés");
		buttonLancerDes.setEnabled(true);
		buttonLancerDes.addActionListener(this);
		
		labelJoueur = new JLabel("");
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
		buttonAcheter.setEnabled(false);
		buttonAcheter.addActionListener(this);
		buttonAcheter.setHorizontalAlignment(SwingConstants.LEADING);
		GridBagConstraints gbc_buttonAcheter = new GridBagConstraints();
		gbc_buttonAcheter.anchor = GridBagConstraints.NORTH;
		gbc_buttonAcheter.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAcheter.gridx = 4;
		gbc_buttonAcheter.gridy = 3;
		getContentPane().add(buttonAcheter, gbc_buttonAcheter);
		
		buttonVendre = new JButton("Vendre");
		buttonVendre.setEnabled(false);
		buttonVendre.addActionListener(this);
		GridBagConstraints gbc_buttonVendre = new GridBagConstraints();
		gbc_buttonVendre.anchor = GridBagConstraints.NORTH;
		gbc_buttonVendre.insets = new Insets(0, 0, 5, 5);
		gbc_buttonVendre.gridx = 5;
		gbc_buttonVendre.gridy = 3;
		getContentPane().add(buttonVendre, gbc_buttonVendre);
		
		buttonLoyer = new JButton("Demander Loyer");
		buttonLoyer.setEnabled(false);
		buttonLoyer.addActionListener(this);
		GridBagConstraints gbc_buttonLoyer = new GridBagConstraints();
		gbc_buttonLoyer.anchor = GridBagConstraints.NORTHWEST;
		gbc_buttonLoyer.insets = new Insets(0, 0, 5, 5);
		gbc_buttonLoyer.gridx = 6;
		gbc_buttonLoyer.gridy = 3;
		getContentPane().add(buttonLoyer, gbc_buttonLoyer);
		
		labelD1 = new JLabel("de1");
		GridBagConstraints gbc_labelD1 = new GridBagConstraints();
		gbc_labelD1.anchor = GridBagConstraints.NORTH;
		gbc_labelD1.insets = new Insets(0, 0, 5, 5);
		gbc_labelD1.gridx = 3;
		gbc_labelD1.gridy = 8;
		getContentPane().add(labelD1, gbc_labelD1);
		
		jLabelAdrIP = new JLabel("Adresse IP du serveur :");
		GridBagConstraints gbc_jLabelAdrIP = new GridBagConstraints();
		gbc_jLabelAdrIP.insets = new Insets(0, 0, 5, 5);
		gbc_jLabelAdrIP.anchor = GridBagConstraints.EAST;
		gbc_jLabelAdrIP.gridx = 4;
		gbc_jLabelAdrIP.gridy = 8;
		getContentPane().add(jLabelAdrIP, gbc_jLabelAdrIP);
		
		jTextFieldIP = new JTextField();
		jTextFieldIP.setText("127.0.0.1");
		GridBagConstraints gbc_jTextFieldIP = new GridBagConstraints();
		gbc_jTextFieldIP.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldIP.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldIP.gridx = 5;
		gbc_jTextFieldIP.gridy = 8;
		getContentPane().add(jTextFieldIP, gbc_jTextFieldIP);
		jTextFieldIP.setColumns(10);
		
		labelValD1 = new JLabel("X");
		GridBagConstraints gbc_labelValD1 = new GridBagConstraints();
		gbc_labelValD1.anchor = GridBagConstraints.NORTH;
		gbc_labelValD1.insets = new Insets(0, 0, 5, 5);
		gbc_labelValD1.gridx = 3;
		gbc_labelValD1.gridy = 9;
		getContentPane().add(labelValD1, gbc_labelValD1);
		
		JLabel jLabelPortTCP = new JLabel("Numéro de port TCP :");
		GridBagConstraints gbc_jLabelPortTCP = new GridBagConstraints();
		gbc_jLabelPortTCP.anchor = GridBagConstraints.EAST;
		gbc_jLabelPortTCP.insets = new Insets(0, 0, 5, 5);
		gbc_jLabelPortTCP.gridx = 4;
		gbc_jLabelPortTCP.gridy = 9;
		getContentPane().add(jLabelPortTCP, gbc_jLabelPortTCP);
		
		jTextFieldPort = new JTextField();
		jTextFieldPort.setText(Param.NUM_PORT_DE_BASE+"");
		GridBagConstraints gbc_jTextFieldPort = new GridBagConstraints();
		gbc_jTextFieldPort.insets = new Insets(0, 0, 5, 5);
		gbc_jTextFieldPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldPort.gridx = 5;
		gbc_jTextFieldPort.gridy = 9;
		getContentPane().add(jTextFieldPort, gbc_jTextFieldPort);
		jTextFieldPort.setColumns(10);
		
		JLabelInfo = new JLabel("");
		GridBagConstraints gbc_JLabelInfo = new GridBagConstraints();
		gbc_JLabelInfo.gridwidth = 3;
		gbc_JLabelInfo.insets = new Insets(0, 0, 5, 5);
		gbc_JLabelInfo.gridx = 4;
		gbc_JLabelInfo.gridy = 10;
		getContentPane().add(JLabelInfo, gbc_JLabelInfo);
		
		labelD2 = new JLabel("de2");
		GridBagConstraints gbc_labelD2 = new GridBagConstraints();
		gbc_labelD2.anchor = GridBagConstraints.NORTH;
		gbc_labelD2.insets = new Insets(0, 0, 5, 5);
		gbc_labelD2.gridx = 3;
		gbc_labelD2.gridy = 11;
		getContentPane().add(labelD2, gbc_labelD2);
		
		jButtonConnecter = new JButton("Se connecter");
		jButtonConnecter.addActionListener(this);
		GridBagConstraints gbc_jButtonConnecter = new GridBagConstraints();
		gbc_jButtonConnecter.insets = new Insets(0, 0, 5, 5);
		gbc_jButtonConnecter.gridx = 6;
		gbc_jButtonConnecter.gridy = 11;
		getContentPane().add(jButtonConnecter, gbc_jButtonConnecter);
		
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
		
		labelSoldeJ1 = new JLabel("Solde Joueur 1");
		GridBagConstraints gbc_labelSoldeJ1 = new GridBagConstraints();
		gbc_labelSoldeJ1.anchor = GridBagConstraints.NORTH;
		gbc_labelSoldeJ1.insets = new Insets(0, 0, 5, 5);
		gbc_labelSoldeJ1.gridx = 5;
		gbc_labelSoldeJ1.gridy = 14;
		getContentPane().add(labelSoldeJ1, gbc_labelSoldeJ1);
		
		labelPositionJ1 = new JLabel("Position Joueur 1");
		GridBagConstraints gbc_labelPositionJ1 = new GridBagConstraints();
		gbc_labelPositionJ1.insets = new Insets(0, 0, 5, 5);
		gbc_labelPositionJ1.gridx = 6;
		gbc_labelPositionJ1.gridy = 14;
		getContentPane().add(labelPositionJ1, gbc_labelPositionJ1);
		
		labelValSoldeJ1 = new JLabel("X");
		GridBagConstraints gbc_labelValSoldeJ1 = new GridBagConstraints();
		gbc_labelValSoldeJ1.anchor = GridBagConstraints.NORTH;
		gbc_labelValSoldeJ1.insets = new Insets(0, 0, 5, 5);
		gbc_labelValSoldeJ1.gridx = 5;
		gbc_labelValSoldeJ1.gridy = 15;
		getContentPane().add(labelValSoldeJ1, gbc_labelValSoldeJ1);
		
		labelValPositionJ1 = new JLabel("X");
		GridBagConstraints gbc_labelValPositionJ1 = new GridBagConstraints();
		gbc_labelValPositionJ1.insets = new Insets(0, 0, 5, 5);
		gbc_labelValPositionJ1.gridx = 6;
		gbc_labelValPositionJ1.gridy = 15;
		getContentPane().add(labelValPositionJ1, gbc_labelValPositionJ1);
		
		labelTourPrison = new JLabel("Tours en Prison");
		GridBagConstraints gbc_labelTourPrison = new GridBagConstraints();
		gbc_labelTourPrison.anchor = GridBagConstraints.NORTH;
		gbc_labelTourPrison.insets = new Insets(0, 0, 5, 5);
		gbc_labelTourPrison.gridx = 3;
		gbc_labelTourPrison.gridy = 17;
		getContentPane().add(labelTourPrison, gbc_labelTourPrison);
		
		labelNbTourPrison = new JLabel("X");
		GridBagConstraints gbc_labelNbTourPrison = new GridBagConstraints();
		gbc_labelNbTourPrison.anchor = GridBagConstraints.NORTH;
		gbc_labelNbTourPrison.insets = new Insets(0, 0, 5, 5);
		gbc_labelNbTourPrison.gridx = 4;
		gbc_labelNbTourPrison.gridy = 17;
		getContentPane().add(labelNbTourPrison, gbc_labelNbTourPrison);
		
		labelSoldeJ2 = new JLabel("Solde Joueur 2");
		GridBagConstraints gbc_labelSoldeJ2 = new GridBagConstraints();
		gbc_labelSoldeJ2.anchor = GridBagConstraints.NORTH;
		gbc_labelSoldeJ2.insets = new Insets(0, 0, 5, 5);
		gbc_labelSoldeJ2.gridx = 5;
		gbc_labelSoldeJ2.gridy = 17;
		getContentPane().add(labelSoldeJ2, gbc_labelSoldeJ2);
		
		labelPositionJ2 = new JLabel("Position Joueur 2");
		GridBagConstraints gbc_labelPositionJ2 = new GridBagConstraints();
		gbc_labelPositionJ2.insets = new Insets(0, 0, 5, 5);
		gbc_labelPositionJ2.gridx = 6;
		gbc_labelPositionJ2.gridy = 17;
		getContentPane().add(labelPositionJ2, gbc_labelPositionJ2);
		
		labelValSoldeJ2 = new JLabel("X");
		GridBagConstraints gbc_labelValSoldeJ2 = new GridBagConstraints();
		gbc_labelValSoldeJ2.anchor = GridBagConstraints.NORTH;
		gbc_labelValSoldeJ2.insets = new Insets(0, 0, 5, 5);
		gbc_labelValSoldeJ2.gridx = 5;
		gbc_labelValSoldeJ2.gridy = 18;
		getContentPane().add(labelValSoldeJ2, gbc_labelValSoldeJ2);
		
		labelValPositionJ2 = new JLabel("X");
		GridBagConstraints gbc_labelValPositionJ2 = new GridBagConstraints();
		gbc_labelValPositionJ2.insets = new Insets(0, 0, 5, 5);
		gbc_labelValPositionJ2.gridx = 6;
		gbc_labelValPositionJ2.gridy = 18;
		getContentPane().add(labelValPositionJ2, gbc_labelValPositionJ2);
		
		labelTourSuite = new JLabel("Tours de Suite");
		GridBagConstraints gbc_labelTourSuite = new GridBagConstraints();
		gbc_labelTourSuite.anchor = GridBagConstraints.NORTH;
		gbc_labelTourSuite.insets = new Insets(0, 0, 5, 5);
		gbc_labelTourSuite.gridx = 3;
		gbc_labelTourSuite.gridy = 19;
		getContentPane().add(labelTourSuite, gbc_labelTourSuite);
		
		labelNbTourSuite = new JLabel("X");
		GridBagConstraints gbc_labelNbTourSuite = new GridBagConstraints();
		gbc_labelNbTourSuite.anchor = GridBagConstraints.NORTH;
		gbc_labelNbTourSuite.insets = new Insets(0, 0, 5, 5);
		gbc_labelNbTourSuite.gridx = 4;
		gbc_labelNbTourSuite.gridy = 19;
		getContentPane().add(labelNbTourSuite, gbc_labelNbTourSuite);
		
		buttonFinirTour = new JButton("Finir Tour");
		buttonFinirTour.setEnabled(true);
		buttonFinirTour.addActionListener(this);
		GridBagConstraints gbc_buttonFinirTour = new GridBagConstraints();
		gbc_buttonFinirTour.insets = new Insets(0, 0, 5, 5);
		gbc_buttonFinirTour.gridx = 6;
		gbc_buttonFinirTour.gridy = 21;
		getContentPane().add(buttonFinirTour, gbc_buttonFinirTour);
		
		setVisible(true); // Mettre ça en fin de déclaration pour pas avoir de bug visuel (fenêtre vide)

	}
	
	public void ajouteDansLaConsole(String s){ //Ajouter l'heure comme sur le serveur
		textAreaConsole.append(s);
		textAreaConsole.setCaretPosition(textAreaConsole.getDocument().getLength());
	}

	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Se connecter":
			ClientSocket client;
			try {
				client = new ClientSocket(jTextFieldIP.getText(), Integer.parseInt(jTextFieldPort.getText()),applicationClient);
				client.lireNonStop();
				applicationClient.setSocket(client);
				applicationClient.getGuiClient().ajouteDansLaConsole(
						Console.getInviteDeCommande()+
						"Le joueur est connecté au serveur\n");
				jButtonConnecter.setEnabled(false);
//				buttonLancerDes.setEnabled(false);
//				if(applicationClient.getNum()==1)
//					buttonLancerDes.setEnabled(true);
				buttonAcheter.setEnabled(true);
				buttonVendre.setEnabled(true);
				buttonLoyer.setEnabled(true);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				afficheInfo("Le serveur ne répond pas. Essayez plus tard.");
			}
			break;	
		case "Lancer les dés":
			applicationClient.envoiCommande(e.getActionCommand());
//			buttonLancerDes.setEnabled(false);
//			buttonFinirTour.setEnabled(true);
			break;
		case "Finir Tour":
			applicationClient.envoiCommande(e.getActionCommand());
//			buttonFinirTour.setEnabled(false);
//			buttonAcheter.setEnabled(false);
//			buttonVendre.setEnabled(false);
//			buttonLoyer.setEnabled(false);
			break;
		case "Acheter":
			applicationClient.envoiCommande(e.getActionCommand());
			break;
		case "Demander Loyer":
			//Reste à faire
			break;
		}
	}

	public void afficheInfo(String s){
		JLabelInfo.setText(s);
	}
	
	public void setLabelJoueur(String s){
		labelJoueur.setText(s);
	}
	
	public void setLabelValD1(String s){
		labelValD1.setText(s);
		}
	
	public void setLabelValD2(String s){
		labelValD2.setText(s);
		}

	public void setLabelValSoldeJ1(String s){
		labelValSoldeJ1.setText(s);
		}

	public void setLabelValSoldeJ2(String s){
		labelValSoldeJ2.setText(s);
		}

	public void setLabelValPositionJ1(String s){
		labelValPositionJ1.setText(s);
		}

	public void setLabelValPositionJ2(String s){
		labelValPositionJ2.setText(s);
		}

	public void setLabelNbCartePrison(String s){
		labelNbCartePrison.setText(s);
		}

	public void setLabelNbTourPrison(String s){
		labelNbTourPrison.setText(s);
		}

	public void setLabelNbTourSuite(String s){
		labelNbTourSuite.setText(s);
		}

	public void setButtonLancerDes(boolean b) {
		buttonLancerDes.setEnabled(b);
	}
}