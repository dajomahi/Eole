package app;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;


public class FenGestion extends JFrame{
	
	/**
	 * Version 1.0.0.1
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] buttons = new JButton[20]; 
	private JPanel p = new JPanel();
	private GridLayout l = new GridLayout(5,10,10,10);
	private Image bateau=null;
	private List<Voilier> lesVoiliers = new ArrayList<Voilier>();
	private JTextField tfHeureDepart;
	private JTextField tfDistanceMiles;
	
	public FenGestion(){
		//preprocessing
		setPreferredSize(new Dimension(700,500));
		setTitle("Eole Gestion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(p);
		p.setLayout(l);
		p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		for (int i = 0; i < 20; i++) {
			Voilier vl = new Voilier(i, "", 0, 0);
			lesVoiliers.add(vl);
		}
		
		JButton btClassement = new JButton("Classement");
		btClassement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ouvrir une nouvelle fenêtre avec un tableau représentant le classement des Voiliers (cf. pdf énoncé).
			}
		});
		
		JLabel lblMiles = new JLabel("1 Miles = 1.6 Km");
		lblMiles.setForeground(new Color(0, 139, 139));
		panel.add(lblMiles);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setVisible(false);
		panel.add(horizontalStrut);
		
		JLabel lbDistanceMiles = new JLabel("Distance (Miles) :");
		panel.add(lbDistanceMiles);
		
		tfDistanceMiles = new JTextField();
		tfDistanceMiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Voilier.setDistanceEnMiles(Double.valueOf(lbDistanceMiles.getText()));
				System.out.println("Ok !");
			}
		});
		tfDistanceMiles.setText("1");
		panel.add(tfDistanceMiles);
		tfDistanceMiles.setColumns(10);
		
		JLabel lbHeureDepart = new JLabel("Heure de d\u00E9part :");
		panel.add(lbHeureDepart);
		
		tfHeureDepart = new JTextField();
		tfHeureDepart.setText("00:00:00");
		panel.add(tfHeureDepart);
		tfHeureDepart.setColumns(10);
		panel.add(btClassement);

		initButtons();
        
		//post processing
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void initButtons(){
		//load background picture
		try {
			bateau = ImageIO.read(new File("res/bateau.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//We implement the buttons
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton();
			buttons[i].setText((i+1)+"");
			buttons[i].setIcon(new ImageIcon(bateau));
			buttons[i].setFocusPainted(false);
			//Resize listener updates the icon's size
			buttons[i].addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    JButton btn = (JButton) e.getComponent();
                    Dimension size = btn.getSize();
                    Insets insets = btn.getInsets();
                    size.width -= insets.left + insets.right;
                    size.height -= insets.top + insets.bottom;
                    if (size.width > size.height) {
                        size.width = -1;
                    } else {
                        size.height = -1;
                    }
                    Image scaled = bateau.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
                    btn.setIcon(new ImageIcon(scaled));
                }

            });
			//Action listener for when a button has an event
			buttons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent ae) {
					int numVoilier = Integer.valueOf(ae.getActionCommand());
					@SuppressWarnings("unused")
					FenModVoilier fnVoilier = new FenModVoilier(numVoilier, lesVoiliers);
				}
			});
			p.add(buttons[i]);
		}
	}
	
}
