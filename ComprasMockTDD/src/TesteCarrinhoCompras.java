import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCarrinhoCompras {

	@Test
	public void totalCarrinho(){
		CarrinhoCompras c = new CarrinhoCompras();
		c.adicionaProduto(new Produto("camisa", 60));
		c.adicionaProduto(new Produto("tenis", 130));
		c.adicionaProduto(new Produto("bermuda", 70));
		
		assertEquals(260, c.total());
	}
	
	@Test
	public void escutaAdicaoDeProduto(){
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		c.adicionarObservador(mock);
		c.adicionaProduto(new Produto("tenis", 130));
		mock.verificaRecebimentoProduto("tenis",130);
	}
	
	@Test
	public void adicionarDoisObservadores(){
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		c.adicionarObservador(mock);
		c.adicionarObservador(mock2);
		c.adicionaProduto(new Produto("tenis", 130));
		mock.verificaRecebimentoProduto("tenis",130);
		mock2.verificaRecebimentoProduto("tenis",130);
	}
	
	@Test
	public void continuaNotificandoComErroEmObservador(){
		
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		ObservadorCarrinho mock2 = new MockObservadorComProblema();
		MockObservadorCarrinho mock3 = new MockObservadorCarrinho();

		c.adicionarObservador(mock);
		c.adicionarObservador(mock2);
		c.adicionarObservador(mock3);

		c.adicionaProduto(new Produto("tenis", 130));
		mock.verificaRecebimentoProduto("tenis",130);
		mock3.verificaRecebimentoProduto("tenis",130);	
	}
}
