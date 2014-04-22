package szoftlab4;

import java.util.ArrayList;

public class Game {
	public Jatekter jatekter;
	public Controller controller;
	public ArrayList<Torony> toronylista;
	public ArrayList<Ellenseg> ellenseglista;
	public ArrayList<Ut> utlista;
	public ArrayList<Akadaly> akadalylista;
	public VegzetHegye hegy;

	Game(){
		jatekter = new Jatekter(new Jatekos());
		controller = new Controller(jatekter);
		toronylista = new ArrayList<Torony>();
		ellenseglista = new ArrayList<Ellenseg>();
		utlista = new ArrayList<Ut>();
		akadalylista = new ArrayList<Akadaly>();
	}
	
	public class Coord{
		public int x,y;
		Coord(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public Coord getCoord(Cella cell){
		int x,y;
		for(ArrayList<Cella> sor : Application.game.jatekter.cellak)
			if(sor.contains(cell)){
				y = Application.game.jatekter.cellak.indexOf(sor);
				x = sor.indexOf(cell);
				return new Coord(x, y);
			}
		return new Coord(0,0);
	}
}
