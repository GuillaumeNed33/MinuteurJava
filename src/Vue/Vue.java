package Vue;

import application.Controller;

public class Vue {
	private Controller control;
	private FenetreModifiable seconde;
	private FenetreModifiable minutes;
	private FenetreModifiable heures;
	private FenetreAffichage minSec;
	private FenetreAffichage heurMinSec;

	public FenetreModifiable getSeconde() {
		return seconde;
	}

	public FenetreModifiable getMinutes() {
		return minutes;
	}

	public FenetreModifiable getHeures() {
		return heures;
	}

	public FenetreAffichage getMinSec() {
		return minSec;
	}

	public FenetreAffichage getHeurMinSec() {
		return heurMinSec;
	}

	public Vue() {
		seconde = new FenetreModifiable("Secondes");
		minutes = new FenetreModifiable("Minutes");
		heures = new FenetreModifiable("Heures");
		minSec = new FenetreAffichage("Minutes - Secondes",TypeAffichage.MIN_SEC);
		heurMinSec = new FenetreAffichage("Heure:Minutes - Secondes",TypeAffichage.H_MIN_SEC);
		seconde.setVisible(true);
		minutes.setVisible(true);
		heures.setVisible(true);
		minSec.setVisible(true);
		heurMinSec.setVisible(true);
	}

	public void setControl(Controller c) {
		control = c;
		seconde.addListener(this.control);
		minutes.addListener(this.control);
		heures.addListener(this.control);
	}
}
