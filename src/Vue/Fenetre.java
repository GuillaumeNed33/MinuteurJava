package Vue;

import java.util.Observer;

import javax.swing.*;

public abstract class Fenetre extends JFrame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fenetre(String titre){
		super(titre);
		setBounds(0,0,500,250);
		setVisible(true);
	}
}
