package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

//Egy speciális ellenségtípus
public class Tunde extends Ellenseg{

	//Tunde osztály publikus konstruktora
	public Tunde(Ut sajat) {
		super(sajat);
		elet = 170;
		ertek = 150;	}
	
	public void tick(){
		
		 Random randomGenerator = new Random();
		 int index = randomGenerator.nextInt(1);
		 
		 
		if(index == 1){
			ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
			lepek(lehetsegesutak);
		}
		
	}
	
	public void sebez(Lovedek lovedek){
		elet = elet - lovedek.sebzesTunde;
	}

}
