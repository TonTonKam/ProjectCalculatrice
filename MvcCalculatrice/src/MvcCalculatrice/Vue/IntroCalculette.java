package MvcCalculatrice.Vue;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

public class IntroCalculette extends JFrame{

	public IntroCalculette() {
		
		final int HT = 1024;
		final int LG = 768;
				    
		JFrame i = new JFrame("Introduction");
		//regler la taille
		i.setSize(HT,LG);
		i.setLocationRelativeTo(null);
		//ecoute de la fenetre
		i.addWindowListener(new gestionFenetre());
		//localisation de l'image
		ImageIcon icone = new ImageIcon("image.jpg"); 
		JLabel image = new JLabel(icone);
		i.add(image);
		i.setVisible(true);
		}
	}
	class gestionFenetre extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
	}
}	


