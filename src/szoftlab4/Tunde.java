package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

//Egy speciális ellenségtípus
public class Tunde extends Ellenseg{

	//Tunde osztály publikus konstruktora
	public Tunde(Ut sajat) {
		super(sajat);
		elet = 170;
		ertek = 150;
	count = 0;	
	}
	
	//Tick hatására a Tünde bizonyos valószínûséggel lépni fog (1/2)
	public void tick(){
		
		//	 Random randomGenerator = new Random();
		//	 int index = randomGenerator.nextInt(2);
			 
			if(count == 3){
				ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
				lepek(lehetsegesutak);
				count = 0;
			} else count++;
		
	}
	
	//Ha lövés éri az ellenséget, akkor a rá vonatkozó értékkel csökken az élete
	public void sebez(Lovedek lovedek){
		elet = elet - lovedek.sebzesTunde;
	}

}
