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
	
	//Inicializ�lja a teszthez sz�ks�ges v�ltoz�kat, objektumokat. Ezek statikusak, hogy
	//b�rmely f�ggv�nyb�l el�rhet�ek legyenek.
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
	
//A k�vetkez� f�ggv�nyek az egyes teszteseteket futtatj�k le.
	
	//K�SZ
	public void ujjatek(){
		testController.indit();
		
	}
	
	//K�SZ
	public void ellenseglep(){
		testEllenseg.tick();
		
	}
	
	//K�SZ
	public void ellensegszuletik(){
	testEllensegKeszito.tick();
	}
	
	//K�SZ
	public void toronyelhelyez(){
		  testFelhasznalo.ujTorony(testMezo);
	}
	
	//K�SZ
	public void akadalyelhelyez(){
		testFelhasznalo.ujAkadaly(testUt);
		
	}
	
	//K�SZ
	public void toronytuzel(){
		testTorony.tick();
		
		System.out.println("Git proba (Aron)");
	}
	
	//K�SZ
	 public void toronyfejleszt(){
		  Zoldvarazsko zoldko = new Zoldvarazsko();
		  Log.add(zoldko, "z�ldVar�zsk�");
		  testTorony.addKo(zoldko);
		 }
	
	//K�SZ
	public void akadalyfejleszt(){
		testFelhasznalo.fejleszt(testAkadaly, testLilaVarazsko);
	}

	public void kovasarol(){
		  testFelhasznalo.kovetVesz("pirosko");
	}
	
	//K�SZ
	public void ellensegmeghal(){
		testEllenseg.sebez(testLovedek);
		
	}
}
