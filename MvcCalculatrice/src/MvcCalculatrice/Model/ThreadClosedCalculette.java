package MvcCalculatrice.Model;

import java.awt.event.WindowAdapter;

import MvcCalculatrice.Vue.VueCalculatrice;

public class ThreadClosedCalculette extends Thread{
	
	VueCalculatrice vue = new VueCalculatrice();
	
	public ThreadClosedCalculette(VueCalculatrice view) {
		vue = view;
		this.vue.addWindowListener(new WindowAdapter());
	}
	
	public void run() {
		if()
	}

}
