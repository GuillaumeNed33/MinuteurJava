 package Modele;
 
import java.util.Observable;

public class Minute extends Observable {
	
	private int value;
	
	public Minute()
	{
		value = 0;
	}
	
	public boolean incrementer() {
		setChanged();
		this.value++;
		if(value > 59) {
			value = 0;
			notifyObservers(value);
			return true;
		}
		notifyObservers(value);
		return false;
	}
	public boolean decrementer() {
		setChanged();
		this.value--;
		if(this.value <0) {
			this.value = 59;
			notifyObservers(value);
			return true;
		}
		notifyObservers(value);
		return false;
	}
	
}
