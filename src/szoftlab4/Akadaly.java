package szoftlab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Akadaly implements Utravalo {
	
	//Attribútum annak a tárolására, hogy az Akadály melyik Ut-on áll
	private Ut sajatUt;
	
	//Tartalmazza, hogy mekkora mértékben lassítja az ellenfelet.
	private int lassitas;
	
	//Amennyiben a torony fel van szerelve kõvel, ennek az értéke nem null.
	private Lilavarazsko ko;
	
	private int counter;
	
	//Az Akadály osztály publikus konstruktora
	public Akadaly(){
		sajatUt = null;
		counter = 0;
		lassitas = 10;
		ko = null;
	}
	
	//Függvény ami visszaadja, hogy az adott körben léphet-e az Ellenség
	public boolean lephete(){
	
	//Attól függõen engedi lépni a hívót, hogy fel van-e szerelve kõvel, és ha igen, elég régóta nem
	//léphetett-e.
		if(ko != null){
			if((lassitas*2)>= counter){
				counter++;
				return false;
				}else{
					counter = 0;
					return true;
				}
			}
		else{
			if(lassitas >= counter){
				counter++;
				return false;
			}else{
				counter = 0;
				return true;
			}
		}
		
	}
	
	//Inicializálja a sajatUt attribútumot
	public void init(Ut sajat){
		sajatUt = sajat;

	}
	
	//Lilavarázskövet hozzáadja az akadályhoz. A fejlesztés során hívódik meg
	public void addko(Lilavarazsko varazsko){
		ko = varazsko;
	}
	

}
