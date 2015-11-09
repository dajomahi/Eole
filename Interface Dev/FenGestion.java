import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FenGestion extends JFrame{
	
	private JButton[] buttons = new JButton[20]; 
	private JPanel p;
	
	public FenGestion(){
		//preprossesing
		this.setPreferredSize(new Dimension(700,500));
		this.setTitle("Eole Gestion");
		this.getContentPane().add(p);
		//post processing
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
}
