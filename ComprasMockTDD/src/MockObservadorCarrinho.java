import static org.junit.Assert.*;

public class MockObservadorCarrinho implements ObservadorCarrinho {
	
	private String nomeRecebido;
	private int valorRecebido;
	private boolean isCrash = false;
	
	public void produtoAdicionado(String nome, int valor){
		if(isCrash)
			throw new RuntimeException("crash simulado pelo mock");
		
		nomeRecebido = nome;
		valorRecebido = valor;
	}

	public void verificaRecebimentoProduto(String nomeEsperado, int valorEsperado) {
		assertEquals(nomeEsperado, nomeRecebido);
		assertEquals(valorEsperado, valorRecebido);
	}

	public void crashMock() {
		isCrash = true;
	}

}
