package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

public class Hobbit extends Ellenseg {

	public Hobbit(Ut sajat) {
		super(sajat);
		elet = 150;
		ertek = 110;
		count = 0;
	}
	
	//Tick hat�s�ra a Hobbit bizonyos val�sz�n�s�ggel l�pni fog (1/3)
	public void tick(){
		
		//	 Random randomGenerator = new Random();
		//	 int index = randomGenerator.nextInt(2);
			 
			if(count == 3){
				ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
				lepek(lehetsegesutak);
				count = 0;
			} else count++;
	}
	
	//Param�terk�nt kap egy l�ved�ket, �s a r� vonatkoz� �rt�kkel sebzi mag�t
	public void sebez(Lovedek lovedek){
		elet = elet - lovedek.sebzesHobbit;
	}

}
