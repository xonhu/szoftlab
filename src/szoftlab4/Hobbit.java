package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

public class Hobbit extends Ellenseg {

	public Hobbit(Ut sajat) {
		super(sajat);
		elet = 150;
		ertek = 110;
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
		elet = elet - lovedek.sebzesHobbit;
	}

}
