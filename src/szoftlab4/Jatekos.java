package szoftlab4;

import java.util.ArrayList;

public class Jatekos {
	private int varazsero;
	private ArrayList<Varazsko> varazskovek;

	public Jatekos() {
		varazskovek = new ArrayList<Varazsko>();
		varazsero = 0;
	}

	public void vasarol(Varazsko v) {
		if (v.getAr() <= varazsero) {
			varazsero -= v.getAr();
			varazskovek.add(v);
		}
	}

	public void varazserotKap(int i) {

		varazsero += i;

	}

	public void varazserotVeszit(int i) {

		varazsero -= i;

	}

	public void fejleszt(Akadaly akadaly, Lilavarazsko varazsko) {
		akadaly.addko(varazsko);
	}

	public void ujAkadaly(Ut valasztottUt) {
		valasztottUt.ratesz(new Akadaly());
		varazserotVeszit(50);
	}

	public void ujTorony(Mezo valasztottMezo) {
		valasztottMezo.ratesz(new Torony());
		varazserotVeszit(50);
	}

	public void kovetVesz(String koTipus) {

	}
}