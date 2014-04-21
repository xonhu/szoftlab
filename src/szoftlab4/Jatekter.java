package szoftlab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jatekter {

	//A játéktér celláit tartalmazza
	private ArrayList<ArrayList<Cella>> cellak;
	
	//Az aktuális játékost tartalmazza
	public Jatekos felhasznalo;

	//A Jatekter osztály konstruktora. Paraméterként egy játékost vár.
	public Jatekter(Jatekos user) {
		felhasznalo = user;
		cellak = new ArrayList<ArrayList<Cella>>();
	}

	//Egy pálya betöltésére való függvény. Pályaszámot vár.
	public void betolt(int palyaSzam) {

	}

	//Egy pálya betöltésére való függvény. A pályát tartalmazó fájl nevét várja.
	public void betolt(String filename) {

		BufferedReader br = null;
		try {
			System.out.println(System.getProperty("user.dir"));
			br = new BufferedReader(new FileReader(filename));

			String line = br.readLine();

			//Az elsõ sorból beolvassa a pálya méreteit
			//TODO: Akkor is mûködik, hogyha kétszámjegyû a pálya mérete?
			int sizeI = Character.getNumericValue(line.charAt(0));
			int sizeJ = Character.getNumericValue(line.charAt(2));
			line = br.readLine();

			int currentLineNumber = 0;

			//Olvassa a fájlból a pálya sorait
			//TODO: Végzethegye, power, szomszédok beállítása
			while (line != null) {

				cellak.add(new ArrayList<Cella>());

				for (int k = 0; k < line.length(); k++) {
					if (line.charAt(k) == 'M') {
						cellak.get(currentLineNumber).add(new Mezo());
					} else if (line.charAt(k) == 'U') {
						cellak.get(currentLineNumber).add(new Ut());
					} else
						break;
				}
				currentLineNumber++;
				line = br.readLine();
			}

			// ellenõrzés
			/*
			 * for (int i = 0; i < sizeI; i++){ for (int j = 0; j < sizeJ; j++)
			 * if (cellak.get(i).get(j).getClass().equals(Mezo.class))
			 * System.out.print("M"); else System.out.print("U");
			 * System.out.println(); }
			 */

		} catch (IOException e) {
			System.err.println("IO Hiba");
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("IO Hiba");
			}
		}

	}

	public int getAr(String koTipus) {

		int ar = 0;

		return ar;
	}
}
