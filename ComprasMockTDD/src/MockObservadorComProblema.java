public class MockObservadorComProblema implements ObservadorCarrinho {
	
	public void produtoAdicionado(String nome, int valor){
			throw new RuntimeException("crash simulado pelo mock");
	}
}
