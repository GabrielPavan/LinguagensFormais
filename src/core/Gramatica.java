package core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Gramatica {
	
	private Map<Character, List<String>> gramatica;

	public List<String> getValues(Character character) throws Exception {
		List<String> values = gramatica.get(character);
		if(values != null) {
			return values;
		} else {
			throw new Exception("Não há valores para essa chave: " + character);
		}
	}
	public String getRandomValue(Character character) throws Exception {
		Random random = new Random();
		List<String> values = getValues(character);
		return values.get(random.nextInt(values.size()));
	}
	
	public void createGramatica(String pGramatica) throws Exception {
		gramatica = new LinkedHashMap<Character, List<String>>();
		
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
			
			Character key = parte02[0].charAt(0);
		
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