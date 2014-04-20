package szoftlab4;

import java.util.ArrayList;

public class Mezo extends Cella {
	private ArrayList<Mezorevalo> rajtamvan;	//Az adott mezõn lévõ elemeket tartalmazó lista

	public Mezo(ArrayList<Cella> l){
		szomszedok = l;
		rajtamvan = new ArrayList<Mezorevalo>();
	}

	public void ratesz(Mezorevalo elem)			// A Cellára tesz mezõrevaló elemet 
	{
		rajtamvan.add(elem);
		elem.init(this);
	}

	public void levesz(Mezorevalo elem)			// Cellról levesz mezõrevaló elemet 
	{
		rajtamvan.remove(elem);
	}

	public boolean mezovagyok()
	{												// igazzal tér vissza, mert õ egy mezõ
		return true;
	}

	public ArrayList<Ut> kozelbenvan(int melyseg)	//visszatér egy minden utat tartalmazó listával
	{
		ArrayList<Ut> temp_ut = new ArrayList<Ut>();

		if(melyseg!=0)
		{
			//TODO: rekurzívan vissza kell adni a közelben lévõ utakat... a baj az, hogy listánk csak a cellákról van, nem az utakról..			
		}

		return temp_ut;

	}
}