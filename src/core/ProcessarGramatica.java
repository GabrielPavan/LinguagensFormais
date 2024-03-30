package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessarGramatica {
	
	private Gramatica gramatica;
	private List<Character> resultado = new ArrayList<Character>();

	public List<Character> getResultado() {
		return resultado;
	}
	
	public ProcessarGramatica(Gramatica pGramatica) {	
		gramatica = pGramatica;
		geraSentença('S', gramatica.gramatica.get("S"));
	}
	
	private void geraSentença(char key, List<String> values) {
		Random random = new Random();
		String value = values.get(random.nextInt(values.size()));
		
		if (value.equals("?")) {
			return;
		}
		
		for (int i = 0; i < value.length(); i++) {
			char caractere = value.charAt(i);
			
			if(Character.isUpperCase(caractere)) {
				geraSentença(caractere, gramatica.gramatica.get("" + caractere));
				continue;
			}
			resultado.add(caractere);
		}
	}
}
