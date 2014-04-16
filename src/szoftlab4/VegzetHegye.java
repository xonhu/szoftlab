package szoftlab4;

public class VegzetHegye implements Utravalo {
	
	//Ez tárolja hogy melyik cellán van az objektum
	private Ut sajatUt;
	
	//A VegzetHegye életét tartalmazza
	private int elet;
		
	//Konstruktor, ami inicializálja az objektumot.
	public VegzetHegye(){
		
		Log.add(this, "VegzetHegye");
		Log.log(LogType.NEW, this, null);
		sajatUt = null;
		elet = 500;
	}
	
	//A torony életét lecsökkkenti a paraméterben kapott mennyiséggel
	//Amennyiben a torony élete negatív tartományba esik, meghívja a meghal() függvényt.
	public void sebez(int egyseg){
		Log.log(LogType.CALL, this, "sebez(int egyseg)");
		Log.log(LogType.RETURN, null, "void");	
	}
			
	//Akkor hívódik meg, hogyha a torony ereje annyira lecsökken, hogy a toronynak el kell
	//pusztulnia
	public void meghal(){
		Log.log(LogType.CALL, this, "meghal()");
		Log.log(LogType.RETURN, null, "void");					
	}
	
	
	//Inicializálja az osztáj sajatUt attribútumát, ami tartalmazza hogy az elem
	//melyik cellán van rajta
	public void init(Ut sajatUt){
		Log.log(LogType.CALL, this, "init(Ut sajatUt)");
		Log.log(LogType.RETURN, null, "void");		
		
	}
}
