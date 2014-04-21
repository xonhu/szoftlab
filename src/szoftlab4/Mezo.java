package szoftlab4;

import java.util.ArrayList;

public class Mezo extends Cella {
	private ArrayList<Mezorevalo> rajtamvan;	//Az adott mezõn lévõ elemeket tartalmazó lista

	public Mezo(){
		super();								//Meghívjuk a Cella konstruktorát is
	}
	public Mezo(ArrayList<Cella> l){
		super();
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

	//Ez a metódus lehet hogy nagyon lassan fog lefutni. Ha lesz idõ újra kell írni.
	public ArrayList<Ut> kozelbenvan(int melyseg)	//visszatér egy minden utat tartalmazó listával
	{	
		//Erre a változóra azért van szükség, hogy ne kelljen minden alkalammola végigmenni
		//az ArrayList-en. A ciklus csak olyan elemeket fog megnézni, amiket még nem nézzett meg
		int itttart = 0;
		
		//Ebben tároljuk az utakat
		ArrayList<Ut> temp_ut = new ArrayList<Ut>();
		
		//A mezõ mellett található utakat hozzáadjuk az utakat tartalmazó listához
		ArrayList<Cella> cellak = getSzomszedok();
		for(int i = 0;i<cellak.size();i++){
			if(cellak.get(i) instanceof Ut){
				temp_ut.add((Ut)cellak.get(i));
			}
		}
		//Ha a mélység csak egy volt, végeztünk.
		melyseg -=1 ;

		
		cellak.clear();
		ArrayList<Cella> cellatemp = new ArrayList<Cella>();
		//Egyébként pedig végigmegyünk az utakon, és azok szomszédain
		//Ha azok utak, és még nincsenek benne a listában, belerakjuk õket is a listába.
		while(melyseg!=0)
		{
			//A legrégebbi nem meg nézett elemtõl kezdve, megnézzük az elemek szomszédait, 
			//Ezekbõl listát csinálunk
			for(int i = itttart; i<temp_ut.size();i++){
				cellak = temp_ut.get(i).getSzomszedok();
					for(int j = 0;j<cellak.size();j++){
						cellatemp.add(cellak.get(j));
					}
			}
			
			//Végigmegyünk az így felépített listánkon, és ha olyan elemet találunk ami Út, és
			//még nincs benne az utakat tartalmazó listánkban, hozzáadjuk.
			
			for(int i = 0; i<cellatemp.size();i++){
				if(cellatemp.get(i) instanceof Ut || !temp_ut.contains(cellatemp.get(i)))
				{
					temp_ut.add((Ut)cellak.get(i));
					itttart +=1;
				}
			}
			
			
			cellak.clear();
			cellatemp.clear();
			
			melyseg -= 1;			
		}

		return temp_ut;

	}
}