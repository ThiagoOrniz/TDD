
public class Produto {
	private String name;
	private int valor;
	
	public Produto(String name, int valor){
		this.name = name;
		this.valor = valor;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setValor(int valor){
		this.valor = valor;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValor(){
		return valor;
	}
}
