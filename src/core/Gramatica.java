package core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Gramatica {
	
	public Map<String, List<String>> gramatica = new LinkedHashMap<String, List<String>>();

	public Gramatica(String pGramatica) throws Exception {
		setGramatica(pGramatica);
	}
	
	public void setGramatica(String pGramatica) throws Exception {
		String[] parte01 = null;
		if(pGramatica.contains(";")) {
			parte01 = pGramatica.split(";");
		} else {
			parte01 = new String[1];
			parte01[0] = pGramatica;
		}
		
		String[] parte02 = null;
		for (String strings01 : parte01) {
			if(strings01.contains("=")) {
				parte02 = strings01.split("=");
			} else {
				throw new Exception("Não foi possivel encontrar o spliter!");
			}
			String key = parte02[0];
		
			String parte03[] = null;
			ArrayList<String> values = new ArrayList<String>();
			if(parte02[1].contains("|")) {
				parte03 = parte02[1].split("\\|");
				for (String strings02 : parte03) {
					values.add(strings02);
				}
			} else {
				values.add(parte02[1]);
			}
			gramatica.put(key, values);
		}
	}
}