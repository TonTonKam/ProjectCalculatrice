package MvcCalculatrice.Model;

import java.util.Timer;

import MvcCalculatrice.Vue.IntroCalculette;
import MvcCalculatrice.Vue.ScoringCalculatrice;

public class ThreadClotureCalculatrice extends Thread{

	private IntroCalculette intro;
	private ScoringCalculatrice score;
	private int periodeFenetre = 3;
	
	public void run() {
		
		score = new ScoringCalculatrice();
		
		try {
			sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		score.dispose();
		intro = new IntroCalculette();
		
		try {
			sleep(periodeFenetre * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.exit(0);

	}//run fin
} //fin
