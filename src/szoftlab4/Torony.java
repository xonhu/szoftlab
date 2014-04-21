package szoftlab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//Torony oszt�ly
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
		
//Torony publikus konstruktora tesztel�shez
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
//Ha t�rt�nik a rendszerben egy tick(), ez a met�dus h�v�dik meg
//Bizonyos id�k�z�nk�nt l�ni fog a k�zelben tal�lhat� ellens�gekre
//A t�zel�si gyakoris�gra hat�ssal van a S�rga var�zsk� megl�te
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
		//L�trehoz egy l�ved�ket, amit egy ellens�gnek �tadva, sebezz�k azt	
		//A l�ved�k tulajdons�gai f�ggnek att�l, hogy milyen k�vekkel van felszerelve a torony, �s azok sz�m�t�l
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
			
			//�j l�ved�k k�sz�t�se, �rt�keinek be�ll�t�sa.
			//A l�ved�k 1/20-ad val�sz�n�s�ggel has�t� l�ved�k lesz
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
		
//Amennyiben a tick() megh�vja, a torony t�zelni fog. El�sz�r l�trehoz egy l�ved�ket, majd
//�tadja azt a sebezni k�v�nt ellens�geknek. (Akik hat�t�vols�gon bel�l tal�lhat�k)
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
		
//Lek�rdezi a k�zelben(hat�t�von bel�l) tal�lhat� ellens�geket. Ezek ut�n visszadja azt.
//Hogy meddig l�t el, az f�gg att�l, hogy milyen k�vekkel van felszerelve, �s van-e k�d a tornyon
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
		
//Felszereli a tornyot a param�terk�nt kapott k�vel
		public void addKo(Toronykovek ko){
			kovek.add(ko);
		}
		
//Inicializ�lja a mez�t, amint a torony �ll
		public void init(Mezo testMezo) {
			sajatMezo = testMezo;
		}
//Bek�d�s�ti a tornyot ha lesz�ll a k�d.
		public void kodosit(){
			kodos = true;
		}

//Leveszi a k�d�t, ha letelt az adott id�tartam;
		public void kitisztul(){
			kodos = false;
			kod = null;
		}
}