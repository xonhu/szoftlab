package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

//Egy speci�lis ellens�gt�pus
public class Tunde extends Ellenseg{

	//Tunde oszt�ly publikus konstruktora
	public Tunde(Ut sajat) {
		super(sajat);
		elet = 170;
		ertek = 150;
	count = 0;	
	}
	
	//Tick hat�s�ra a T�nde bizonyos val�sz�n�s�ggel l�pni fog (1/2)
	public void tick(){
		
		//	 Random randomGenerator = new Random();
		//	 int index = randomGenerator.nextInt(2);
			 
			if(count == 3){
				ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
				lepek(lehetsegesutak);
				count = 0;
			} else count++;
		
	}
	
	//Ha l�v�s �ri az ellens�get, akkor a r� vonatkoz� �rt�kkel cs�kken az �lete
	public void sebez(Lovedek lovedek){
		elet = elet - lovedek.sebzesTunde;
	}

}
