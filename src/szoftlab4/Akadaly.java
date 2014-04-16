package szoftlab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Akadaly implements Utravalo {
	
	//Attribútum annak a tárolására, hogy az Akadály melyik Ut-on áll
	private Ut sajatUt;
	
	//Tartalmazza, hogy mekkora mértékben lassítja az ellenfelet.
	private int lassitas;
	
	//Amennyiben a torony fel van szerelve kõvel, ennek az értéke nem null.
	private Lilavarazsko ko;
	
	//Az Akadály osztály publikus konstruktora
	public Akadaly(){
		sajatUt = null;
		lassitas = 0;
		ko = null;
	}
	
	//Függvény ami visszaadja, hogy az adott körben léphet-e az Ellenség
	public boolean lephete(){
		Log.log(LogType.CALL, this, "lephete()");
		
		Log.log(LogType.KERDES, null, "Léphet? [true/false]");
		// Szkeleton miatt ELEJE
		
		Log.br = new BufferedReader(new InputStreamReader(System.in));
		String s= "";
		boolean valasz = false;
		try {
			s = Log.br.readLine();
			if (s.equals("true")) valasz = true;	// Ha true akkor megváltoztatja a válasz értékét logikai igazra.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Log.log(LogType.RETURN, null, s);	
		return valasz;
	}
	
	//Inicializálja a sajatUt attribútumot
	public void init(Ut sajatUt){
		Log.log(LogType.CALL, this, "init(Ut sajatUt)");
		Log.log(LogType.RETURN, null, "void");
	}
	
	//Lilavarázskövet hozzáadja az akadályhoz. A fejlesztés során hívódik meg
	public void addko(Lilavarazsko varazsko){
		Log.log(LogType.CALL, this, "addko()");
		ko = varazsko;
		Log.log(LogType.RETURN, this, "void");
	}
	

}
