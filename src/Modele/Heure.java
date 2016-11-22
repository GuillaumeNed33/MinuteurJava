package Modele;

import java.util.Observable;

public class Heure extends Observable{
	private int value;

	public Heure()
	{
		value = 0;
	}

	public void incrementer() {
		setChanged();
		this.value = (this.value+1)%24;
		notifyObservers(value);
	}
	public void decrementer() {
		setChanged();
		this.value--;
		if(this.value <0) {
			this.value = 0;
		}
		notifyObservers(value);
	}
	
}
