package szoftlab4;

import java.util.ArrayList;

public class Game {
	public  Jatekter jatekter;
	public  Controller controller;
	public  ArrayList<Torony> toronylista;

	Game(){
		jatekter = new Jatekter(new Jatekos());
		controller = new Controller(jatekter);
		toronylista = new ArrayList<Torony>();
	}
}
