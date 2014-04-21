package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

public class Ember extends Ellenseg {

	public Ember(Ut sajat) {
		super(sajat);
		elet = 100;
		ertek = 100;
	}

	//Tick hatására az Ember bizonyos valószínûséggel lépni fog (1/3)
	public void tick(){
		
		 Random randomGenerator = new Random();
		 int index = randomGenerator.nextInt(2);
		 
		 
		if(index == 1){
			ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
			lepek(lehetsegesutak);
		}
		
	}
	
	//Paraméterként kap egy lövedéket, és a rá vonatkozó értékkel sebzi magát
	public void sebez(Lovedek lovedek){
		 elet = elet - lovedek.sebzesEmber;
	}
	
	
}
