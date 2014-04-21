package szoftlab4;

import java.util.ArrayList;

public class Controller {
	Jatekter jatekter;
	ArrayList<Aktiv> aktiv;

	public Controller(Jatekter ter) { // A Controller konstruktora
		jatekter = ter;
		aktiv = new ArrayList<Aktiv>();
	}

	public void indit() { // Pálya kiválasztása, játékos felruházása
							// varázserõvel
		
		int palyaSzam = 0;
		jatekter.betolt(palyaSzam);
		jatekter.felhasznalo.varazserotKap(100);
		startTick();

	}

	public void startTick() { // Tick indítása

		for (Aktiv elem : aktiv) {
			elem.tick();
		}

		try {
			wait(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void meghaltam(int ertek) { // A játékos varázserõt kap

		jatekter.felhasznalo.varazserotKap(ertek);

	}

	public void addAktiv(Aktiv a) {
		aktiv.add(a);
	}

	// Függvény, aminek meghívásával jelezhetjük a játék végét. True-t kell neki
	// átadni, ha a játékos nyert,
	// false-ot ha a játékos vesztett.
	public void endgame(boolean nyerte) {

	}

}
