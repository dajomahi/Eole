package application;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FenGestion extends JFrame{
	
	private JButton[] buttons = new JButton[20]; 
	private JPanel p;
	private GridLayout l = new GridLayout(0,10);
	
	public FenGestion(){
		//preprossesing
		this.setPreferredSize(new Dimension(700,500));
		this.setTitle("Eole Gestion");
		this.getContentPane().add(p);
		p.setLayout(l);
		//post processing
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
}
