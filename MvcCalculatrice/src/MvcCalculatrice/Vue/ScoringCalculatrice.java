package MvcCalculatrice.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoringCalculatrice extends JFrame {
	
	private JPanel pane = new JPanel();
	
	final int ht = 300;
	final int lg = 300;
	
	private JLabel labelScore1 = new JLabel("0");
	private JLabel labelScore2 = new JLabel("0");
	private JLabel labelAffichage1 = new JLabel("Votre score : ");
	private JLabel labelAffichage2 = new JLabel("Le meilleur score : ");
	private JLabel labelNom1 = new JLabel("nom");
	private JLabel labelNom2 = new JLabel("nom");
	private JLabel labelPrenom = new JLabel("prenom");
	
	public ScoringCalculatrice() {
						    
		//regler la taille
		setSize(ht,lg);
		//definir un titre pour le cadre
		setTitle("Calculatrice Enfant");
		setLocationRelativeTo(null);
		// ne termine pas le processus lorsque l'on clique "fermer"
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//option du panel
		pane.setLayout(new BorderLayout());
		
		//positionnement des boutons en haut avec changement de style de police et de couleur
		JPanel north = new JPanel();
		//creation de l'objet police qui fait appel a la classe font de java
		Font police = new Font("Tahoma", Font.BOLD, 16);
		labelAffichage1.setFont(police);
		labelAffichage1.setForeground(Color.black);
		labelNom1.setFont(police);
		labelNom1.setForeground(Color.gray);
		labelScore1.setFont(police);
		labelScore1.setForeground(Color.red);
		
		labelAffichage2.setForeground(Color.black);
		labelAffichage2.setFont(police);
		labelNom2.setForeground(Color.gray);
		labelNom2.setFont(police);
		labelPrenom.setForeground(Color.gray);
		labelPrenom.setFont(police);
		labelScore2.setForeground(Color.orange);
		labelScore2.setFont(police);
		
		north.add(labelAffichage1);
	    north.add(labelNom1);
	    north.add(labelScore1);
	    pane.add(north, BorderLayout.NORTH);
		
		//position centrer
	    JPanel center = new JPanel();
	    
	    center.add(labelAffichage2);
	    center.add(labelNom2);
	    center.add(labelPrenom);
	    center.add(labelScore2);
	    pane.add(center, BorderLayout.CENTER);
	    
		setVisible(true);
		
		//attribuer ce panel a la fenetre
		this.setContentPane(pane);
	}

	//getter & setter
	
	public void setLabelScore1(String string) {
		labelScore1.setText(string);
	}

	public void setLabelScore2(String string) {
		labelScore2.setText(string);
	}

	public void setLabelAffichage1(String string) {
		labelAffichage1.setText(string);
	}

	public void setLabelAffichage2(String string) {
		labelAffichage2.setText(string);
	}

	public void setLabelNom1(String string) {
		labelNom1.setText(string);
	}

	public void setLabelNom2(String string) {
		labelNom2.setText(string);
	}

	public void setLabelPrenom(String string) {
		labelPrenom.setText(string);
	}

}
