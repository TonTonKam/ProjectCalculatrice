package MvcCalculatrice.Model;

import MvcCalculatrice.Controleur.ControleurCalculatrice;
import MvcCalculatrice.Vue.IntroCalculette;
import MvcCalculatrice.Vue.VueCalculatrice;

public class ThreadCalculette extends Thread{
	private int sec;
	private int min;
	private int heure;
	
	private int periodeFenetre = 10;
	private IntroCalculette intro;
	
	
	public ThreadCalculette() {
		sec = 0;
		min = 0;
		heure = 0;
	}
	

	public void run() {
		
		intro = new IntroCalculette();
		
		while(true) {
			
			// Incrementer les secondes
			sec++;
			
			if(sec == 60) {
				sec = 0;
				
				// Incrementer les minutes
				min++;
				if(min == 60) {
					// Incrementer les heures
					min = 0;
					sec = 0;
					heure++;
				}
			}
			//test info
			System.out.println("H:"+heure +" M:"+min+" S:"+sec);
			//fermer l'intro de lancement
			if(sec == periodeFenetre) {
				intro.dispose();
				// Lancer une autre fenetre
			}
			
			//creer la calculatrice
			if(sec == periodeFenetre) {
				Calcul calc = new Calcul();
				VueCalculatrice vue = new VueCalculatrice();
				ControleurCalculatrice ctrl = new ControleurCalculatrice(calc, vue);
			}
			
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

}
