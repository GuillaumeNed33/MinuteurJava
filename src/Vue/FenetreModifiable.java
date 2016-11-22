package Vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;

import javax.swing.*;

import application.Controller;

public class FenetreModifiable extends Fenetre {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int valeur;
	JLabel texte;
	JButton plus;
	JButton moins;

	public FenetreModifiable(String titre) {

		super(titre);
		JPanel boutonPane = new JPanel();
		Font f = new Font("Arial", Font.PLAIN, 48);
		valeur = 0;
		texte = new JLabel();
		texte.setFont(f);
		texte.setText(Integer.toString(valeur));
		texte.setVisible(true);
		plus = new JButton("+");
		plus.setVerticalTextPosition(AbstractButton.CENTER);
		plus.setHorizontalTextPosition(AbstractButton.CENTER);
		plus.setSize(100, 100);
		plus.setFont(f);
		moins = new JButton("-");
		moins.setVerticalTextPosition(AbstractButton.CENTER);
		moins.setHorizontalTextPosition(AbstractButton.CENTER);
		moins.setSize(100, 100);
		moins.setFont(f);
		boutonPane.add(plus);
		boutonPane.add(moins);
		boutonPane.add(texte);
		this.getContentPane().add(boutonPane, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.valeur = (int) arg;
		texte.setText(Integer.toString(valeur));
	}

	public void addListener(Controller control) {
		plus.addActionListener(control);
		moins.addActionListener(control);
	}

	public JButton getButtonPlus() {
		return this.plus;
	}
	public JButton getButtonMoins() {
		return this.moins;
	}
}
