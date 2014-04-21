package szoftlab4;

public class Game {
	public static Jatekter jatekter;
	public static Controller controller;

	Game(){
		jatekter = new Jatekter(new Jatekos());
		controller = new Controller(jatekter);
	}
}
