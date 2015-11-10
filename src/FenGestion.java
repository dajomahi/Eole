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

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class FenGestion extends JFrame{
	
	/**
	 * Version 1.0.0.1
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] buttons = new JButton[20]; 
	private JPanel p = new JPanel();
	private GridLayout l = new GridLayout(5,10,10,10);
	private Image bateau=null;
	
	public FenGestion(){
		//preprossesing
		this.setPreferredSize(new Dimension(700,500));
		this.setTitle("Eole Gestion");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(p);
		p.setLayout(l);
		p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		initButtons();
		// Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();
         
        // Add the menubar to the frame
        setJMenuBar(menuBar);
         
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
         
        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("New");
        JMenuItem openAction = new JMenuItem("Open");
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem cutAction = new JMenuItem("Cut");
        JMenuItem copyAction = new JMenuItem("Copy");
        JMenuItem pasteAction = new JMenuItem("Paste");
         
        // Create a ButtonGroup and add both radio Button to it. Only one radio
        // button in a ButtonGroup can be selected at a time.
        @SuppressWarnings("unused")
		ButtonGroup bg = new ButtonGroup();
        fileMenu.add(newAction);
        fileMenu.add(openAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        editMenu.addSeparator();
        // Add a listener to the New menu item. actionPerformed() method will
        // invoked, if user triggred this menu item
        newAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("You have clicked on the new action");
            }
        });
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
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			p.add(buttons[i]);
		}
	}
	
}
