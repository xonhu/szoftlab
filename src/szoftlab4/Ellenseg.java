package szoftlab4;

import java.io.IOException;
import java.util.ArrayList;

public class Ellenseg implements Utravalo, Aktiv {
	
	//Tartalmazza hogy az Elenség éppen melyik mezõn van rajta
	private Ut sajatUt;
	
	//Tartalmazza az Ellenség életének értékét
	private int elet;
	
	//Tartalmazza, hogy az Ellenség halála esetén mennyivel növekszik a játékos varázsereje
	private int ertek;
	
	//Az Ellenség osztály konstruktora
	public Ellenseg(Ut sajat){
		sajatUt = sajat;
		elet = 50;
		ertek = 50;
	}
	
	//Ha tick történik a rendszerben, ez a függvény hívódik meg
	public void tick(){
		Log.log(LogType.CALL, this, "tick()");
		
		Tesztesetek.testUt.lepnek();
		
		Log.log(LogType.KERDES, null, "Talált-e utat amire léphet? [true/false]");
		String s= "";
		boolean valasz = false;
		try {
			s = Log.br.readLine();
			if (s.equals("true")) valasz = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (valasz == true){
			lepek(null);
		}
		
		
		Log.log(LogType.RETURN, null, "void");
	}
	
	//Ha a közelben van egy Végzethegye objektum, ezen függvény segítségével támadja meg azt
	public void tamad(VegzetHegye hegy){
		Log.log(LogType.CALL, this, "tamad(VegzetHegye()");
		Log.log(LogType.RETURN, null, "void");
	}
	
	//Ha az ellenség életereje nullára csökken, ez a függvény hívódik meg
	public void meghal(){
		Log.log(LogType.CALL, this, "meghal()");
		
		sajatUt.levesz(this);
		Tesztesetek.testController.meghaltam(ertek);
		
		Log.log(LogType.RETURN, null, "void");
	}
	
	//Amikor az Elenség lép, ez a függvény cseréli le az aktuális mezõt, amin áll
	public void SajatUtCsere(Ut ujUt){
		Log.log(LogType.CALL, this, "SajatUtCsere(Ut ujUt)");
		Log.log(LogType.RETURN, null, "void");
	}
	
	//A torony hívja meg, amennyiben le akarja lõni az ellenséget
	public void sebez(Lovedek lovedek){
		Log.log(LogType.CALL, this, "sebez(Lovedek lovedek)");
		boolean meghal = false;
		String meghalstring = null;
		
		Log.log(LogType.KERDES, null, "Meghaljon? [true/false]");
		try {
			meghalstring = Log.br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(meghalstring.matches("true"))
			meghal();
		
		Log.log(LogType.RETURN, null, "void");
	}
	
	//Kiválaszt egy Ut-at ahova lépni szeretne
	public void lepek(ArrayList<Ut> utak){
		Log.log(LogType.CALL, this, "lepek(ArrayList<Ut> utak)");
		Tesztesetek.testKovetkezoUt.ratesz(this);
		Log.log(LogType.RETURN, null, "void");
	}
	
	//A sajatUt attribútumot inicializálja
	public void init(Ut sajatUt){
		Log.log(LogType.CALL, this, "init(Ut sajatUt)");
		Log.log(LogType.RETURN, null, "void");
	}

}
