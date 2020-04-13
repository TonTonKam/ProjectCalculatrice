package MvcCalculatrice.Model;

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
