package szoftlab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//Torony osztály
public class Torony implements Aktiv, Mezorevalo {
	
		public String id;
		private Mezo sajatMezo;
		private int hatotav;
		private int tuzgyak;
		private int sebzes;
		private int counter;
		private boolean kodos;
		ArrayList<Toronykovek> kovek;
		public Kod kod;
	
//Torony publikus konstruktora
		Torony(){
			hatotav=1;
			tuzgyak=10;
			sebzes=1;
			counter = 0;
			kovek = new ArrayList<Toronykovek>();
			sajatMezo = new Mezo();
			kodos = false;
		}
		
//Torony publikus konstruktora teszteléshez
				Torony(String iduj){
					hatotav=1;
					id = iduj;
					tuzgyak=10;
					sebzes=1;
					counter = 0;
					kovek = new ArrayList<Toronykovek>();
					sajatMezo = new Mezo();
					kodos = false;
				}
//Ha történik a rendszerben egy tick(), ez a metódus hívódik meg
//Bizonyos idõközönként lõni fog a közelben található ellenségekre
//A tüzelési gyakoriságra hatással van a Sárga varázskõ megléte
		public void tick(){
		
		if(kod != null)
			kod.tick();
		if(kod == null){
			 Random randomGenerator = new Random();
			 int index = randomGenerator.nextInt(49);
			 
			 if(index == 1){
				 kod = new Kod(this);
			 }
		}
			
			
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
		//A lövedék tulajdonságai függnek attól, hogy milyen kövekkel van felszerelve a torony, és azok számától
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
			
			//Új lövedék készítése, értékeinek beállítása.
			//A lövedék 1/20-ad valószínûséggel hasító lövedék lesz
			Lovedek lov = new Lovedek();
			
			 Random randomGenerator = new Random();
			 int index = randomGenerator.nextInt(19);

			lov.sebzesEmber += (kek*10);
			lov.sebzesHobbit += (barna*10);
			lov.sebzesTunde += (narancs*10);
			lov.sebzesTorpe += (piros*10);
			if(index == 1)
				lov.hasit = true;
			else 
				lov.hasit = false;
			
			return lov;
		}
		
//Amennyiben a tick() meghívja, a torony tüzelni fog. Elõször létrehoz egy lövedéket, majd
//átadja azt a sebezni kívánt ellenségeknek. (Akik hatótávolságon belül találhatók)
		public void tuzel() {
			ArrayList<Ellenseg> ellen;
			int actualhatotav = hatotav;
			
			if(kodos = true){
			ellen = lekerdez(1);
			}
			
			else {
			for(int i = 0;i<kovek.size();i++){
				if(kovek.get(i) instanceof Zoldvarazsko)
					actualhatotav++;
			}
			ellen = lekerdez(actualhatotav);
			}
			
			Lovedek lov = createLovedek();
			
			for(int i = 0;i<ellen.size();i++){
				ellen.get(i).sebez(lov);
			}
			
		}
		
//Lekérdezi a közelben(hatótávon belül) található ellenségeket. Ezek után visszadja azt.
//Hogy meddig lát el, az függ attól, hogy milyen kövekkel van felszerelve, és van-e köd a tornyon
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
		
//Felszereli a tornyot a paraméterként kapott kõvel
		public void addKo(Toronykovek ko){
			kovek.add(ko);
		}
		
//Inicializálja a mezõt, amint a torony áll
		public void init(Mezo testMezo) {
			sajatMezo = testMezo;
		}
//Beködösíti a tornyot ha leszáll a köd.
		public void kodosit(){
			kodos = true;
		}

//Leveszi a ködöt, ha letelt az adott idõtartam;
		public void kitisztul(){
			kodos = false;
			kod = null;
		}
}