package szoftlab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 *	Prototípus fõprogram
 */
public class Application {
	
	Game game = new Game();
	private static Jatekos user = new Jatekos();
	private static Jatekter palya = new Jatekter(user);
	
	/*
	 *	Prototípus konzolos felületének parancsai 
	 */
	private static enum Code {
		loadmap, printstate, tick, printpower, printgems, buygem, addtower, addtowergem, 
		addtrapgem, addenemy, addspecialprojectile, addfog, enemydirection, exit, error, enter;
		
		/*
		 *	Paraméterként átadott sztringhez tartozó kódszó visszaadása
		 */
	    static Code parseString(String par) {
	        try {
	        	if(par.equals("")) return enter;
	            return valueOf(par);
	        } catch (NullPointerException ex){
	        	return enter;
	        } catch (IllegalArgumentException ex) {
	            return error;
	        }
	    }
	}
	
	public static void main(String[] args){
		try {
			startProto();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void startProto() throws IOException{
		System.out.println("A két torony - Prototípus /datcode/"); 
		System.out.println("");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Mindenkori konzolos bemenetként szolgál
		boolean exit_flag = false;
		String line = null;
		String[] parancs = null;
		
		try{
		
			while(!exit_flag)
			{
				try {										//A felhasználó választásának beolvasása
					line = br.readLine();					//Egy sor beolvasása
					parancs = line.split("\\s+"); 			//Sor tördelése szóközök mentén
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
				switch(Code.parseString(parancs[0])){		//parseString() enum típussal tér vissza
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
		
		} finally{
			if(br != null) br.close();
		}
	}

/*				
	switch(eset){						// Ha megfelelõen választ, végrehajtódik az adott programrészlet
	case 1: test.ujjatek(); break;
	case 2: test.ellenseglep(); break;
	case 3: test.ellensegszuletik(); break;
	case 4: test.toronyelhelyez(); break;
	case 5: test.akadalyelhelyez(); break;
	case 6: test.toronytuzel(); break;
	case 7: test.toronyfejleszt(); break;
	case 8: test.akadalyfejleszt(); break;
	case 9: test.kovasarol(); break;
	case 10: test.ellensegmeghal(); break;
	case 11: System.out.println("Kilépés"); break;
	default: System.out.println("Nincs ilyen parancs!");
	}
*/	
	
	
	public static void loadmap(String args[]){
		if(args.length > 1)	{
			System.out.println("Betoltes: " + args[1]);
			palya.betolt(args[1]);
			}
		else System.out.println("Invalid parameter");
	}
	public static void printstate(){

	}
	public static void tick(String args[]){
			int count = Integer.parseInt(args[0]);
			for(int i = 0;i<count;i++){
				for(int j = 0; j < Game.controller.aktiv.size();j++ ){
					Game.controller.aktiv.get(j).tick();
				}
			}
	}
	public static void printpower(){
		System.out.println("Varazsero "+ Game.jatekter.felhasznalo.varazsero);

	}
	public static void printgems(){
		
		int barna = 0;
		int sarga = 0;
		int narancs = 0;
		int kek = 0;
		int piros = 0;
		int zold = 0;
		int lila = 0;
		
		for(int i = 0;i<Game.jatekter.felhasznalo.varazskovek.size();i++){
			if(Game.jatekter.felhasznalo.varazskovek.get(i) instanceof Barnavarazsko)
				barna++;
			if(Game.jatekter.felhasznalo.varazskovek.get(i) instanceof Sargavarazsko)
				sarga++;
			if(Game.jatekter.felhasznalo.varazskovek.get(i) instanceof Narancsvarazsko)
				narancs++;
			if(Game.jatekter.felhasznalo.varazskovek.get(i) instanceof Kekvarazsko)
				kek++;
			if(Game.jatekter.felhasznalo.varazskovek.get(i) instanceof Pirosvarazsko)
				piros++;
			if(Game.jatekter.felhasznalo.varazskovek.get(i) instanceof Zoldvarazsko)
				zold++;
			if(Game.jatekter.felhasznalo.varazskovek.get(i) instanceof Lilavarazsko)
				lila++;
		}
		
			if(barna != 0)
				System.out.println("Barnavarazsko" + barna);
			if(kek != 0)
				System.out.println("Kekvarazsko" + kek);
			if(lila != 0)
				System.out.println("Lilavarazsko" + lila);
			if(narancs != 0)
				System.out.println("Narancsvarazsko" + narancs);
			if(piros != 0)
				System.out.println("Pirosvarazsko" + piros);
			if(sarga!= 0)
				System.out.println("Sargavarazsko" + sarga);
			if(zold != 0)
				System.out.println("Zoldvarazsko" + zold);
			

	}
	public static void buygem(String args[]){
		
		boolean success false;
		if(args[0].matches("barna") && Game.jatekter.felhasznalo.varazsero>50){
			Game.jatekter.felhasznalo.varazskovek.add(new Barnavarazsko());
			success = true;
		}
		if(args[0].matches("kek") && Game.jatekter.felhasznalo.varazsero>50){
			Game.jatekter.felhasznalo.varazskovek.add(new Kekvarazsko());
		success = true;
		}
		if(args[0].matches("lila") && Game.jatekter.felhasznalo.varazsero>50){
			Game.jatekter.felhasznalo.varazskovek.add(new Lilavarazsko());
		success = true;
        }
		if(args[0].matches("narancs") && Game.jatekter.felhasznalo.varazsero>50){
			Game.jatekter.felhasznalo.varazskovek.add(new Narancsvarazsko());
		success = true;
		}
		if(args[0].matches("piros") && Game.jatekter.felhasznalo.varazsero>50){
			Game.jatekter.felhasznalo.varazskovek.add(new Pirosvarazsko());
		success = true;
	    }
		if(args[0].matches("sarga") && Game.jatekter.felhasznalo.varazsero>50){
			Game.jatekter.felhasznalo.varazskovek.add(new Sargavarazsko());
		success = true;
	    }
		if(args[0].matches("zold") && Game.jatekter.felhasznalo.varazsero>50){
			Game.jatekter.felhasznalo.varazskovek.add(new Zoldvarazsko());
		success = true;
		}
		
	}
	
	public static void addtower(String args[]){
		int sor = Integer.parseInt(args[1]);
		int oszlop = Integer.parseInt(args[2]);
		boolean joid = true;
		
		for(int i = 0;i<Game.toronylista.size();i++){
			if(Game.toronylista.get(i).id.matches(args[0]))
				joid = false;
		}
		
		if(joid){
			Torony uj = new Torony(args[0]);
			Game.toronylista.add(uj);
			Cella valasztott = Game.jatekter.cellak.get(sor).get(oszlop);
			if(valasztott.mezovagyok())
			Game.jatekter.felhasznalo.ujTorony((Mezo)valasztott, uj);
				}
		else{
			System.out.println("Mar letezo ID");
		}
	}
	public static void addtowergem(String args[]){
			
	} 
	public static void addtrapgem(String args[]){

	}
	public static void addenemy(String args[]){

	}
	public static void addspecialprojectile(String args[]){

	}
	public static void addfog(String args[]){

	}
	public static void enemydirection(String args[]){

	}
	public static void exit(){

	}
	
}
