package szoftlab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jatekter {

	private ArrayList<ArrayList<Cella>> cellak;
	public Jatekos felhasznalo;

	public Jatekter(Jatekos user) {
		felhasznalo = user;
		cellak = new ArrayList<ArrayList<Cella>>();
	}

	public void betolt(int palyaSzam) {

	}

	public void betolt(String filename) {

		BufferedReader br = null;
		try {
			System.out.println(System.getProperty("user.dir"));
			br = new BufferedReader(new FileReader(filename));

			String line = br.readLine();

			// az elsõ sorból beolvasom a pálya méreteit
			int sizeI = Character.getNumericValue(line.charAt(0));
			int sizeJ = Character.getNumericValue(line.charAt(2));
			line = br.readLine();

			int currentLineNumber = 0;

			// olvasom a fájlból a pálya sorait
			// TODO: Végzethegye, power, szomszédok beállítása
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int getAr(String koTipus) {

		int ar = 0;

		return ar;
	}
}
