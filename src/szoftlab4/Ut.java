package szoftlab4;

import java.util.ArrayList;

public class Ut extends Cella{

	public ArrayList<Utravalo> rajtamvan;
	public Akadaly akadaly;
	ArrayList<Cella> szomszedok;

	public Ut(ArrayList<Cella> l){
		rajtamvan = new ArrayList<Utravalo>();
		szomszedok = l;
	}
	public Ut(){
		rajtamvan = new ArrayList<Utravalo>();
	}

	public void ratesz(Utravalo elem)				//Cellára tesz Útravaló elemet 
	{	
		rajtamvan.add(elem);
		elem.init(this);
	}

	public void levesz(Utravalo elem)				// Cellról levesz mezõrevaló elemet 
	{
		rajtamvan.remove(elem);
	}

	public boolean mezovagyok()						// Igazzal tér vissza, ha mezõ, hamissal ha út 	
	{
		return false;								// Mert bizony szegény Cella nem Mezõ, hanem Út :'( 
	}

	public ArrayList<Ut> lepnek()					// A közelben lévõ utak listájával tér vissza
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