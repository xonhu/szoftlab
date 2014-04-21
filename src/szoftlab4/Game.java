package szoftlab4;

import java.util.ArrayList;

public class Game {
	public Jatekter jatekter;
	public Controller controller;
	public ArrayList<Torony> toronylista;
	public ArrayList<Ellenseg> ellenseglista;
	public ArrayList<Ut> utlista;
	public ArrayList<Akadaly> akadalylista;

	Game(){
		jatekter = new Jatekter(new Jatekos());
		controller = new Controller(jatekter);
		toronylista = new ArrayList<Torony>();
		ellenseglista = new ArrayList<Ellenseg>();
		utlista = new ArrayList<Ut>();
		akadalylista = new ArrayList<Akadaly>();
	}
}
