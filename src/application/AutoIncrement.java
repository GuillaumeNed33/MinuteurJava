package application;

import Modele.Minuteur;

public class AutoIncrement extends Thread {

	Minuteur m;

	AutoIncrement(Minuteur m) {
		this.m = m;
	}

	@SuppressWarnings("static-access")
	public void run() {
		while (this.isAlive()) {
			m.incrementerS();
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Erreur lors du sleep");
			}

		}
	}

}
