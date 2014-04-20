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
		ArrayList<Ut> temp = null;
		// TODO: Ugyan az a helyzet mint a Mezo osztály közelbenvan fv-ével... a  szomszédok listája Cellákat tárol, így nem lehet Ut-ra szûrni.. :(
		return temp;
	}

}