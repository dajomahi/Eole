import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FenGestion extends JFrame{
	
	private JButton[] buttons = new JButton[20]; 
	private JPanel p = new JPanel();
	private GridLayout l = new GridLayout(0,10);
	
	public FenGestion(){
		//preprossesing
		this.setPreferredSize(new Dimension(700,500));
		this.setTitle("Eole Gestion");
		this.getContentPane().add(p);
		p.setLayout(l);
		initButtons();
		//post processing
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public void initButtons(){
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton();
			buttons[i].setText(i+"");
			buttons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			p.add(buttons[i]);
		}
	}
	
}
