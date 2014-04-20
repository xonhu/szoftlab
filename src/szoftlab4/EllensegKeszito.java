package szoftlab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class EllensegKeszito implements Aktiv {
		private ArrayList<Ut> belepoUtak;
		
		public EllensegKeszito(ArrayList<Ut> utak){
			belepoUtak = utak;
		}
		
		public void tick(){  
	         
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
		
		public Ut utatValaszt(){
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(belepoUtak.size());
	        Ut belepout = belepoUtak.get(index);
	        return belepout;
		}
		
}
