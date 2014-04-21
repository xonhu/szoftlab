package szoftlab4;

import java.util.ArrayList;

public class Cella {
	
	// Lista amely tartalmazza a szomszéd cellákat
	public ArrayList<Cella> szomszedok;	

	//A Cella osztály konstruktora
	public Cella()
	{
		szomszedok = new ArrayList<Cella>();
	}

	//A Cella paraméteres konstruktora, amelynek a szomszédait kell átadni
	public Cella(ArrayList<Cella> l){		
		szomszedok = l;
	}

	// Cellára tesz mezõrevaló elemet. Mezo osztályban felülírva!
	public void ratesz(Mezorevalo elem) 
	{

	}

	//Cellára rátesz egy Útravaló elemet. Ut osztályban felülírva!
	public void ratesz(Utravalo elem) 
	{

	}

	// Cellról levesz egy mezõrevaló elemet. Mezo osztályban felülírva!
	public void levesz(Mezorevalo elem) 
	{

	}

	// Cellról levesz egy útravaló elemet. Ut osztályban felülírva!
	public void levesz(Utravalo elem) 
	{

	}

	//Visszaad egy Ellenséglistát azokról az ellenségekrõl akik az adott cellán(úton) vannak. Ut osztályban felülírva!
	public ArrayList<Ellenseg> kivanrajtam() 
	{
		return null;
	}

	//Visszaadja a szomszéd cellák listáját
	public ArrayList<Cella> getSzomszedok() 
	{
		return szomszedok;
	}

	//Igazzal tér vissza, ha mezõ, hamissal ha út. Leszármazott osztályokban felülírva.
	public boolean mezovagyok() 
	{
		return false;		
	}



}