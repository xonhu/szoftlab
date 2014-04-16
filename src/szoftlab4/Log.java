package szoftlab4;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

//Log osztály a konzolra való kiíráshoz. Loggolja az éppen aktuális objektumokat, és
// ha esemény történik, kiírja azt a konzolra.
public class Log {

	private static int behuz = 0;
	public static Map<Object, String> map = new HashMap<Object, String>();
	public static BufferedReader br;

	public static void add(Object o, String nev) {
		map.put(o, nev);
	}

	public static void log(LogType tipus, Object o, String param) {

		String tabok = "";
		String logTipus;
		String objektumNev = "";
		String osztalyNev = "";
		if (o != null) {
			objektumNev = map.get(o);
			osztalyNev = o.getClass().toString();
			osztalyNev = osztalyNev.substring(osztalyNev.lastIndexOf('.') + 1);
		}

		if (tipus == LogType.KERDES)
			logTipus = "[?]";
		else
			logTipus = tipus.toString();

		if (tipus == LogType.RETURN)
			behuz--;

		for (int i = 0; i < behuz; i++)
			tabok += "    ";

		if (tipus == LogType.CALL)
			System.out.println(tabok + logTipus + " " + objektumNev + "."
					+ param + " " + " - " + osztalyNev);
		else if (tipus == LogType.NEW)
			System.out.println(tabok + logTipus + " " + osztalyNev + " - "
					+ objektumNev);
		else
			System.out.println(tabok + logTipus + " " + param);

		if (tipus == LogType.CALL)
			behuz++;

	}
	
	public static void clearAll(){
		map.clear();
		behuz = 0;
	}

}