package szoftlab4;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

public class Ellenseg implements Utravalo, Aktiv {
	
	public String id;
	public int irany=0;
	public int count=0;
	
	//Tartalmazza hogy az Elens�g �ppen melyik mez�n van rajta
	public Ut sajatUt;
	
	//Tartalmazza az Ellens�g �let�nek �rt�k�t
	//Lesz�rmazott oszt�lyokban fel�l�rni!
	protected int elet;
	
	//Tartalmazza, hogy az Ellens�g hal�la eset�n mennyivel n�vekszik a j�t�kos var�zsereje
	//Lesz�rmazott oszt�lyokban fel�l�rni!
	protected int ertek;
	
	//Az Ellens�g oszt�ly konstruktora
	//Lesz�rmazott oszt�lyban fel�l�rni!
	public Ellenseg(Ut sajat){
		sajatUt = sajat;
		elet = 0;
		ertek = 0;
	}
	
	//Ha tick t�rt�nik a rendszerben, ez a f�ggv�ny h�v�dik meg
	//Lesz�rmazott oszt�lyban fel�l�rni!
	public void tick(){
		
		if(count%4 == 0){
			ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
			lepek(lehetsegesutak);
			System.out.println(lehetsegesutak.size());
			count = 0;
		} else count++;
		
	}
	
	//Ha a k�zelben van egy V�gzethegye objektum, ezen f�ggv�ny seg�ts�g�vel t�madja meg azt
	public void tamad(VegzetHegye hegy){

	}
	
	//Ha az ellens�g �letereje null�ra cs�kken, ez a f�ggv�ny h�v�dik meg
	public void meghal(){
			
		sajatUt.levesz(this);
		Application.game.controller.meghaltam(ertek);
		

	}
	
	//Amikor az Elens�g l�p, ez a f�ggv�ny cser�li le az aktu�lis mez�t, amin �ll
	public void SajatUtCsere(Ut ujUt){
		
	//kicser�lj�k az utunkat az �j �tra
		sajatUt = ujUt;
		
	}
	
	//A torony h�vja meg, amennyiben le akarja l�ni az ellens�get
	//Az aloszt�lyokban fel�l kell �rni, a megfelel� logik�val!!!
	//TODO: Az aloszt�lyokban meg kell val�s�tani hogy ha has�t� l�ved�ket kap, akkor kett� v�ljon
	public void sebez(Lovedek lovedek){
		
	}
	
	//Kiv�laszt egy utat ahova l�pni szeretne
	public void lepek(ArrayList<Ut> utak){
		int x,y;
		switch (irany) {
			case 1:
				x = Application.game.getCoord(sajatUt).x;
				y = Application.game.getCoord(sajatUt).y;
				y--;
	
				for (Cella sj : utak) {
					if (Application.game.getCoord(sj).x == x
							&& Application.game.getCoord(sj).y == y) {
						sj.ratesz(this);
						return;
					}
				}
				break;
	
			 case 2:
				x = Application.game.getCoord(sajatUt).x;
				y = Application.game.getCoord(sajatUt).y;
				y++;
	
				for (Cella sj : utak) {
					if (Application.game.getCoord(sj).x == x
							&& Application.game.getCoord(sj).y == y) {
						sj.ratesz(this);
						return;
					}
				}
				break;
	
			 case 3:
				x = Application.game.getCoord(sajatUt).x;
				y = Application.game.getCoord(sajatUt).y;
				x--;
	
				for (Cella sj : utak) {
					if (Application.game.getCoord(sj).x == x
							&& Application.game.getCoord(sj).y == y) {
						sj.ratesz(this);
						return;
					}
				}
				break;
	
			 case 4:
				x = Application.game.getCoord(sajatUt).x;
				y = Application.game.getCoord(sajatUt).y;
				x++;
	
				for (Cella sj : utak) {
					if (Application.game.getCoord(sj).x == x
							&& Application.game.getCoord(sj).y == y) {
						sj.ratesz(this);
						return;
					}
				}
				break;
			 case 0:
			 default:
				break;
	
		}
		
	}
	
	//A sajatUt attrib�tumot inicializ�lja
	public void init(Ut sajat){
			sajatUt = sajat;
	}

}
