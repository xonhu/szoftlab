package szoftlab4;

import java.io.IOException;
import java.util.ArrayList;

//Torony osztály
public class Torony implements Aktiv, Mezorevalo {
		private Mezo sajatMezo;
		private int hatotav;
		private int tuzgyak;
		private int sebzes;
		private int counter;
		ArrayList<Toronykovek> kovek;
	
//Torony publikus konstruktora
		Torony(){
			hatotav=1;
			tuzgyak=10;
			sebzes=1;
			counter = 0;
			kovek = new ArrayList<Toronykovek>();
			sajatMezo = new Mezo();
		}
//Ha történik a rendszerben egy tick(), ez a metódus hívódik meg	
		public void tick(){
		int varazs = 0;
		for(int i = 0;i<kovek.size();i++){
			if(kovek.get(i) instanceof Sargavarazsko)
				varazs++;
		}
			if(counter >= (tuzgyak-varazs)){
				tuzel();
				counter = 0;
			}
				counter++;
			
		}
//Létrehoz egy lövedéket, amit egy ellenségnek átadva, sebezzük azt	
		private Lovedek createLovedek(){
			int barna = 0;
			int kek = 0;
			int narancs = 0;
			int piros = 0;
			
			for(int i = 0; i< kovek.size();i++){
				if(kovek.get(i) instanceof Barnavarazsko) barna++;
				if(kovek.get(i) instanceof Kekvarazsko) kek++;
				if(kovek.get(i) instanceof Narancsvarazsko) narancs++;
				if(kovek.get(i) instanceof Pirosvarazsko) piros++;
			}
			
			Lovedek lov = new Lovedek();

			lov.sebzesEmber += (kek*10);
			lov.sebzesHobbit += (barna*10);
			lov.sebzesTunde += (narancs*10);
			lov.sebzesTorpe += (piros*10);
			
			return lov;
		}
		
//Amennyiben a tick() meghívja, a torony tüzelni fog. Elõször létrehoz egy lövedéket, majd
//átadja azt a sebezni kívánt ellenségnek.
		public void tuzel() {
			
			ArrayList<Ellenseg> ellen = lekerdez(hatotav);
			Lovedek lov = createLovedek();
			
			for(int i = 0;i<ellen.size();i++){
				ellen.get(i).sebez(lov);
			}
			
		}
		
//Lekérdezi a közelben(hatótávon belül) található ellenségeket. Ezek után visszadja azt.
		public ArrayList<Ellenseg> lekerdez(int melyseg){
			
			ArrayList<Ut> utak = sajatMezo.kozelbenvan(melyseg);
			ArrayList<Ellenseg> ellen = new ArrayList<Ellenseg>();
			
			for(int i = 0;i<utak.size();i++){
				ArrayList<Ellenseg> rajta = utak.get(i).kivanrajtam();
				if(rajta != null){
					for(int j = 0; j<rajta.size();j++){
						ellen.add(rajta.get(j));
					}
				}
			}
			
			return ellen;
		}
		
//Felszereli a tornyot a paraméterkét kapott kõvel
		public void addKo(Toronykovek ko){
			kovek.add(ko);
		}
		
//Inicializálja a mezõt, amint a torony áll
		public void init(Mezo testMezo) {
			sajatMezo = testMezo;
		}
}