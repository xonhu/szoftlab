package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

public class Ember extends Ellenseg {

	public Ember(Ut sajat) {
		super(sajat);
		elet = 100;
		ertek = 100;
	}

	public void tick(){
		
		 Random randomGenerator = new Random();
		 int index = randomGenerator.nextInt(2);
		 
		 
		if(index == 1){
			ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
			lepek(lehetsegesutak);
		}
		
	}
	
	public void sebez(Lovedek lovedek){
		elet = elet - lovedek.sebzesEmber;
	}
	
	
}
