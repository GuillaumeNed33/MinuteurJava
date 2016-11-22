package application;

import Vue.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Modele.Minuteur;

public class Controller implements ActionListener{
	Minuteur horloge;
	Vue vue;

	public void setVue(Vue v) {
		vue = v;
	}

	public void setModel(Minuteur m) {
		horloge = m;
	}

	public void createLiaison() {
		ArrayList<Fenetre> secObs = new ArrayList<Fenetre>();
		secObs.add(vue.getMinSec());
		secObs.add(vue.getHeurMinSec());
		secObs.add(vue.getSeconde());
		ArrayList<Fenetre> minObs = new ArrayList<Fenetre>();
		minObs.add(vue.getHeurMinSec());
		minObs.add(vue.getMinSec());
		minObs.add(vue.getMinutes());
		ArrayList<Fenetre> heuObs = new ArrayList<Fenetre>();
		heuObs.add(vue.getHeurMinSec());
		heuObs.add(vue.getHeures());
		horloge.addSecObserver(secObs);
		horloge.addMinObserver(minObs);
		horloge.addHeuObserver(heuObs);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vue.getSeconde().getButtonPlus()){
			horloge.incrementerS();
		}
		if(e.getSource() == vue.getMinutes().getButtonPlus()){
			horloge.incrementerM();
		}
		if(e.getSource() == vue.getHeures().getButtonPlus()){
			horloge.incrementerH();
		}
		if(e.getSource() == vue.getSeconde().getButtonMoins()){
			horloge.decrementerS();
		}
		if(e.getSource() == vue.getMinutes().getButtonMoins()){
			horloge.decrementerM();
		}
		if(e.getSource() == vue.getHeures().getButtonMoins()){
			horloge.decrementerH();
		}
	}
}