package szoftlab4;


public class Tesztesetek {
	
	public static Jatekos testFelhasznalo;
	public static Jatekter testJatekter;
	public static Controller testController;
	public static Ellenseg testEllenseg;
	public static Torony testTorony;
	public static Ut testUt;
	public static Ut testKovetkezoUt;
	public static EllensegKeszito testEllensegKeszito;
	public static Mezo testMezo;
	public static Varazsko testKo;
	public static Akadaly testAkadaly;
	public static Varazsko testVarazsko;
	public static Lilavarazsko testLilaVarazsko;
	public static Lovedek testLovedek;
	
	//Inicializálja a teszthez szükséges változókat, objektumokat. Ezek statikusak, hogy
	//bármely függvénybõl elérhetõek legyenek.
	public void inicializalas(){
		
		testFelhasznalo = new Jatekos();
		testJatekter = new Jatekter(testFelhasznalo);
		testController = new Controller(testJatekter);
		testUt = new Ut();
		testEllenseg = new Ellenseg(testUt);
		testTorony = new Torony();
		testEllensegKeszito = new EllensegKeszito();
		testKo = new Varazsko();
		testAkadaly = new Akadaly();
		testVarazsko = new Varazsko();
		testLilaVarazsko = new Lilavarazsko();
		testLovedek = new Lovedek();
		testKovetkezoUt = new Ut();
		
		testMezo = new Mezo();
		testTorony = new Torony();
		
		
		Log.add(testFelhasznalo,"testFelhasznalo");
		Log.add(testJatekter,"testJatekter");
		Log.add(testController,"testController");
		Log.add(testUt,"testUt");
		Log.add(testEllenseg,"testEllenseg");
		Log.add(testTorony,"testTorony");
		Log.add(testMezo,"testMezo");
		Log.add(testEllensegKeszito,"testEllensegKeszito");
		Log.add(testKo,"testKo");
		Log.add(testAkadaly,"testAkadaly");
		Log.add(testVarazsko, "testVarazsko");
		Log.add(testLilaVarazsko, "testLilaVarazsko");
		Log.add(testLovedek, "testLovedek");
		Log.add(testKovetkezoUt,"testKovetkezoUt");
		
		
	}
	
//A következõ függvények az egyes teszteseteket futtatják le.
	
	//KÉSZ
	public void ujjatek(){
		testController.indit();
		
	}
	
	//KÉSZ
	public void ellenseglep(){
		testEllenseg.tick();
		
	}
	
	//KÉSZ
	public void ellensegszuletik(){
	testEllensegKeszito.tick();
	}
	
	//KÉSZ
	public void toronyelhelyez(){
		  testFelhasznalo.ujTorony(testMezo);
	}
	
	//KÉSZ
	public void akadalyelhelyez(){
		testFelhasznalo.ujAkadaly(testUt);
		
	}
	
	//KÉSZ
	public void toronytuzel(){
		testTorony.tick();
		
		System.out.println("Git proba (Aron)");
	}
	
	//KÉSZ
	 public void toronyfejleszt(){
		  Zoldvarazsko zoldko = new Zoldvarazsko();
		  Log.add(zoldko, "zöldVarázskõ");
		  testTorony.addKo(zoldko);
		 }
	
	//KÉSZ
	public void akadalyfejleszt(){
		testFelhasznalo.fejleszt(testAkadaly, testLilaVarazsko);
	}

	public void kovasarol(){
		  testFelhasznalo.kovetVesz("pirosko");
	}
	
	//KÉSZ
	public void ellensegmeghal(){
		testEllenseg.sebez(testLovedek);
		
	}
}
