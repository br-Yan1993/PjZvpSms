import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

import javax.print.PrintException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AbrirLink {
	
	JFrame frameInit = new JFrame("Impressor ZVP-PDF");
		
	JTextField txtFieldUrl = new JTextField();
	JLabel lblLink = new JLabel("Insira ou Leia o Numero do Pedido abaixo:");
	JButton btnSend = new JButton("Enviar");
	ConvertZvp c = new ConvertZvp();
	ImprimeDesk impDesk = new ImprimeDesk();
	ExtrairZip ext = new ExtrairZip();
	DeleteFiles d = new DeleteFiles();
	
	public void criarTela() {
		frameInit.setSize(650, 190);
		frameInit.setVisible(true);
		frameInit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInit.setLayout(null);
		frameInit.setResizable(false);
		frameInit.setLocation(1200, 100);
		
		lblLink.setBounds(15, 5, 260, 45);
		
		btnSend.setToolTipText("Enviar");
		
		btnSend.setBackground(Color.WHITE);
		
		frameInit.add(txtFieldUrl);
		frameInit.add(btnSend);
		frameInit.add(lblLink);
		
		txtFieldUrl.setBounds(16, 110, 600, 25);
		btnSend.setBounds(16, 60, 150, 25);
		
		txtFieldUrl.requestFocus();
		
//		ac.ac(txtFldLocalIpServer, btnSend);
		
		btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent launchScn) {
					try {
					d.deleteFile();
					AbrirLink.openWebpage(txtFieldUrl.getText());
					ext.ext();
					c.start();
					impDesk.imprimeDesktop();
					Thread.sleep(2000);
					txtFieldUrl.setText("");
					frameInit.setFocusable(true);
					txtFieldUrl.requestFocus();
			        }
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				
			});
		
		txtFieldUrl.addKeyListener(new KeyListener() {
		public void keyPressed(KeyEvent e) {
			       if(e.getKeyCode() == KeyEvent.VK_ENTER){
			    	   try {
			    		   d.deleteFile();
			    		   AbrirLink.openWebpage(txtFieldUrl.getText());
			    		   ext.ext();
							c.start();
			    		   impDesk.imprimeDesktop();
			    		   Thread.sleep(2000);
			    		   txtFieldUrl.setText("");
			    		   frameInit.setFocusable(true);
			    		   txtFieldUrl.requestFocus();
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (PrintException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			   }
		}
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void openWebpage(String urlString) {
	    try {
	    	Thread.sleep(1000);
	        Desktop.getDesktop().browse(new URL("https://www.supermotoshop.com.br/mvc/adm/mercado_livre/etiquetas/imprimir/0/zpl2?pedidos=" + urlString).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		
		AbrirLink tela = new AbrirLink();
		tela.criarTela();
		
	}

}
