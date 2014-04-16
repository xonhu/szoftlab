package szoftlab4;

import java.util.ArrayList;

public class Cella {
	private ArrayList<Cella> szomszedok;	// Lista a szomszéd cellákról
	
	
	public Cella(){		// A Cella konstruktora
		szomszedok = new ArrayList<Cella>();
		szomszedok.add(Tesztesetek.testUt);
	}
	
	public void ratesz(Mezorevalo elem) // Cellára tesz mezõrevaló elemet (itt nem használt)
	{
		Log.log(LogType.CALL, this, "ratesz_mezore");
		
		Log.log(LogType.RETURN, null, "void");
	}
	
	public void ratesz(Utravalo elem) // Cellára tesz Útravaló elemet (itt nem használt)
	{
		Log.log(LogType.CALL, this, "ratesz_utra");
		
		Log.log(LogType.RETURN, null, "void");
	}
	
	public void levesz(Mezorevalo elem) // Cellról levesz mezõrevaló elemet (itt nem használt)
	{
		Log.log(LogType.CALL, this, "levesz");
		
		Log.log(LogType.RETURN, null, "levesz");
	}
	
	public void levesz(Utravalo elem) // Cellról levesz útravaló elemet (itt nem használt)
	{
		Log.log(LogType.CALL, this, "levesz");
		
		Log.log(LogType.RETURN, null, "levesz");
	}
	

	
	public ArrayList<Ellenseg> kivanrajtam() // Visszaad egy Ellenséglistát azokról az ellenségekrõl akik az adott cellán(úton) vannak (itt nem használt)
	{
		Log.log(LogType.CALL, this, "kivanrajtam");
		
		Log.log(LogType.RETURN, null, "ArrayList<Ellenseg>");
		return null;
	}
	
	public ArrayList<Cella> getSzomszedok() // Visszaadja a szomszéd cellák listáját
	{
		Log.log(LogType.CALL, this, "getSzomszedok");
		
		Log.log(LogType.RETURN, null, "ArrayList<Cella>");
		return szomszedok;
	}
	

	public boolean mezovagyok() // igazzal tér vissza, ha mezõ, hamissal ha út (itt nem használt)
	{
		Log.log(LogType.CALL, this, "mezovagyok");
		Log.log(LogType.RETURN, null, "boolean");
		return (Boolean) null;
		
	}
	


}
