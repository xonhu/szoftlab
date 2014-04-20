package szoftlab4;

import java.util.ArrayList;

public class Cella {
	protected ArrayList<Cella> szomszedok;	// Lista a szomszéd cellákról
	private Boolean boolean1;
	
	public Cella()
	{
		
	}
	
	public Cella(ArrayList<Cella> l){		// A Cella konstruktora
		szomszedok = l;
	}
	
	public void ratesz(Mezorevalo elem) // Cellára tesz mezõrevaló elemet (itt nem használt)
	{
		
	}
	
	public void ratesz(Utravalo elem) // Cellára tesz Útravaló elemet (itt nem használt)
	{
		
	}
	
	public void levesz(Mezorevalo elem) // Cellról levesz mezõrevaló elemet (itt nem használt)
	{
		
	}
	
	public void levesz(Utravalo elem) // Cellról levesz útravaló elemet (itt nem használt)
	{
		
	}
	

	
	public ArrayList<Ellenseg> kivanrajtam() // Visszaad egy Ellenséglistát azokról az ellenségekrõl akik az adott cellán(úton) vannak (itt nem használt)
	{
		return null;
	}
	
	public ArrayList<Cella> getSzomszedok() // Visszaadja a szomszéd cellák listáját
	{
		return szomszedok;
	}
	

	public boolean mezovagyok() // igazzal tér vissza, ha mezõ, hamissal ha út (itt nem használt)
	{
		boolean1 = (Boolean) null;
		return boolean1;		
	}
	


}
