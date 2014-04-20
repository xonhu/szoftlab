package szoftlab4;

public class VegzetHegye implements Utravalo {
	
	//Ez tárolja hogy melyik cellán van az objektum
	private Ut sajatUt;
	
	//A VegzetHegye életét tartalmazza
	private int elet;
		
	//Konstruktor, ami inicializálja az objektumot.
	public VegzetHegye(){
		sajatUt = null;
		elet = 500;
	}
	
	//A torony életét lecsökkkenti a paraméterben kapott mennyiséggel
	//Amennyiben a torony élete negatív tartományba esik, meghívja a meghal() függvényt.
	public void sebez(int egyseg){
			elet = elet-egyseg;
			if(elet<0)
				meghal();
	}
			
	//Akkor hívódik meg, hogyha a torony ereje annyira lecsökken, hogy a toronynak el kell
	//pusztulnia
	public void meghal(){
		Game.controller.endgame(true);
	}
	
	
	//Inicializálja az osztáj sajatUt attribútumát, ami tartalmazza hogy az elem
	//melyik cellán van rajta
	public void init(Ut sajat){
		sajatUt = sajat;
	}
}
