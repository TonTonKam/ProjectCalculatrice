package MvcCalculatrice.Model;

import MvcCalculatrice.Controleur.ControleurCalculatrice;
import MvcCalculatrice.Vue.IntroCalculette;
import MvcCalculatrice.Vue.VueCalculatrice;

public class ThreadLancementCalculette extends Thread{
	private int sec;
	
	private int periodeFenetre = 10;
	private IntroCalculette intro;
	
	public ThreadLancementCalculette() {
		sec = 0;
	}
	
	public void run() {

		intro = new IntroCalculette();
		
		while(true) {
			
			// Incrementer les secondes
			sec++;
						
			//fermer l'intro de lancement
			if(sec == periodeFenetre) {
				intro.dispose();
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
