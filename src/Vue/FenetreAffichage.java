package Vue;

import java.awt.Font;
import java.util.Observable;
import java.util.Vector;

import javax.swing.JLabel;

import Modele.Heure;
import Modele.Minute;
import Modele.Seconde;

public class FenetreAffichage extends Fenetre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel texte;
	private TypeAffichage type;
	Vector<Integer> heures;

	public FenetreAffichage(String titre, TypeAffichage ta) {
		super(titre);
		type = ta;
		heures = new Vector<Integer>();
		switch (ta) {
		case H_MIN_SEC:
			build_h_min_sec();
			break;
		case MIN_SEC:
			build_min_sec();
			break;
		default:
			break;
		}
		Font f = new Font("Arial", Font.PLAIN, 48);
		texte = new JLabel();
		texte.setFont(f);
		updateText();
		texte.setVisible(true);
		this.add(texte);
	}

	private void build_min_sec() {
		heures.add(0);
		heures.add(0);

	}

	private void build_h_min_sec() {
		heures.add(0);
		heures.add(0);
		heures.add(0);
	}

	@Override
	public void update(Observable obs, Object obj) {
		if (obs instanceof Seconde) {
			changeSeconde((int) obj);
		} else if (obs instanceof Minute) {
			changeMinute((int) obj);
		} else if (obs instanceof Heure) {
			changeHeure((int) obj);
		}
		updateText();
	}

	private void updateText() {
		String tmp = "";
		for (int i = 0; i < heures.size(); i++) {
			tmp += heures.get(i);
			if (i < heures.size() - 1) {
				tmp += ":";
			}
		}
		texte.setText(tmp);
	}

	private void changeHeure(int obj) {
		if (type == TypeAffichage.H_MIN_SEC) {
			heures.set(0, obj);
		}
	}

	private void changeMinute(int obj) {
		if (type == TypeAffichage.H_MIN_SEC) {
			heures.set(1, obj);
		} else if (type == TypeAffichage.MIN_SEC) {
			heures.set(0, obj);
		}
	}

	private void changeSeconde(int obj) {
		if (type == TypeAffichage.H_MIN_SEC) {
			heures.set(2, obj);
		} else if (type == TypeAffichage.MIN_SEC) {
			heures.set(1, obj);
		}
	}
}
