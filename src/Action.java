import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Action {
	
	ConvertZvp c = new ConvertZvp();
	ImprimeDesk impDesk = new ImprimeDesk();
	ExtrairZip ext = new ExtrairZip();
	
	public void ac(JTextField jt, JButton jb) {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent launchScn) {
				try {
					
				
					File fl1 = new File("C:\\Users\\Master\\Desktop\\DownZip\\etiquetas.zip");
					File fl2 = new File("C:\\Users\\Master\\Desktop\\Etiquetas\\Controle.pdf");
					File fl3 = new File("C:\\Users\\Master\\Desktop\\Etiquetas\\Etiqueta de envio.pdf");
					File fl4 = new File("C:\\Users\\Master\\Desktop\\Etiquetas\\Etiqueta de envio.txt");
					
					try {
					fl1.delete();
					fl2.delete();
					fl3.delete();
					fl4.delete();
					}
					catch (Exception e) {
						e.printStackTrace();
					}	
					
				AbrirLink.openWebpage(jt.getText());
				ext.ext();
				c.start();
				impDesk.imprimeDesktop();
//				System.out.println("Deu Certo");
				jt.setText("");
		        }
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
}
