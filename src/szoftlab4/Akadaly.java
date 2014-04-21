package szoftlab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Akadaly implements Utravalo {
	
	public String id;
	
	//Attrib�tum annak a t�rol�s�ra, hogy az Akad�ly melyik Ut-on �ll
	private Ut sajatUt;
	
	//Tartalmazza, hogy mekkora m�rt�kben lass�tja az ellenfelet.
	private int lassitas;
	
	//Amennyiben a torony fel van szerelve k�vel, ennek az �rt�ke nem null.
	private Lilavarazsko ko;
	
	private int counter;
	
	//Az Akad�ly oszt�ly publikus konstruktora
	public Akadaly(){
		sajatUt = null;
		counter = 0;
		lassitas = 10;
		ko = null;
	}
	
	//F�ggv�ny ami visszaadja, hogy az adott k�rben l�phet-e az Ellens�g
	public boolean lephete(){
	
	//Att�l f�gg�en engedi l�pni a h�v�t, hogy fel van-e szerelve k�vel, �s ha igen, el�g r�g�ta nem
	//l�phetett-e.
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
	
	//Inicializ�lja a sajatUt attrib�tumot
	public void init(Ut sajat){
		sajatUt = sajat;

	}
	
	//Lilavar�zsk�vet hozz�adja az akad�lyhoz. A fejleszt�s sor�n h�v�dik meg
	public void addko(Lilavarazsko varazsko){
		ko = varazsko;
	}
	

}
