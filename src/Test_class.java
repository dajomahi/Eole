import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class Test_class {
	
	public static void main(String[] args){
		
		JOptionPane p = new JOptionPane();
		
		if(Desktop.isDesktopSupported()){
			
			try {
				
				Desktop.getDesktop().browse(new URI(Test_class2.url));
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			} catch (URISyntaxException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		p.showMessageDialog(null, "Ceci est un test.");

		
		
		
	}
	
}
