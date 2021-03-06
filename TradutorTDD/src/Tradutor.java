import java.util.HashMap;
import java.util.Map;

public class Tradutor {

	private Map<String,String> traducoes = new HashMap<>();
	
	public boolean estaVazio() {
		// TODO Auto-generated method stub
		return traducoes.isEmpty();
	}

	public void adicionarTraducao(String palavra, String traducao) {
		if(traducoes.containsKey(palavra)){
			traducao = traduzir(palavra)+", "+traducao;
		}
		this.traducoes.put(palavra, traducao);
	}

	public String traduzir(String palavra) {
		return traducoes.get(palavra);
	}

	public String traduzirFrase(String frase) {
		String[] palavras = frase.split(" ");
		StringBuffer fraseTraduzida = new StringBuffer();
		for(String palavra : palavras){
			String traducao = primeiraTraducao(palavra);
			
			fraseTraduzida.append(traducao);
			fraseTraduzida.append(" ");
		}
		return fraseTraduzida.toString().trim();
	}
	
	private String primeiraTraducao(String palavra){
		 String traducao = traduzir(palavra);
		 
		if(traducao.contains(","))
			traducao = traducao.substring(0,traducao.indexOf(","));
		
		return traducao;
	}

}
