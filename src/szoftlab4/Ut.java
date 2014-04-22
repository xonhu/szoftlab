package szoftlab4;

import java.util.ArrayList;

public class Ut extends Cella{

	//Tartalmazza azokat az elemeket, amik rajta helyezkednek el
	public ArrayList<Utravalo> rajtamvan;
	
	//Az úton található akadály
	public Akadaly akadaly;
	

	//Ut osztály paraméteres konstruktora
	public Ut(ArrayList<Cella> l){
		super(l);
		rajtamvan = new ArrayList<Utravalo>();
	}
	
	//Ut osztály paraméter nélküli konstruktora
	public Ut(){
		super();
		rajtamvan = new ArrayList<Utravalo>();
	}

	//Az útra teszi a megadott elemet
	public void ratesz(Utravalo elem)				
	{	
		rajtamvan.add(elem);
		elem.init(this);
	}

	//Az útról leveszi a paraméterként átadott elemet
	public void levesz(Utravalo elem)				
	{
		rajtamvan.remove(elem);
	}

	//Igazzal tér vissza, ha mezõ, hamissal ha út
	public boolean mezovagyok()						  	
	{
		return false;								// Mert bizony szegény Cella nem Mezõ, hanem Út :'( 
	}
	
	//Visszaadja azokat az ellenségeket, akik rajta helyezkednek el.
	public ArrayList<Ellenseg> kivanrajtam()
	{
		ArrayList<Ellenseg> temp = new ArrayList<Ellenseg>();
		for(int i = 0;i<rajtamvan.size();i++)
		{	if(rajtamvan.get(i) instanceof Ellenseg)
				temp.add((Ellenseg)rajtamvan.get(i));
		}
		return temp;
	}

	//A közelben lévõ utak listájával tér vissza, ahová az ellenség léphet
	public ArrayList<Ut> lepnek()					
	{
		ArrayList<Ut> temp = new ArrayList<Ut>();
		ArrayList<Cella> cellak = getSzomszedok();
		for(int i = 0; i<cellak.size();i++){
			if(cellak.get(i) instanceof Ut)
				temp.add((Ut)cellak.get(i));
		}
		return temp;
	}

}