package szoftlab4;

import java.io.IOException;
import java.util.ArrayList;

//Torony osztály
public class Torony implements Aktiv, Mezorevalo {
		private Mezo sajatMezo;
		private int hatotav;
		private int tuzgyak;
		private int sebzes;
		ArrayList<Toronykovek> kovek;
	
//Torony publikus konstruktora
		Torony(){
			hatotav=1;
			tuzgyak=1;
			sebzes=1;
			kovek = new ArrayList<Toronykovek>();
			sajatMezo = new Mezo();
		}
//Ha történik a rendszerben egy tick(), ez a metódus hívódik meg	
		public void tick(){
			Log.log(LogType.CALL, this, "tick()");
			
			Log.log(LogType.KERDES, null, "Lõjön most a torony? [true/false]");
			
			String inS = null;
			try {
				inS = Log.br.readLine();
				if(inS.equals("true")) tuzel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Log.log(LogType.RETURN, null, "tick()");
		}
//Létrehoz egy lövedéket, amit egy ellenségnek átadva, sebezzük azt		
		private Lovedek createLovedek(){
			Log.log(LogType.CALL, this, "createLovedek()");
			
			Lovedek lov = new Lovedek();
			Log.add(lov, "lovedek");
			
			Log.log(LogType.RETURN, Log.map.get(lov), "createLovedek()");
			return lov;
		}
//Amennyiben a tick() meghívja, a torony tüzelni fog. Elõször létrehoz egy lövedéket, majd
//átadja azt a sebezni kívánt ellenségnek.
		public void tuzel() throws NumberFormatException, IOException{
			Log.log(LogType.CALL, this, "tuzel()");
			
			ArrayList<Ellenseg> ellen = lekerdez(1);
			Lovedek lov = createLovedek();
			
			Tesztesetek.testEllenseg.sebez(lov);
			
			Log.log(LogType.RETURN, null, "tuzel()");
		}
		
//Lekérdezi a közelben lévõ ellenségeket. Ezek után visszadja azt.
		public ArrayList<Ellenseg> lekerdez(int melyseg){
			Log.log(LogType.CALL, this, "lekerdez()");
			
			ArrayList<Ut> utak = sajatMezo.kozelbenvan(melyseg);
			ArrayList<Ellenseg> ellen = new ArrayList<Ellenseg>();
			
			Log.log(LogType.KERDES, null, "Van ellenség az utakon? [true/false]");
			try {
				if((Log.br.readLine()).equals("true")) return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Log.log(LogType.RETURN, Log.map.get(Tesztesetek.testEllenseg), "lekerdez()");
			return ellen;
		}
		
//Felszereli a tornyot a paraméterkét kapott kõvel
		public void addKo(Toronykovek ko){
			Log.log(LogType.CALL, this, "addKo()");
			kovek.add(ko);
			Log.log(LogType.RETURN, null, "addKo()");
		}
		
//Inicializálja a mezõt, amint a torony áll
		public void init(Mezo testMezo) {
			Log.log(LogType.CALL, this, "init()");
			sajatMezo = testMezo;
			Log.log(LogType.RETURN, null, "init()");
		}
}