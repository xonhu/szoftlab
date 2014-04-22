package szoftlab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 *	Protot�pus f�program
 */
public class Application {

	public static Game game = new Game();

	/*
	 * Protot�pus konzolos fel�let�nek parancsai
	 */
	private static enum Code {
		loadmap, printstate, tick, printpower, printgems, buygem, addtower, addtowergem, addtrap, addtrapgem, addenemy, addspecialprojectile, addfog, enemydirection, exit, error, enter;

		/*
		 * Param�terk�nt �tadott sztringhez tartoz� k�dsz� visszaad�sa
		 */
		static Code parseString(String par) {
			try {
				if (par.equals(""))
					return enter;
				return valueOf(par);
			} catch (NullPointerException ex) {
				return enter;
			} catch (IllegalArgumentException ex) {
				return error;
			}
		}
	}

	public static void main(String[] args) {
		try {
			startProto();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void startProto() throws IOException {
		//System.out.println("A k�t torony - Protot�pus /datcode/");
		//System.out.println("");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Mindenkori
																					// konzolos
																					// bemenetk�nt
																					// szolg�l
		boolean exit_flag = false;
		String line = null;
		String[] parancs = null;

		try {

			while (!exit_flag) {
				try { // A felhaszn�l� v�laszt�s�nak beolvas�sa
					line = br.readLine(); // Egy sor beolvas�sa
					parancs = line.split("\\s+"); // Sor t�rdel�se sz�k�z�k
													// ment�n
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}

				switch (Code.parseString(parancs[0])) { // parseString() enum
														// t�pussal t�r vissza
				case loadmap:
					loadmap(parancs);
					break;
				case printstate:
					printstate();
					break;
				case tick:
					tick(parancs);
					break;
				case printpower:
					printpower();
					break;
				case printgems:
					printgems();
					break;
				case buygem:
					buygem(parancs);
					break;
				case addtower:
					addtower(parancs);
					break;
				case addtowergem:
					addtowergem(parancs);
					break;
				case addtrapgem:
					addtrapgem(parancs);
					break;
				case addtrap:
					addtrap(parancs);
					break;
				case addenemy:
					addenemy(parancs);
					break;
				case addspecialprojectile:
					addspecialprojectile(parancs);
					break;
				case addfog:
					addfog(parancs);
					break;
				case enemydirection:
					enemydirection(parancs);
					break;
				case exit:
					exit();
					exit_flag = true;
					break;
				case error:
					System.out.println("Bad command");
					break;
				case enter:
					break;
				default:
					break;
				}
			}

		} finally {
			if (br != null)
				br.close();
		}
	}

	/*
	 * switch(eset){ // Ha megfelel�en v�laszt, v�grehajt�dik az adott
	 * programr�szlet case 1: test.ujjatek(); break; case 2: test.ellenseglep();
	 * break; case 3: test.ellensegszuletik(); break; case 4:
	 * test.toronyelhelyez(); break; case 5: test.akadalyelhelyez(); break; case
	 * 6: test.toronytuzel(); break; case 7: test.toronyfejleszt(); break; case
	 * 8: test.akadalyfejleszt(); break; case 9: test.kovasarol(); break; case
	 * 10: test.ellensegmeghal(); break; case 11: System.out.println("Kil�p�s");
	 * break; default: System.out.println("Nincs ilyen parancs!"); }
	 */

	public static void loadmap(String args[]) {
		if (args.length > 1) {
			Application.game.jatekter.betolt(args[1]);
			System.out.println("Map loaded");
		} else
			System.out.println("Invalid parameter");
	}

	public static void printstate() {
		for (int i = 0; i < game.toronylista.size(); i++) {
			int x = game.getCoord(game.toronylista.get(i).sajatMezo).x;
			int y = game.getCoord(game.toronylista.get(i).sajatMezo).y;
			System.out.println("Torony " + game.toronylista.get(i).id + " " + y
					+ " " + x);
		}

		for (int i = 0; i < game.ellenseglista.size(); i++) {
			int x = game.getCoord(game.ellenseglista.get(i).sajatUt).x;
			int y = game.getCoord(game.ellenseglista.get(i).sajatUt).y;
			if (game.ellenseglista.get(i) instanceof Hobbit)
				System.out.println("Hobbit " + game.ellenseglista.get(i).id  + " " + y
						+ " " + x + " "+ game.ellenseglista.get(i).elet);
			if (game.ellenseglista.get(i) instanceof Ember)
				System.out.println("Ember " + game.ellenseglista.get(i).id  + " " + y
						+ " " + x + " "+ game.ellenseglista.get(i).elet);
			if (game.ellenseglista.get(i) instanceof Tunde)
				System.out.println("Tunde "+ game.ellenseglista.get(i).id  + " " + y
						+ " " + x + " "+ game.ellenseglista.get(i).elet);
			if (game.ellenseglista.get(i) instanceof Torpe)
				System.out.println("Torpe " + game.ellenseglista.get(i).id  + " " + y
						+ " " + x + " "+ game.ellenseglista.get(i).elet);
		}

		for (int i = 0; i < game.akadalylista.size(); i++) {
			int x = game.getCoord(game.akadalylista.get(i).sajatUt).x;
			int y = game.getCoord(game.akadalylista.get(i).sajatUt).y;
			System.out.println("Akadaly " + game.akadalylista.get(i).id + " " + y +" " +x);
		}
		
		if(game.hegy != null)
			System.out.println("Vegzet Hegye " + game.hegy.elet);
		
		

	}

	public static void tick(String args[]) {
		int count = 0;
		if (args.length > 1)
			count = Integer.parseInt(args[1]);
		else
			count = 1;
		int i = 0;
		for (i = 0; i < count; i++) {
			for (int j = 0; j < game.controller.aktiv.size(); j++) {
				game.controller.aktiv.get(j).tick();
			}
		}
		System.out.println(i + " tick megtortent");
	}

	public static void printpower() {
		System.out.println("Varazsero " + game.jatekter.felhasznalo.varazsero);

	}

	public static void printgems() {

		int barna = 0;
		int sarga = 0;
		int narancs = 0;
		int kek = 0;
		int piros = 0;
		int zold = 0;
		int lila = 0;

		for (int i = 0; i < game.jatekter.felhasznalo.varazskovek.size(); i++) {
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Barnavarazsko)
				barna++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Sargavarazsko)
				sarga++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Narancsvarazsko)
				narancs++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Kekvarazsko)
				kek++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Pirosvarazsko)
				piros++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Zoldvarazsko)
				zold++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Lilavarazsko)
				lila++;
		}

		if (barna != 0)
			System.out.println("Barnavarazsko " + barna);
		if (kek != 0)
			System.out.println("Kekvarazsko " + kek);
		if (lila != 0)
			System.out.println("Lilavarazsko " + lila);
		if (narancs != 0)
			System.out.println("Narancsvarazsko " + narancs);
		if (piros != 0)
			System.out.println("Pirosvarazsko " + piros);
		if (sarga != 0)
			System.out.println("Sargavarazsko " + sarga);
		if (zold != 0)
			System.out.println("Zoldvarazsko " + zold);

	}

	public static void buygem(String args[]) {
		boolean success = false;
		boolean megveve = false;
		if(args.length > 1){
		if (args[1].matches("barna")){
			if(game.jatekter.felhasznalo.varazsero >= 50){
				game.jatekter.felhasznalo.varazskovek.add(new Barnavarazsko());
				game.jatekter.felhasznalo.varazserotVeszit(30);
				megveve =true;
			}
			else System.out.println("Nincs eleg varazsero");
			success = true;
		}
		else if (args[1].matches("kek")){
			if(game.jatekter.felhasznalo.varazsero >= 30){
				game.jatekter.felhasznalo.varazskovek.add(new Kekvarazsko());
				game.jatekter.felhasznalo.varazserotVeszit(30);
				megveve =true;

			}
			else System.out.println("Nincs eleg varazsero");
			success = true;
		}
		else if (args[1].matches("lila")){
			if(game.jatekter.felhasznalo.varazsero >= 30){
				game.jatekter.felhasznalo.varazskovek.add(new Lilavarazsko());
				game.jatekter.felhasznalo.varazserotVeszit(30);
				megveve =true;

			}
			else System.out.println("Nincs eleg varazsero");
			success = true;
		}
		else if (args[1].matches("narancs")){
			if(game.jatekter.felhasznalo.varazsero >= 30){
				game.jatekter.felhasznalo.varazskovek.add(new Narancsvarazsko());
				game.jatekter.felhasznalo.varazserotVeszit(30);
				megveve =true;

			}
			else System.out.println("Nincs eleg varazsero");
			success = true;
		}
		else if (args[1].matches("piros")){
			if(game.jatekter.felhasznalo.varazsero >= 30){
				game.jatekter.felhasznalo.varazskovek.add(new Pirosvarazsko());
				game.jatekter.felhasznalo.varazserotVeszit(30);
				megveve =true;

			}
			else System.out.println("Nincs eleg varazsero");
			success = true;
		}
		else if (args[1].matches("sarga")){
			if(game.jatekter.felhasznalo.varazsero >= 30){
				game.jatekter.felhasznalo.varazskovek.add(new Sargavarazsko());
				game.jatekter.felhasznalo.varazserotVeszit(30);
				megveve =true;

			}
			else System.out.println("Nincs eleg varazsero");
			success = true;
		}
		else if (args[1].matches("zold")){
			if(game.jatekter.felhasznalo.varazsero >= 30){
				game.jatekter.felhasznalo.varazskovek.add(new Zoldvarazsko());
				game.jatekter.felhasznalo.varazserotVeszit(30);
				megveve =true;

			}
			else System.out.println("Nincs eleg varazsero");
			success = true;
		}
		}
		if (!success)
			System.out.println("Bad parameter");
		else if(megveve){
			System.out.println("Varazsko megvasarolva");
		}
		}



	public static void addtower(String args[]) {
		int sor = Integer.parseInt(args[2]);
		int oszlop = Integer.parseInt(args[3]);
		boolean joid = true;

		for (int i = 0; i < game.toronylista.size(); i++) {
			if (game.toronylista.get(i).id.matches(args[1]))
				joid = false;
		}

		if (joid) {
			Torony uj = new Torony(args[1]);
			game.toronylista.add(uj);
			game.controller.aktiv.add(uj);
			Cella valasztott = game.jatekter.cellak.get(sor).get(oszlop);
			if (valasztott.mezovagyok())
				game.jatekter.felhasznalo.ujTorony((Mezo) valasztott, uj);
		} else {
			System.out.println("Mar letezo ID");
		}
	}

	public static void addtowergem(String args[]) {
		String id = null;
		boolean success = false;
		Torony erre = null;
		for (int i = 0; i < game.toronylista.size(); i++) {
			if (game.toronylista.get(i).id.matches(args[1]))
				id = game.toronylista.get(i).id;
			erre = game.toronylista.get(i);
		}
		if (id == null) {
			System.out.println("Nem letezo ID");
		}

		if (erre != null) {
			if (args[2].matches("barna")) {
				game.jatekter.felhasznalo.fejleszt(erre, new Barnavarazsko());
				success = true;
			}
			if (args[2].matches("kek")) {
				game.jatekter.felhasznalo.fejleszt(erre, new Kekvarazsko());
				success = true;
			}
			if (args[2].matches("narancs")) {
				game.jatekter.felhasznalo.fejleszt(erre, new Narancsvarazsko());
				success = true;
			}
			if (args[2].matches("piros")) {
				game.jatekter.felhasznalo.fejleszt(erre, new Pirosvarazsko());
				success = true;
			}
			if (args[2].matches("sarga")) {
				game.jatekter.felhasznalo.fejleszt(erre, new Sargavarazsko());
				success = true;
			}
			if (args[2].matches("zold")) {
				game.jatekter.felhasznalo.fejleszt(erre, new Zoldvarazsko());
				success = true;
			}
		}

		if (!success)
			System.out.println("Bad parameter");
		if (success)
			System.out.println("Varazsko hozzaadva");

	}

	public static void addtrapgem(String args[]) {
		boolean megvan = false;
		int index = 0;
		Lilavarazsko l = new Lilavarazsko();
		if (game.jatekter.felhasznalo.varazskovek.contains(l)) {

			while (megvan == false && index < game.akadalylista.size()) {
				if (game.akadalylista.get(index).id.equals(args[1])) {
					game.akadalylista.get(index).addko(l);
					System.out.printf("Varazsko hozzaadva \n");
					megvan = true;

				} else {
					index++;
				}
			}
			if (megvan == false) {
				System.out.printf("Nem letezo ID\n");
			}
		} else {
			System.out.printf("Nem letezo varazsko\n");
		}
	}

	public static void addenemy(String args[]) {
		int sor = Integer.parseInt(args[3]);
		int oszlop = Integer.parseInt(args[4]);
		Cella valasztott = (Ut)game.jatekter.cellak.get(sor).get(oszlop);
		if (!valasztott.mezovagyok()) {
			int type = 0;
			if (args[1].matches("hobbit"))
				type = 0;
			else if (args[1].matches("ember"))
				type = 1;
			else if (args[1].matches("tunde"))
				type = 2;
			else if (args[1].matches("torpe"))
				type = 3;
			else{
				System.out.println("Bad parameter");
				return;
			}

			switch (type) {
			case 0:
				Hobbit h = new Hobbit((Ut) valasztott);
				game.controller.aktiv.add(h);
				h.id = args[2];
				valasztott.ratesz(h);
				game.ellenseglista.add(h);
				System.out.println("Ellenseg letrehozva");
				break;
			case 1:
				Ember e = new Ember((Ut) valasztott);
				game.controller.aktiv.add(e);
				e.id = args[2];
				valasztott.ratesz(e);
				game.ellenseglista.add(e);
				System.out.println("Ellenseg letrehozva");
				break;
			case 2:
				Tunde t = new Tunde((Ut) valasztott);
				game.controller.aktiv.add(t);
				t.id = args[2];
				valasztott.ratesz(t);
				game.ellenseglista.add(t);
				System.out.println("Ellenseg letrehozva");
				break;
			case 3:
				Torpe t1 = new Torpe((Ut) valasztott);
				game.controller.aktiv.add(t1);
				t1.id = args[2];
				valasztott.ratesz(t1);
				game.ellenseglista.add(t1);
				System.out.println("Ellenseg letrehozva");
				break;
			default:
				System.out.println("Bad parameter");
			}
			

		} else {
			System.out.printf(" Nem mezo, vagy valami baj van \n");
		}

	}

	public static void addspecialprojectile(String args[]) {

		if (args.length == 1) {
			Torony ebben = null;
			for (int i = 0; i < game.toronylista.size(); i++) {
				if (args[1].matches(game.toronylista.get(i).id))
					;
				ebben = game.toronylista.get(i);
			}
			ebben.specprojectile = true;
			System.out.println("Specialis lovedek hozzaadva");

		} else
			System.out.println("Bad parameters");

	}

	public static void addfog(String args[]) {
		boolean megvan = false;
		int index = 0;
		while (megvan == false && index < game.toronylista.size()) {
			if (game.toronylista.get(index).id.matches(args[1])) {
				game.toronylista.get(index).kodosit();
				megvan = true;
				System.out.println("Kod hozzaadva");
			} else {
				index++;
			}
		}
		if (!megvan)
			System.out.println("Nem letezo ID");
	}

	public static void enemydirection(String args[]) {
		if(args.length > 2){
			boolean megvan = false;
			int index = 0;
			for (Ellenseg ell : game.ellenseglista) {
				if (ell.id.matches(args[1])) {
					index = game.ellenseglista.indexOf(ell);
					megvan = true;
				}
			}



			if (megvan) {
				Ellenseg temp = game.ellenseglista.get(index);
				if (args[2].matches("N"))
					temp.irany = 1;
				else if (args[2].matches("S"))
					temp.irany = 2;
				else if (args[2].matches("E"))
					temp.irany = 3;
				else if (args[2].matches("W"))
					temp.irany = 4;
				else
					temp.irany = 0;

				System.out.println("Ellenseg iranya beallitva");
			} else
				System.out.printf("Invalid Parameter \n");

		}
		else System.out.println("Bad parameters");

	}
	public static void addtrap(String[] args) {
		int sor = Integer.parseInt(args[2]);
		int oszlop = Integer.parseInt(args[3]);
		boolean joid = true;

		for (int i = 0; i < game.akadalylista.size(); i++) {
			if (game.akadalylista.get(i).id.matches(args[1]))
				joid = false;
		}

		if (joid) {
			Akadaly uj = new Akadaly(args[1]);
			game.akadalylista.add(uj);
			Cella valasztott = game.jatekter.cellak.get(sor).get(oszlop);
			if (!valasztott.mezovagyok())
				game.jatekter.felhasznalo.ujAkadaly((Ut) valasztott, uj);
		} else {
			System.out.println("Mar letezo ID");
		}
	}

	public static void exit() {
		System.out.println("Szia!");
		System.exit(0);
	}

}
