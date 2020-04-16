package MvcCalculatrice.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import MvcCalculatrice.Model.Calcul;
import MvcCalculatrice.Model.ThreadClotureCalculatrice;
import MvcCalculatrice.Vue.IntroCalculette;
import MvcCalculatrice.Vue.ScoringCalculatrice;
import MvcCalculatrice.Vue.VueCalculatrice;

public class ControleurCalculatrice{

	//attributs
	private Calcul calc;
	private VueCalculatrice vue;
	private ThreadClotureCalculatrice cloture;
	private ScoringCalculatrice scoring;
	private Timer wait = new Timer();
	
	private int resultat;
	private int compteur;
	private int erreur = 0;
	private int score = 0;
	private int nbDeCalcul = 0;
	private int res = 0;
	
	//constructeur
	public ControleurCalculatrice (Calcul c, VueCalculatrice v) {
		this.calc = c;
		vue = v;

		vue.getBoutonComparer().addActionListener(new BoutonComparer());
		vue.getBoutonIncrementation1().addActionListener(new BoutonIncremListener1());
		vue.getBoutonDecrementation1().addActionListener(new BoutonDecreListener1());
	
		vue.addWindowListener(new java.awt.event.WindowAdapter() {	    	
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	procedureDeFermeture();
		    }
		});
		
		this.genererCalcul();
		
	}
	
	//methodes
	public void genererCalcul() {
		//genere un calcul aleatoire de 5 additions sur 6 soustractions
		int r  = (int)(Math.random() * 10);
		if(r > 4 ) {
			this.valeurRanAddition();
		}else {
			this.valeurRanSoustraction();
		}
		//raz
		vue.setLabelResultat("");
		vue.setLabelChiffre1(0);
		vue.setLabelChiffre1Bis(0);
		vue.getBoutonComparer().setEnabled(true);
		compteur = 0;
		erreur = 0;
		res = 0;
	}

	public void valeurRanAddition() {
		//genere chiffres et envoi vers l'addition
		int num1 = calc.getNum1();
		int num2 = calc.getNum2();
		num1 = (int)(Math.random()*((9 - 0)+1));
		num2 = (int)(Math.random()*(10 - num1) + 1);
		calc.setNum1(num1);
		calc.setNum2(num2);
		
		vue.setLabelChiffreR1(calc.getNum1());
		vue.setLabelChiffreR2(calc.getNum2());
		vue.setLabelCalcul("+");
	}

	
	public void valeurRanSoustraction() {
		//genere chiffres et envoi vers la soustraction
		int num1 = calc.getNum1();
		int num2 = calc.getNum2();
		num1 = (int)(Math.random()*((9 - 0)+1));
		num2 = (int)(Math.random()*(num1 - 1) +1);
		calc.setNum1(num1);
		calc.setNum2(num2);
		
		vue.setLabelChiffreR1(calc.getNum1());
		vue.setLabelChiffreR2(calc.getNum2());
		vue.setLabelCalcul("-");
	}
	
	public void verifierAddition() {
		//valeur du resultat verifie avec le resultat de l'operation choisi
		if(resultat == calc.additionRandom()) {
			vue.getBoutonComparer().setEnabled(false);
			vue.infoLabelResultat("Bien joué mais te la péte pas trop!");
			//valeur ajouter pour calculer ne nombre de calcul réalisé
			nbDeCalcul++;
			//creation de score
			score++;
			wait.schedule(new TimerTask() {
				public void run() {
					comptabiliserScore();
				}
			},2000 // les secondes du délais (1000 = 1sec)
			);
			
		}else {
			//res permet d'afficher le nombre d'essai restant
			erreur++;
			res = 4 - erreur;
			vue.setLabelResultat("Plus que "+(res-1)+" entatives");
			if(res == 1) {
				vue.getBoutonComparer().setEnabled(false);
				vue.infoLabelResultat("Le resultat était : "+calc.additionRandom()+" entraine toi plus!");
				nbDeCalcul++;
				wait.schedule(new TimerTask() {
					public void run() {
						comptabiliserScore();
					}
				},2000 // les secondes du délais (1000 = 1sec)
				);
				
			}
		}
	}
	
	public void verifierSoustraction() {
		//valeur du resultat verifie avec le resultat de l'operation choisi
		if(resultat == calc.soustractionRandom()) {
			vue.getBoutonComparer().setEnabled(false);
			vue.infoLabelResultat("Bien joué mais te la péte pas trop!");
			//valeur ajouter pour calculer ne nombre de calcul réalisé
			nbDeCalcul++;
			//creation de score
			score++;
			wait.schedule(new TimerTask() {
				public void run() {
					comptabiliserScore();
				}
			},5000 // les secondes du délais (1000 = 1sec)
			);
			
		}else {
			//res permet d'afficher le nombre d'essai restant
			erreur++;
			res = 4 - erreur;
			vue.setLabelResultat("Plus que "+(res-1)+" entatives");
			if(res == 1) {
				vue.getBoutonComparer().setEnabled(false);
				vue.infoLabelResultat("Le resultat était : "+calc.soustractionRandom()+" entraine toi plus!");
				nbDeCalcul++;
				wait.schedule(new TimerTask() {
					public void run() {
						comptabiliserScore();
					}
					
				},5000 // les secondes du délais (1000 = 1sec)
				);
			}
		}
	}
	public void comptabiliserScore() {
		
		int calculEffectue = nbDeCalcul;
		
		if(calculEffectue < 7 && calculEffectue >= 0) {
			genererCalcul();
		}else {
			vue.getBoutonComparer().setEnabled(false);
			vue.getBoutonDecrementation1().setEnabled(false);
			vue.getBoutonIncrementation1().setEnabled(false);
			
			scoring = new ScoringCalculatrice();
			scoring.setLabelScore1(""+score);
			
			cloture = new ThreadClotureCalculatrice();
			//renvoyer resultat sur la page de fin
			wait.schedule(new TimerTask() {
				public void run() {
					cloture.start();
				}
			
			},1000 // les secondes du délais (1000 = 1sec)
			);
		}
	}
	
	public void procedureDeFermeture() {
		IntroCalculette intro1 = new IntroCalculette();
    	Timer fermeture = new Timer();
		fermeture.schedule(new TimerTask() {
			public void run() {
				System.exit(0);
			}
		},3000 // les secondes du délais (1000 = 1sec)
		);
	}
	

	//Classe écoutant
	class BoutonIncremListener1 implements ActionListener{
		
	//Redéfinition de la méthode actionPerformed()
	//note perso : l'action performed prend la 1er valeur qui lui vient comme la sienne
		public void actionPerformed(ActionEvent e) {
			//creation du compteur bloqué entre 0 et 10
			if(compteur >= 0 && compteur < 10) {
				compteur++;
				resultat = compteur;

				vue.setLabelChiffre1(resultat);
				vue.setLabelChiffre1Bis(resultat);
			}
		}
	}
	
	//Classe écoutant notre second bouton
	class BoutonDecreListener1 implements ActionListener{
		
	//Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			if(compteur > 0 && compteur <= 10) {
				compteur--;
				resultat = compteur;

				vue.setLabelChiffre1(resultat);
				vue.setLabelChiffre1Bis(resultat);
			}
		}
	} 

	//Classe écoutant notre bouton comparer
	class BoutonComparer implements ActionListener{
		
	//Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			String symbole;
			//valeur du resultat verifie avec le resultat de l'operation choisi
			symbole = vue.getLabelCalcul();
			if(symbole == "+") {
				verifierAddition();
			}
			else if(symbole == "-") {
				verifierSoustraction();
			}
		}
	}

} //fin
