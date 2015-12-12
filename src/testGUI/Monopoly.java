package testGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class Monopoly extends JFrame {

	private JPanel contentPane;
	private JLabel lblDes2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monopoly frame = new Monopoly();
					frame.setVisible(true);
					frame.setTitle("Monopoly");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Monopoly() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 885);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66, 137, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 49, 0, 0, 0, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JTextArea txtrConsole = new JTextArea();
		txtrConsole.setEditable(false);
		GridBagConstraints gbc_txtrConsole = new GridBagConstraints();
		gbc_txtrConsole.gridheight = 6;
		gbc_txtrConsole.gridwidth = 14;
		gbc_txtrConsole.insets = new Insets(0, 0, 5, 5);
		gbc_txtrConsole.fill = GridBagConstraints.BOTH;
		gbc_txtrConsole.gridx = 9;
		gbc_txtrConsole.gridy = 1;
		panel_1.add(txtrConsole, gbc_txtrConsole);
		
		JButton btnLancerDes_1 = new JButton("Lancer les Des");
		GridBagConstraints gbc_btnLancerDes_1 = new GridBagConstraints();
		gbc_btnLancerDes_1.gridwidth = 3;
		gbc_btnLancerDes_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLancerDes_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnLancerDes_1.gridx = 10;
		gbc_btnLancerDes_1.gridy = 8;
		panel_1.add(btnLancerDes_1, gbc_btnLancerDes_1);
		
		JButton btnAcheterMaison = new JButton("Acheter Maison");
		GridBagConstraints gbc_btnAcheterMaison = new GridBagConstraints();
		gbc_btnAcheterMaison.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAcheterMaison.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcheterMaison.gridx = 22;
		gbc_btnAcheterMaison.gridy = 8;
		panel_1.add(btnAcheterMaison, gbc_btnAcheterMaison);
		
		JLabel lblDes1 = new JLabel("de1");
		GridBagConstraints gbc_lblDes1 = new GridBagConstraints();
		gbc_lblDes1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDes1.gridx = 10;
		gbc_lblDes1.gridy = 9;
		panel_1.add(lblDes1, gbc_lblDes1);
		
		lblDes2 = new JLabel("de2");
		GridBagConstraints gbc_lblDes2 = new GridBagConstraints();
		gbc_lblDes2.gridwidth = 3;
		gbc_lblDes2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDes2.gridx = 11;
		gbc_lblDes2.gridy = 9;
		panel_1.add(lblDes2, gbc_lblDes2);
		
		JButton btnAchterHotel = new JButton("Acheter Hotel");
		GridBagConstraints gbc_btnAchterHotel = new GridBagConstraints();
		gbc_btnAchterHotel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAchterHotel.insets = new Insets(0, 0, 5, 5);
		gbc_btnAchterHotel.gridx = 22;
		gbc_btnAchterHotel.gridy = 9;
		panel_1.add(btnAchterHotel, gbc_btnAchterHotel);
		
		JLabel lblValeurd1 = new JLabel("X");
		GridBagConstraints gbc_lblValeurd1 = new GridBagConstraints();
		gbc_lblValeurd1.insets = new Insets(0, 0, 5, 5);
		gbc_lblValeurd1.gridx = 10;
		gbc_lblValeurd1.gridy = 10;
		panel_1.add(lblValeurd1, gbc_lblValeurd1);
		
		JLabel lblValeurd2 = new JLabel("X");
		GridBagConstraints gbc_lblValeurd2 = new GridBagConstraints();
		gbc_lblValeurd2.gridwidth = 3;
		gbc_lblValeurd2.insets = new Insets(0, 0, 5, 5);
		gbc_lblValeurd2.gridx = 11;
		gbc_lblValeurd2.gridy = 10;
		panel_1.add(lblValeurd2, gbc_lblValeurd2);
		
		JButton btnDemanderLoyer = new JButton("Demander Loyer");
		GridBagConstraints gbc_btnDemanderLoyer = new GridBagConstraints();
		gbc_btnDemanderLoyer.fill = GridBagConstraints.VERTICAL;
		gbc_btnDemanderLoyer.insets = new Insets(0, 0, 5, 5);
		gbc_btnDemanderLoyer.gridx = 22;
		gbc_btnDemanderLoyer.gridy = 10;
		panel_1.add(btnDemanderLoyer, gbc_btnDemanderLoyer);
		
		JButton btnFinTour = new JButton("Fin Tour");
		btnFinTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblSoldeJoueur1 = new JLabel("Solde Joueur 1");
		GridBagConstraints gbc_lblSoldeJoueur1 = new GridBagConstraints();
		gbc_lblSoldeJoueur1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldeJoueur1.gridx = 10;
		gbc_lblSoldeJoueur1.gridy = 13;
		panel_1.add(lblSoldeJoueur1, gbc_lblSoldeJoueur1);
		
		JLabel lblSoldeJoueur2 = new JLabel("Solde Joueur 2");
		GridBagConstraints gbc_lblSoldeJoueur2 = new GridBagConstraints();
		gbc_lblSoldeJoueur2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldeJoueur2.gridx = 22;
		gbc_lblSoldeJoueur2.gridy = 13;
		panel_1.add(lblSoldeJoueur2, gbc_lblSoldeJoueur2);
		
		JLabel labelSoldeJ1 = new JLabel("X");
		GridBagConstraints gbc_labelSoldeJ1 = new GridBagConstraints();
		gbc_labelSoldeJ1.fill = GridBagConstraints.VERTICAL;
		gbc_labelSoldeJ1.insets = new Insets(0, 0, 5, 5);
		gbc_labelSoldeJ1.gridx = 10;
		gbc_labelSoldeJ1.gridy = 14;
		panel_1.add(labelSoldeJ1, gbc_labelSoldeJ1);
		
		JLabel labelSoldeJ2 = new JLabel("X");
		GridBagConstraints gbc_labelSoldeJ2 = new GridBagConstraints();
		gbc_labelSoldeJ2.insets = new Insets(0, 0, 5, 5);
		gbc_labelSoldeJ2.gridx = 22;
		gbc_labelSoldeJ2.gridy = 14;
		panel_1.add(labelSoldeJ2, gbc_labelSoldeJ2);
		
		JLabel lblCartesSortezPrison = new JLabel("Cartes Sortez de Prison");
		GridBagConstraints gbc_lblCartesSortezPrison = new GridBagConstraints();
		gbc_lblCartesSortezPrison.insets = new Insets(0, 0, 5, 5);
		gbc_lblCartesSortezPrison.gridx = 10;
		gbc_lblCartesSortezPrison.gridy = 18;
		panel_1.add(lblCartesSortezPrison, gbc_lblCartesSortezPrison);
		
		JLabel lblNbsortezprison = new JLabel("X");
		GridBagConstraints gbc_lblNbsortezprison = new GridBagConstraints();
		gbc_lblNbsortezprison.gridwidth = 3;
		gbc_lblNbsortezprison.insets = new Insets(0, 0, 5, 5);
		gbc_lblNbsortezprison.gridx = 13;
		gbc_lblNbsortezprison.gridy = 18;
		panel_1.add(lblNbsortezprison, gbc_lblNbsortezprison);
		
		JLabel lblToursEnPrison = new JLabel("Tours en Prison");
		GridBagConstraints gbc_lblToursEnPrison = new GridBagConstraints();
		gbc_lblToursEnPrison.insets = new Insets(0, 0, 5, 5);
		gbc_lblToursEnPrison.gridx = 10;
		gbc_lblToursEnPrison.gridy = 19;
		panel_1.add(lblToursEnPrison, gbc_lblToursEnPrison);
		
		JLabel lblNbtourprison = new JLabel("X");
		GridBagConstraints gbc_lblNbtourprison = new GridBagConstraints();
		gbc_lblNbtourprison.gridwidth = 3;
		gbc_lblNbtourprison.insets = new Insets(0, 0, 5, 5);
		gbc_lblNbtourprison.gridx = 13;
		gbc_lblNbtourprison.gridy = 19;
		panel_1.add(lblNbtourprison, gbc_lblNbtourprison);
		
		JLabel lblToursDeSuite = new JLabel("Tours de Suite");
		GridBagConstraints gbc_lblToursDeSuite = new GridBagConstraints();
		gbc_lblToursDeSuite.insets = new Insets(0, 0, 5, 5);
		gbc_lblToursDeSuite.gridx = 10;
		gbc_lblToursDeSuite.gridy = 20;
		panel_1.add(lblToursDeSuite, gbc_lblToursDeSuite);
		
		JLabel lblNbtoursuite = new JLabel("X");
		GridBagConstraints gbc_lblNbtoursuite = new GridBagConstraints();
		gbc_lblNbtoursuite.gridwidth = 3;
		gbc_lblNbtoursuite.insets = new Insets(0, 0, 5, 5);
		gbc_lblNbtoursuite.gridx = 13;
		gbc_lblNbtoursuite.gridy = 20;
		panel_1.add(lblNbtoursuite, gbc_lblNbtoursuite);
		GridBagConstraints gbc_btnFinTour = new GridBagConstraints();
		gbc_btnFinTour.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFinTour.insets = new Insets(0, 0, 5, 5);
		gbc_btnFinTour.gridx = 22;
		gbc_btnFinTour.gridy = 25;
		panel_1.add(btnFinTour, gbc_btnFinTour);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{850, 0};
		gbl_panel.rowHeights = new int[]{850, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblBoardGame = new JLabel("");
		lblBoardGame.setIcon(new ImageIcon("./boardgame4.jpg"));
		GridBagConstraints gbc_lblBoardGame = new GridBagConstraints();
		gbc_lblBoardGame.insets = new Insets(0, 0, 5, 0);
		gbc_lblBoardGame.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblBoardGame.gridx = 0;
		gbc_lblBoardGame.gridy = 0;
		panel.add(lblBoardGame, gbc_lblBoardGame);
		
	}

}