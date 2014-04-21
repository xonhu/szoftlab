package szoftlab4;

import java.util.ArrayList;

public class Controller {
	
	//Az aktív játékteret tartalmazza
	Jatekter jatekter;
	
	//Az Aktív elemeket tartalmazza, amelyeknek szüksége van tick-re.
	ArrayList<Aktiv> aktiv;

	//A Controller osztály konstruktora
	public Controller(Jatekter ter) { 
		jatekter = ter;
		aktiv = new ArrayList<Aktiv>();
	}

	// Pálya kiválasztása, játékos felruházása varázserõvel
	public void indit() { 
		int palyaSzam = 0;
			jatekter.betolt(palyaSzam);
			jatekter.felhasznalo.varazserotKap(100);
			startTick();

	}

	//TODO: Ez nem egy szálat fog elindítani?
	public void startTick() { // Tick indítása

		for (Aktiv elem : aktiv) {
			elem.tick();
		}

		try {
			wait(500);
		} catch (InterruptedException e) {
			System.err.println("IO Hiba");

			e.printStackTrace();
		}
	}

	//Egy ellenség halála után, a játékos varázserõt kap
	public void meghaltam(int ertek) { 

		jatekter.felhasznalo.varazserotKap(ertek);

	}

	//Egy aktív pályaelemet hozzáad az Aktív listához
	public void addAktiv(Aktiv a) {
		aktiv.add(a);
	}

	// Függvény, aminek meghívásával jelezhetjük a játék végét. True-t kell neki
	// átadni, ha a játékos nyert,
	// false-ot ha a játékos vesztett.
	// TODO: Ez értesíti majd a Game osztályt, ha vége a játéknak?
	public void endgame(boolean nyerte) {

	}

}
