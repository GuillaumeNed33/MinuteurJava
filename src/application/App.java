package application;

import Modele.Minuteur;
import Vue.Vue;

public class App {

	public static void main(String[] args) {
		Controller control = new Controller();
		Vue vue = new Vue();
		Minuteur minuteur = new Minuteur();
		AutoIncrement auto = new AutoIncrement(minuteur);
		auto.start();
		minuteur.setController(control);
		vue.setControl(control);
		control.setModel(minuteur);
		control.setVue(vue);
		control.createLiaison();
	}
}
