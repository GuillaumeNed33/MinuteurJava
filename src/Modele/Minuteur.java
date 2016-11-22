package Modele;

import java.util.ArrayList;

import Vue.Fenetre;
import application.Controller;

public class Minuteur {

	// Architecture MVC :
	@SuppressWarnings("unused")
	private Controller control;

	private Heure h;
	private Minute m;
	private Seconde s;

	public Minuteur() {
		h = new Heure();
		m = new Minute();
		s = new Seconde();
	}

	public void setController(Controller c) {
		control = c;
	}

	public void incrementerH() {
		h.incrementer();
	}

	public void incrementerM() {
		if(m.incrementer()) {
			incrementerH();
		}
	}

	public void incrementerS() {
		if(s.incrementer()) {
			incrementerM();
		}
	}

	public void decrementerH() {
		h.decrementer();
	}

	public void decrementerM() {
		if(m.decrementer()) {
			decrementerH();
		}
	}

	public void decrementerS() {
		if(s.decrementer()) {
			decrementerM();
		}
	}

	public void addSecObserver(ArrayList<Fenetre> secObs) {
		for(Fenetre f : secObs) {
			s.addObserver(f);
		}
	}

	public void addMinObserver(ArrayList<Fenetre> minObs) {
		for(Fenetre f : minObs) {
			m.addObserver(f);
		}
	}

	public void addHeuObserver(ArrayList<Fenetre> heuObs) {
		for(Fenetre f : heuObs) {
			h.addObserver(f);
		}
	}
}
