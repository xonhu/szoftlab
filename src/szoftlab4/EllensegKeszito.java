package szoftlab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class EllensegKeszito implements Aktiv {
	
		//Tartalmazza azokat az utakat, ahová egy ellenség lerakható
		private ArrayList<Ut> belepoUtak;
		
		//Az EllensegKeszito paraméteres konstruktora. Át kell neki adni a belépõutak listáját.
		public EllensegKeszito(ArrayList<Ut> utak){
			belepoUtak = utak;
		}
		
		
		//Tick hatására választ egy utat, majd bizonyos valószínûséggel lerak oda egy
		//véletlenül kiválasztott ellenséget
		public void tick(){  
	         
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(10);
			
			if(index == 1){
			
			String ellenseg;
			
			Ut valasztott = utatValaszt();
			ellenseg = getEllensegTipus();
			
			if(ellenseg.matches("Hobbit"))
				valasztott.ratesz(new Hobbit(valasztott));
			else if(ellenseg.matches("Tünde"))
				valasztott.ratesz(new Tunde(valasztott));
			else if(ellenseg.matches("Ember"))
				valasztott.ratesz(new Ember(valasztott));
			else
				valasztott.ratesz(new Torpe(valasztott));
			
				}
		}
		
		//Véletlenszerûen kiválaszt egy ellenségtípust, és visszaadja azt String-ként
		public String getEllensegTipus(){
			String mitad = null;			
			
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(3);
	        
			switch(index)
			{
			case 0: mitad = new String("Ember"); break;
			case 1: mitad = new String("Hobbit"); break;
			case 2: mitad = new String("Torp"); break;
			case 3: mitad = new String("Tunde"); break;
			}
			
			return mitad;
		}
		
		
		//Véletlenszerûen kiválaszt egyet a belépõutak listájából, és visszaadja azt
		public Ut utatValaszt(){
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(belepoUtak.size());
	        Ut belepout = belepoUtak.get(index);
	        return belepout;
		}
		
}
