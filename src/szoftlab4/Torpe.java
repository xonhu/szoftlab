package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

//Egy speciális ellenségtípus
public class Torpe extends Ellenseg {

//Törpe publikus konstruktora
	public Torpe(Ut sajat) {
		super(sajat);
		elet = 200;
		ertek = 140;
	}
	
	//Tick hatására, a Törpe bizonyos valószínûséggel lépni fog. (1/5)
	public void tick(){
		
		 Random randomGenerator = new Random();
		 int index = randomGenerator.nextInt(4);
		 
		 
		if(index == 1){
			ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
			lepek(lehetsegesutak);
		}
		
	}
	
	//Ha lövés éri az ellenséget, akkor a rá vonatkozó értékkel csökken az élete
	public void sebez(Lovedek lovedek){
		elet = elet - lovedek.sebzesTorpe;
	}

}
