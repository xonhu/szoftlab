package szoftlab4;

import java.util.ArrayList;

public class Mezo extends Cella {
	private ArrayList<Mezorevalo> rajtamvan;	//Az adott mezõn lévõ elemeket tartalmazó lista
	
	public Mezo(){
		rajtamvan = new ArrayList<Mezorevalo>();
	}

	public void ratesz(Mezorevalo elem)			// A Cellára tesz mezõrevaló elemet 
	{
		Log.log(LogType.CALL, this, "ratesz_mezo");
		rajtamvan.add(elem);
		elem.init(this);
		Log.log(LogType.RETURN, null, "void");
	}
	
	public void levesz(Mezorevalo elem)			// Cellról levesz mezõrevaló elemet 
	{
		Log.log(LogType.CALL, this, "levesz_mezo");
		rajtamvan.remove(elem);
		Log.log(LogType.RETURN, null, "void");
	}
	
	public boolean mezovagyok()
	{												// igazzal tér vissza, mert õ egy mezõ
		Log.log(LogType.CALL, this, "mezovagyok");
		Log.log(LogType.RETURN, null, "boolean");
		return true;
	}
	
	public ArrayList<Ut> kozelbenvan(int melyseg)	//visszatér egy minden utat tartalmazó listával
	{
		Log.log(LogType.CALL, this, "kozelbenvan");
		
		ArrayList<Ut> temp_ut = new ArrayList<Ut>();
		
		
		for(int i=0;i<this.getSzomszedok().size();i++)
		{
			if(!this.getSzomszedok().get(i).mezovagyok())
				temp_ut.add((Ut) this.getSzomszedok().get(i));
				
		}
		Log.log(LogType.RETURN, null, "ArrayList<Ut>");
		return temp_ut;
		
	}
}
