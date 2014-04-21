package szoftlab4;

public class Kod {
		//Tartalmazza hogy a köd, mennyi ideig él
		private int idotartam;
		private Torony torony;
		
		public Kod(Torony t){
			torony = t;
			idotartam = 50;
		}
		
		public void letrejottem(){
			torony.kodosit();
		}
		
		public void tick(){
			if(idotartam ==0)
				torony.kitisztul();
			idotartam--;
		}
}
