package MvcCalculatrice.Model;

import MvcCalculatrice.Controleur.ControleurCalculatrice;
import MvcCalculatrice.Vue.IntroCalculette;
import MvcCalculatrice.Vue.VueCalculatrice;

public class ThreadLancementCalculette extends Thread{
	
	private int periodeFenetre = 3;
	private IntroCalculette intro;
	
	public void run() {

		intro = new IntroCalculette();
		
		try {
			sleep(periodeFenetre * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		intro.dispose();
		Calcul calc = new Calcul();
		VueCalculatrice vue = new VueCalculatrice();
		ControleurCalculatrice controle = new ControleurCalculatrice(calc, vue);
		

	} //fin run
} //fin
