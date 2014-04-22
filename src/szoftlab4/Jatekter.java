package szoftlab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jatekter {

	//A játéktér celláit tartalmazza
	public ArrayList<ArrayList<Cella>> cellak;
	
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
			br = new BufferedReader(new FileReader(filename));

			//Az elsõ sorból beolvassa a pálya méreteit
			String line = br.readLine();
			String[] splitLine = line.split("\\s+");
			int sizeI = Integer.parseInt(splitLine[0]);
			int sizeJ = Integer.parseInt(splitLine[1]);

			//Olvassa a fájlból a pálya sorait
			for(int i=0;i<sizeI;i++){
				line = br.readLine();
				cellak.add(new ArrayList<Cella>());
				for(int j=0;j<sizeJ;j++){
					if (line.charAt(j) == 'M')		cellak.get(i).add(new Mezo());
					else if (line.charAt(j) == 'U') cellak.get(i).add(new Ut());
					else 							break;
				}
			}
			
			//VégzetHegye pozícióját beolvassuk a fájlból
			line = br.readLine();
			splitLine = line.split("\\s+");
			if(splitLine[0].equals("VH")){
				if(splitLine.length == 3){ 
					VegzetHegye uj = new VegzetHegye(cellak.get(Integer.parseInt(splitLine[1])).get(Integer.parseInt(splitLine[2])));
					cellak.get(Integer.parseInt(splitLine[1])).get(Integer.parseInt(splitLine[2])).ratesz(
							uj
							);
					Application.game.hegy = uj;
			}
			}
			
			
			//Felhasználó varázserejét beolvassuk a fájlból
			line = br.readLine();
			splitLine = line.split("\\s+");
			if(splitLine[0].equals("POWER")){
				if(splitLine.length == 2) 
					felhasznalo.varazserotKap(Integer.parseInt(splitLine[1]));
			}

			//Cella szomszédainak beállítása
			for(int i=0; i< cellak.size();i++){
				for(int j=0; j< cellak.get(i).size();j++){
					if(i>0)							cellak.get(i).get(j).szomszedok.add(cellak.get(i-1).get(j));
					if(i< (cellak.size()-1) )		cellak.get(i).get(j).szomszedok.add(cellak.get(i+1).get(j));
					if(j>0)							cellak.get(i).get(j).szomszedok.add(cellak.get(i).get(j-1));
					if(j< (cellak.get(i).size()-1))	cellak.get(i).get(j).szomszedok.add(cellak.get(i).get(j+1));
				}
			}

		} catch (IOException e) {
			System.err.println("IO Hiba");
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
