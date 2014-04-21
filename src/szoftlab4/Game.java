package szoftlab4;

import java.util.ArrayList;

public class Game {
	public static Jatekter jatekter;
	public static Controller controller;
	public static ArrayList<Torony> toronylista;

	Game(){
		jatekter = new Jatekter(new Jatekos());
		controller = new Controller(jatekter);
		toronylista = new ArrayList<Torony>();
	}
}
