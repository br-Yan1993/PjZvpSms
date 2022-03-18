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

import control.ConvertTxtToZvp;
import control.DeleteFile;
import control.ExtrairZipEtiqueta;
import control.LinkToDown;
import control.PrintPdf;

public class AbrirLink {
	
	DeleteFile del = new DeleteFile();
	LinkToDown linkDown = new LinkToDown();
	ExtrairZipEtiqueta ext = new ExtrairZipEtiqueta();
	ConvertTxtToZvp c = new ConvertTxtToZvp();
	PrintPdf impDesk = new PrintPdf();
	
	JFrame frameInit = new JFrame("Impressor ZVP-PDF");
	
	JTextField txtFieldUrl = new JTextField("1140227");
	JLabel lblLink = new JLabel("Insira ou Leia o Numero do Pedido abaixo:");
	JButton btnSend = new JButton("Enviar");
	
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
		
		btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent launchScn) {
					try {
					del.deleteFile();//OK
					linkDown.openAndDownZip(txtFieldUrl.getText(), 0000);//OK
					ext.extrateZip(3000);
					c.convertIntoPdf(3000);
					impDesk.printFileEtiqueta(3000);
					
					Thread.sleep(3000);
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
			    		   del.deleteFile();//OK
			    		   linkDown.openAndDownZip(txtFieldUrl.getText(), 0000);//OK
			    		   ext.extrateZip(3000);
			    		   c.convertIntoPdf(3000);
			    		   impDesk.printFileEtiqueta(3000);
			    		   
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
	
	public static void main(String[] args) {
		
		AbrirLink tela = new AbrirLink();
		tela.criarTela();
		
	}

}
