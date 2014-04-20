package szoftlab4;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

public class Ellenseg implements Utravalo, Aktiv {
	
	//Tartalmazza hogy az Elenség éppen melyik mezõn van rajta
	private Ut sajatUt;
	
	//Tartalmazza az Ellenség életének értékét
	//Leszármazott osztályokban felülírni!
	private int elet;
	
	//Tartalmazza, hogy az Ellenség halála esetén mennyivel növekszik a játékos varázsereje
	//Leszármazott osztályokban felülírni!
	private int ertek;
	
	//Az Ellenség osztály konstruktora
	//Leszármazott osztályban felülírni!
	public Ellenseg(Ut sajat){
		sajatUt = sajat;
		elet = 50;
		ertek = 50;
	}
	
	//Ha tick történik a rendszerben, ez a függvény hívódik meg
	//Leszármazott osztályban felülírni!
	public void tick(){
		
	//TODO: Ide kell egy logika, ami megmondja hogy az ellenség a körben léphet-e, lépni szeretne.
		if(false){
			ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
			lepek(lehetsegesutak);
		}
		
	}
	
	//Ha a közelben van egy Végzethegye objektum, ezen függvény segítségével támadja meg azt
	public void tamad(VegzetHegye hegy){

	}
	
	//Ha az ellenség életereje nullára csökken, ez a függvény hívódik meg
	public void meghal(){
			
		sajatUt.levesz(this);
		Game.controller.meghaltam(ertek);
		

	}
	
	//Amikor az Elenség lép, ez a függvény cseréli le az aktuális mezõt, amin áll
	public void SajatUtCsere(Ut ujUt){
		
	//kicseréljük az utunkat az új útra
		sajatUt = ujUt;
		
	}
	
	//A torony hívja meg, amennyiben le akarja lõni az ellenséget
	//Az alosztályokban felül kell írni, a megfelelõ logikával!!!
	public void sebez(Lovedek lovedek){
		
	}
	
	//Kiválaszt egy utat ahova lépni szeretne
	public void lepek(ArrayList<Ut> utak){
		 Random randomGenerator = new Random();
		 int index = randomGenerator.nextInt(utak.size());
         Ut kovetkezout = utak.get(index);
		kovetkezout.ratesz(this);
	}
	
	//A sajatUt attribútumot inicializálja
	public void init(Ut sajat){
			sajatUt = sajat;
	}

}
