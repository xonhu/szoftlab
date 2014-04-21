package szoftlab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 *	Prototípus fõprogram
 */
public class Application {
	
	public static Game game = new Game();
	
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
	        	if(par.matches("")) return enter;
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
			Application.game.jatekter.betolt(args[1]);
			System.out.println("Map loaded");
			}
		else System.out.println("Invalid parameter");
	}
	public static void printstate(){
	}
	public static void tick(String args[]){
			int count = Integer.parseInt(args[0]);
			for(int i = 0;i<count;i++){
				for(int j = 0; j < game.controller.aktiv.size();j++ ){
					Application.game.controller.aktiv.get(j).tick();
				}
			}
	}
	public static void printpower(){
		System.out.println("Varazsero "+ game.jatekter.felhasznalo.varazsero);

	}
	public static void printgems(){
		
		int barna = 0;
		int sarga = 0;
		int narancs = 0;
		int kek = 0;
		int piros = 0;
		int zold = 0;
		int lila = 0;
		
		for(int i = 0;i<game.jatekter.felhasznalo.varazskovek.size();i++){
			if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Barnavarazsko)
				barna++;
			if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Sargavarazsko)
				sarga++;
			if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Narancsvarazsko)
				narancs++;
			if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Kekvarazsko)
				kek++;
			if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Pirosvarazsko)
				piros++;
			if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Zoldvarazsko)
				zold++;
			if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Lilavarazsko)
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
		
		boolean success = false;
		if(args[1].matches("barna") && game.jatekter.felhasznalo.varazsero>50){
			game.jatekter.felhasznalo.varazskovek.add(new Barnavarazsko());
			success = true;
		}
		if(args[1].matches("kek") && game.jatekter.felhasznalo.varazsero>50){
			game.jatekter.felhasznalo.varazskovek.add(new Kekvarazsko());
		success = true;
		}
		if(args[1].matches("lila") && game.jatekter.felhasznalo.varazsero>50){
			game.jatekter.felhasznalo.varazskovek.add(new Lilavarazsko());
		success = true;
        }
		if(args[1].matches("narancs") && game.jatekter.felhasznalo.varazsero>50){
			game.jatekter.felhasznalo.varazskovek.add(new Narancsvarazsko());
		success = true;
		}
		if(args[1].matches("piros") && game.jatekter.felhasznalo.varazsero>50){
			game.jatekter.felhasznalo.varazskovek.add(new Pirosvarazsko());
		success = true;
	    }
		if(args[1].matches("sarga") && game.jatekter.felhasznalo.varazsero>50){
			game.jatekter.felhasznalo.varazskovek.add(new Sargavarazsko());
		success = true;
	    }
		if(args[1].matches("zold") && game.jatekter.felhasznalo.varazsero>50){
			game.jatekter.felhasznalo.varazskovek.add(new Zoldvarazsko());
		success = true;
		}
		
		if(!success) System.out.println("Bad parameter");
		
	}
	
	public static void addtower(String args[]){
		int sor = Integer.parseInt(args[2]);
		int oszlop = Integer.parseInt(args[3]);
		boolean joid = true;
		
		for(int i = 0;i<game.toronylista.size();i++){
			if(game.toronylista.get(i).id.matches(args[1]))
				joid = false;
		}
		
		if(joid){
			Torony uj = new Torony(args[1]);
			game.toronylista.add(uj);
			Cella valasztott = game.jatekter.cellak.get(sor).get(oszlop);
			if(valasztott.mezovagyok())
			game.jatekter.felhasznalo.ujTorony((Mezo)valasztott, uj);
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
