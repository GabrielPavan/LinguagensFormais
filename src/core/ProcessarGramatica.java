package core;

import java.util.ArrayList;
import java.util.List;

public class ProcessarGramatica {
	
	private List<String> valoresSelecionados = new ArrayList<String>();
	private List<String> etapas = new ArrayList<String>();
	private String resultado = "";
	
	public void resetVariaveis() {
		resultado = "";
		valoresSelecionados = new ArrayList<String>();
		etapas = new ArrayList<String>();
	}
	
	public String getResultadoFinal() {
		return resultado;
	}
	public String getValores(){
		return valoresSelecionados.toString();
	}
	public String getResultadoCompleto() {
		return getValores().concat("\n").concat(getResultadoFinal());
	}
	public String getOrdemResultado() {
		String result = "";
		for (int i = 0; i < etapas.size(); i++) {
			result = result.concat(etapas.get(i)).concat("\n");
		}
		return result;
	}
	
	public void geraSentenca(Character key, Gramatica pGramatica) throws Exception {
		String value = pGramatica.getRandomValue(key);
		valoresSelecionados.add(value);
		
		if (value.equals("?")) {
			resultado = resultado.replace(key.toString(), "");
			etapas.add(resultado);
			return;
		}
		
		if (resultado.isEmpty()) {
			resultado = value;
		} else {
			resultado = resultado.replace(key.toString(), value);
		}
		etapas.add(resultado);
		
		for (int i = 0; i < value.length(); i++) {
			char caractere = value.charAt(i);
			if(Character.isUpperCase(caractere)) {
				geraSentenca(caractere, pGramatica);
			}
		}
	}
}
