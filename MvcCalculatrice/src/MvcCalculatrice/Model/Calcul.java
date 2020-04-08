package MvcCalculatrice.Model;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Calcul {
	
	//attributs
	private int num1;
	private int num2;
	private int num3;
	
	//methodes
	public int additionRandom() {
		num3 = num1 + num2;
		return num3;
	}

	public int soustractionRandom() {
		num3 = num1 - num2;
		return num3;
	}
	
	public static void fermetureProgramme() {
		
		Timer fermetureApresResultat = new Timer();  
		fermetureApresResultat.schedule(new TimerTask() {
			
			public void run() {
				System.exit(0);
			}
		},1 // les secondes du délais (1000 = 1sec)
		);
	}
	
	public void pauseProgramme() {

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void fin(){
		pauseProgramme();
		fermetureProgramme();
	}

	//getter & setter
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	
}
