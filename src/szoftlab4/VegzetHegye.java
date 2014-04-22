package szoftlab4;

public class VegzetHegye implements Utravalo {
	
	//Ez t�rolja hogy melyik cell�n van az objektum
	private Ut sajatUt;
	
	//A VegzetHegye �let�t tartalmazza
	public int elet;
		
	//Konstruktor, ami inicializ�lja az objektumot.
	public VegzetHegye(){
		sajatUt = null;
		elet = 100;
	}
	public VegzetHegye(Cella sj){
		sajatUt = (Ut)sj;
		elet = 100;
	}
	
	//A torony �let�t lecs�kkkenti a param�terben kapott mennyis�ggel
	//Amennyiben a torony �lete negat�v tartom�nyba esik, megh�vja a meghal() f�ggv�nyt.
	public void sebez(int egyseg){
			elet = elet-egyseg;
			if(elet<0)
				meghal();
	}
			
	//Akkor h�v�dik meg, hogyha a torony ereje annyira lecs�kken, hogy a toronynak el kell
	//pusztulnia
	public void meghal(){
		Application.game.controller.endgame(true);
	}
	
	
	//Inicializ�lja az oszt�j sajatUt attrib�tum�t, ami tartalmazza hogy az elem
	//melyik cell�n van rajta
	public void init(Ut sajat){
		sajatUt = sajat;
	}
	
	public int getElet(){
		return elet;
	}
}
