package szoftlab4;

import java.util.ArrayList;

public class Jatekos {
	
	//T�rolja a j�t�kos var�zserej�t
	public int varazsero;
	
	//A j�t�kos birtok�ban l��v var�zsk�veket tartalmazza
	public ArrayList<Varazsko> varazskovek;

	//A Jatekos oszt�ly konstruktora
	public Jatekos() {
		varazskovek = new ArrayList<Varazsko>();
		varazsero = 0;
	}

	//V�s�r�l egy k�vet, hogyha a j�t�kosnak van r� el�g var�zsereje
	public void vasarol(Varazsko v) {
		if (v.getAr() <= varazsero) {
			varazserotVeszit(v.getAr());
			varazskovek.add(v);
		}
	}

	//Ez a f�ggv�ny h�v�dik meg, ha egy ellens�g meghal.
	//A j�t�kos var�zserej�t n�veli
	public void varazserotKap(int i) {

		varazsero += i;

	}

	//A j�t�kos var�zserej�t cs�kkenti
	public void varazserotVeszit(int i) {

		varazsero -= i;

	}

	//Egy kiv�lasztott akad�lyt fejleszthet�nk vele, ha van a birtokunkban Lila var�zsk�
	public void fejleszt(Akadaly akadaly, Lilavarazsko varazsko) {
		akadaly.addko(varazsko);
	}

	//Egy �j akad�lyt hozhatunk l�tre, ha van r� el�g var�zser�nk
	public void ujAkadaly(Ut valasztottUt) {
		valasztottUt.ratesz(new Akadaly());
		varazserotVeszit(50);
	}

	//Egy �j Tornyot hozhatunk l�tre, ha van r� el�g var�zser�nk
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