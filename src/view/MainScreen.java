package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.Execute;

public class MainScreen {
	
	JFrame frameInit = new JFrame("Impressor ZVP-PDF");
	
	JTextField txtFieldUrl = new JTextField("1140227");
	JLabel lblLink = new JLabel("Insira ou Leia o Numero do Pedido abaixo:");
	JButton btnSend = new JButton("Enviar");
	
	public void launchScreen() {
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
		
		btnSend.addActionListener(new Execute());
	}

}
