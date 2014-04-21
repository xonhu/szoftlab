package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

public class Hobbit extends Ellenseg {

	public Hobbit(Ut sajat) {
		super(sajat);
		elet = 150;
		ertek = 110;
	}
	
	//Tick hatására a Hobbit bizonyos valószínûséggel lépni fog (1/3)
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
		elet = elet - lovedek.sebzesHobbit;
	}

}
