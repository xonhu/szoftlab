package szoftlab4;

import java.util.ArrayList;

public class Jatekos {
	
	//Tárolja a játékos varázserejét
	public int varazsero = 0;
	
	//A játékos birtokában léõv varázsköveket tartalmazza
	public ArrayList<Varazsko> varazskovek;

	//A Jatekos osztály konstruktora
	public Jatekos() {
		varazskovek = new ArrayList<Varazsko>();
		varazsero = 0;
	}

	//Vásáról egy követ, hogyha a játékosnak van rá elég varázsereje
	public void vasarol(Varazsko v) {
		if (v.getAr() <= varazsero) {
			varazserotVeszit(v.getAr());
			varazskovek.add(v);
		}
	}

	//Ez a függvény hívódik meg, ha egy ellenség meghal.
	//A játékos varázserejét növeli
	public void varazserotKap(int i) {

		varazsero += i;

	}

	//A játékos varázserejét csökkenti
	public void varazserotVeszit(int i) {

		varazsero -= i;

	}

	//Egy kiválasztott akadályt fejleszthetünk vele, ha van a birtokunkban Lila varázskõ
	public void fejleszt(Akadaly akadaly, Lilavarazsko varazsko) {
		akadaly.addko(varazsko);
	}
	
	public void fejleszt(Torony torony, Toronykovek toronyko) {
		torony.addKo(toronyko);
	}

	//Egy új akadályt hozhatunk létre, ha van rá elég varázserõnk
	public void ujAkadaly(Ut valasztottUt) {
		valasztottUt.ratesz(new Akadaly());
		varazserotVeszit(50);
	}

	//Egy új Tornyot hozhatunk létre, ha van rá elég varázserõnk
	public void ujTorony(Mezo valasztottMezo, Torony ezt) {
		
		if(varazsero>50){
			valasztottMezo.ratesz(ezt);
			varazserotVeszit(50);
			System.out.println("Torony letrehozva");
		}else{
			System.out.println("Nincs eleg varazsero");
		}
	}

	public void kovetVesz(String koTipus) {

	}
}