package testGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JToolBar;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Appli extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appli frame = new Appli();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Appli() {
		setTitle("Monopoly");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1136, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 69, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 21;
		gbc_panel.gridheight = 16;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 10;
		gbc_panel.gridy = 6;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 7;
		gbc_textArea.gridwidth = 15;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 31;
		gbc_textArea.gridy = 6;
		contentPane.add(textArea, gbc_textArea);
		
		JButton btnNewButton_1 = new JButton("Lancer les des");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 6;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 31;
		gbc_btnNewButton_1.gridy = 13;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnAcheterMaison = new JButton("Acheter maison");
		GridBagConstraints gbc_btnAcheterMaison = new GridBagConstraints();
		gbc_btnAcheterMaison.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAcheterMaison.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcheterMaison.gridx = 45;
		gbc_btnAcheterMaison.gridy = 13;
		contentPane.add(btnAcheterMaison, gbc_btnAcheterMaison);
		
		JButton btnAcheterHtel = new JButton("Acheter hotel");
		btnAcheterHtel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAcheterHtel = new GridBagConstraints();
		gbc_btnAcheterHtel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAcheterHtel.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcheterHtel.gridx = 45;
		gbc_btnAcheterHtel.gridy = 14;
		contentPane.add(btnAcheterHtel, gbc_btnAcheterHtel);
		
		JButton btnDemanderLoyer = new JButton("Demander loyer");
		GridBagConstraints gbc_btnDemanderLoyer = new GridBagConstraints();
		gbc_btnDemanderLoyer.insets = new Insets(0, 0, 5, 5);
		gbc_btnDemanderLoyer.gridx = 45;
		gbc_btnDemanderLoyer.gridy = 15;
		contentPane.add(btnDemanderLoyer, gbc_btnDemanderLoyer);
		
		JButton btnAcheter = new JButton("Fin tour");
		GridBagConstraints gbc_btnAcheter = new GridBagConstraints();
		gbc_btnAcheter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAcheter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcheter.gridx = 45;
		gbc_btnAcheter.gridy = 21;
		contentPane.add(btnAcheter, gbc_btnAcheter);
	}
}
