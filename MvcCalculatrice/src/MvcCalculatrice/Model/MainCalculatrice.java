package MvcCalculatrice.Model;

import MvcCalculatrice.Vue.IntroCalculette;
import MvcCalculatrice.Vue.VueCalculatrice;
import MvcCalculatrice.Controleur.ControleurCalculatrice;
import MvcCalculatrice.Model.Calcul;

public class MainCalculatrice {

	public static void main(String[] args) {
		
		ThreadLancementCalculette t = new ThreadLancementCalculette();
		
		t.start();
	}
}
