package szoftlab4;

import java.io.IOException;
import java.util.ArrayList;

public class EllensegKeszito implements Aktiv {
		private ArrayList<Ut> belepoUtak;
		
		public EllensegKeszito(){
			belepoUtak = null;
		}
		
		public void tick(){
			Log.log(LogType.CALL, this, "tick()");
			Ut valasztott;
			String ellenseg;
			
			valasztott = utatValaszt();
			ellenseg = getEllensegTipus();
			
			if(ellenseg.matches("Hobbit"))
				valasztott.ratesz(new Hobbit(valasztott));
			else if(ellenseg.matches("Tünde"))
				valasztott.ratesz(new Tunde(valasztott));
			else if(ellenseg.matches("Ember"))
				valasztott.ratesz(new Ember(valasztott));
			else
				valasztott.ratesz(new Torpe(valasztott));
			
			Log.log(LogType.RETURN, null, "void");
		}
		
		public String getEllensegTipus(){
			String mitad = null;
			Log.log(LogType.CALL, this, "getEllensegTipus()");

			
			Log.log(LogType.KERDES, null, "Milyen ellenséget csináljunk? [Ember/Hobbit/Tünde/Törp]");
			
			try {
				mitad = Log.br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.log(LogType.RETURN, null, "String");
			return mitad;
		}
		
		public Ut utatValaszt(){
			Log.log(LogType.CALL, this, "utatValaszt()");
			Log.log(LogType.RETURN, null, "Ut");
			return Tesztesetek.testUt ;
		}
		
}
