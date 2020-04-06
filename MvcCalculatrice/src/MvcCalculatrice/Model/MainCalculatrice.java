package MvcCalculatrice.Model;

import MvcCalculatrice.Vue.IntroCalculette;
import MvcCalculatrice.Vue.VueCalculatrice;
import MvcCalculatrice.Controleur.ControleurCalculatrice;
import MvcCalculatrice.Model.Calcul;

public class MainCalculatrice {

	public static void main(String[] args) {
		
		//objet
		IntroCalculette intro = new IntroCalculette();
		
		Calcul calc = new Calcul();
		VueCalculatrice vue = new VueCalculatrice();
		//utiliser les valeurs des objets (il sait que le constructeur a 2 resultats a mettre)
		ControleurCalculatrice ctrl = new ControleurCalculatrice(calc, vue);
		
	}
}
