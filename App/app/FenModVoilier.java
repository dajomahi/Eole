package app;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

@SuppressWarnings("serial")
public class FenModVoilier extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNom;
	private JTextField tfClasse;
	private JTextField tfSkipper;
	private JTextField tfRating;
	private JTextField tfTempsReel;
	private JTextField tfHeureArrivee;

	public FenModVoilier(int numVoilier, List<Voilier> lesVoiliers) {
		setTitle("Voilier n°" + numVoilier);
		setBounds(100, 100, 450, 200);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbNom = new JLabel("Nom :");
		lbNom.setBounds(10, 11, 70, 14);
		contentPanel.add(lbNom);
		
		tfNom = new JTextField();
		tfNom.setBounds(90, 8, 160, 20);
		contentPanel.add(tfNom);
		tfNom.setColumns(10);
		
		JLabel lbClasse = new JLabel("Classe :");
		lbClasse.setBounds(260, 11, 70, 14);
		contentPanel.add(lbClasse);
		
		tfClasse = new JTextField();
		tfClasse.setBounds(340, 8, 86, 20);
		contentPanel.add(tfClasse);
		tfClasse.setColumns(10);
		
		JLabel lbSkipper = new JLabel("Skipper :");
		lbSkipper.setBounds(10, 36, 70, 14);
		contentPanel.add(lbSkipper);
		
		tfSkipper = new JTextField();
		tfSkipper.setBounds(90, 33, 160, 20);
		contentPanel.add(tfSkipper);
		tfSkipper.setColumns(10);
		
		JLabel lbRating = new JLabel("Rating :");
		lbRating.setBounds(260, 36, 70, 14);
		contentPanel.add(lbRating);
		
		tfRating = new JTextField();
		tfRating.setBounds(340, 33, 86, 20);
		contentPanel.add(tfRating);
		tfRating.setColumns(10);
		
		JLabel lbTempsReel = new JLabel("Temps :");
		lbTempsReel.setBounds(10, 86, 97, 14);
		contentPanel.add(lbTempsReel);
		
		tfTempsReel = new JTextField();
		tfTempsReel.setBounds(127, 83, 123, 20);
		contentPanel.add(tfTempsReel);
		tfTempsReel.setColumns(10);
		
		JCheckBox cbAbandon = new JCheckBox("Abandon");
		cbAbandon.setBounds(254, 56, 97, 23);
		contentPanel.add(cbAbandon);
		
		JCheckBox cbHandicap = new JCheckBox("Handicap");
		cbHandicap.setBounds(254, 82, 97, 23);
		contentPanel.add(cbHandicap);
		
		JLabel lblHeureArrivee = new JLabel("Heure d'arriv\u00E9e :");
		lblHeureArrivee.setBounds(10, 61, 97, 14);
		contentPanel.add(lblHeureArrivee);
		
		tfHeureArrivee = new JTextField();
		tfHeureArrivee.setColumns(10);
		tfHeureArrivee.setBounds(127, 57, 123, 20);
		contentPanel.add(tfHeureArrivee);
		
		//Valeures insérées
		tfClasse.setText("" + lesVoiliers.get(numVoilier).getClasseVoilier());
		tfHeureArrivee.setText("" + lesVoiliers.get(numVoilier).getHeureArrivee());
		tfNom.setText("" + lesVoiliers.get(numVoilier).getNomVoilier());
		tfRating.setText("" + lesVoiliers.get(numVoilier).getRating());
		tfSkipper.setText("" + lesVoiliers.get(numVoilier).getNomSkipper());
		tfTempsReel.setText("" + lesVoiliers.get(numVoilier).tempsReel());
		cbAbandon.setSelected(lesVoiliers.get(numVoilier).isAbandon());
		cbHandicap.setSelected(lesVoiliers.get(numVoilier).isHandicap());
		
		JButton btAnnuler = new JButton("Annuler");
		btAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btAnnuler.setBounds(337, 128, 89, 23);
		contentPanel.add(btAnnuler);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lesVoiliers.get(numVoilier).setClasseVoilier(Integer.valueOf(tfClasse.getText()));
				lesVoiliers.get(numVoilier).setHandicap(cbHandicap.isSelected());
				lesVoiliers.get(numVoilier).setNomVoilier(tfNom.getText());
				lesVoiliers.get(numVoilier).setRating(Integer.valueOf(tfRating.getText()));
				lesVoiliers.get(numVoilier).setNomSkipper(tfSkipper.getText());
				lesVoiliers.get(numVoilier).setAbandon(cbAbandon.isSelected());
				dispose();
			}
		});
		btOk.setBounds(241, 128, 89, 23);
		contentPanel.add(btOk);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
