package szoftlab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Jatekos {
	private int varazsero;
	private ArrayList<Varazsko> varazskovek;
	
	public Jatekos(){
		varazskovek = null;
		varazsero = 0;
	}
	
	public void vasarol(Varazsko v){
		Log.log(LogType.CALL, this, "vasarol(Varazsko v)");
		Log.log(LogType.KERDES, null, "Megtudja-e vásásrolni a felhasználó a követ?[igen/nem]");
		
		BufferedReader beolvasott = new BufferedReader(new InputStreamReader(System.in));

		Log.log(LogType.RETURN, this, "void");		
	}
	
	public void varazserotKap(int i){
		Log.log(LogType.CALL, this, "varazserotKap()");
		
		Log.log(LogType.RETURN, this, "void()");
	}
	
	public void varazserotVeszit(int i){
		Log.log(LogType.CALL, this, "varazserotKap()");

		Log.log(LogType.RETURN, this, "void");
	}
	
	public void fejleszt(Akadaly akadaly, Lilavarazsko varazsko){
		Log.log(LogType.CALL, this, "fejleszt()");
		
		akadaly.addko(varazsko);

		Log.log(LogType.RETURN, this, "void");
	}
	
	public void ujAkadaly(Ut valasztottUt){
		Log.log(LogType.CALL, this, "ujAkadaly()");
		
		Akadaly ujakadaly = new Akadaly();
		Log.add(ujakadaly,"ujakadaly");
		Log.log(LogType.NEW, ujakadaly, null);
		boolean uj = false;
		
		String utatvalasztott = null;
		
		while(!uj){
		Log.log(LogType.KERDES, null, "Utat választott? [true/false]");
		try {
			utatvalasztott = Log.br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(utatvalasztott.matches("true"))
			{
			valasztottUt.ratesz(ujakadaly);
			uj = true;
			}
		else uj = false;
	}
		Log.log(LogType.RETURN, this, "void");

}
	
	public void ujTorony(Mezo valasztottMezo){
		Log.log(LogType.CALL, this, "ujTorony()");
		Torony ujtorony = new Torony();
		Log.add(ujtorony,"ujtorony");
		Log.log(LogType.NEW, ujtorony, null);
		boolean uj = false;
			
		String mezotvalasztott = null;
			
		while(!uj){
			Log.log(LogType.KERDES, null, "Mezõt választott? [true/false]");
			try {
				mezotvalasztott = Log.br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(mezotvalasztott.matches("true")){
				valasztottMezo.ratesz(ujtorony);
				uj = true;
			}
			else uj = false;
		}
		Log.log(LogType.RETURN, null, "ujTorony()");
	}
	
	public void kovetVesz(String koTipus){
		  Log.log(LogType.CALL, this, "kovetVesz()");
		  int ar = Tesztesetek.testJatekter.getAr(koTipus);
		  String megt = null;
		  
		  Log.log(LogType.KERDES, null, "Játékos meg tudja venni a varázskövet? [true/false]");
		  try {
		   megt = Log.br.readLine();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  
		  if(megt.equals("true")){
		   
		   varazserotVeszit(ar);
		   
		   Pirosvarazsko pirosko = new Pirosvarazsko();
		   Log.add(pirosko, "pirosko");
		   
		   Tesztesetek.testTorony.addKo(pirosko);
		  
		  }
		  Log.log(LogType.RETURN, null, "kovetVesz()");
		 }
}