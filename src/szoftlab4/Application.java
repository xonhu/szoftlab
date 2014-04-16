package szoftlab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Szkeleton fõprogram
public class Application {
	
	public static void main(String[] args){
		
		System.out.println("A két torony - Szkeleton /datcode/"); 
		System.out.println("");
		
		Log.br = new BufferedReader(new InputStreamReader(System.in)); // Mindenkori konzolos bemenetként szolgál
		int eset = 0;
		
		while(eset != 11)
		{
			Log.clearAll(); 			// A lehetséges tesztesetek felsorolása
		
			System.out.println("Válassz tesztesetet!");
			System.out.println("");
		
			System.out.println("[1]  - Új játék indítása");
			System.out.println("[2]  - Ellenség lépése");
			System.out.println("[3]  - Ellenség születése");
			System.out.println("[4]  - Torony elhelyezése");
			System.out.println("[5]  - Akadály elhelyezése");
			System.out.println("[6]  - Torony tüzelése");
			System.out.println("[7]  - Torony fejlesztése");
			System.out.println("[8]  - Akadály fejlesztése");
			System.out.println("[9]  - Kõ vásárlása");
			System.out.println("[10] - Ellenség meghal, Játékos varázserõt kap");
			System.out.println("[11] - Kilépés");

			
			
			try {							//A felhasználó választásának beolvasása
				eset = Integer.parseInt(Log.br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			

			
		if(eset > 0 && eset < 11){
		System.out.println();
		System.out.println("--Teszteset indul --");
		}
		Tesztesetek test = new Tesztesetek();
		test.inicializalas();
		
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
		
		if(eset > 0 && eset < 11){
		System.out.println();
		System.out.println("--Teszteset vége --");
		System.out.println();
		}	
	}

		try {
			Log.br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
