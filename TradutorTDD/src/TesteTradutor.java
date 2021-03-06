import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteTradutor {
	Tradutor t;
	@Before
	public void inicializarTradutor(){
		t = new Tradutor();
	}
	@Test
	public void semPalavras() {
		assertTrue(t.estaVazio());
	}
	
	@Test
	public void umaTraducao(){
		t.adicionarTraducao("bom","good");
		
		assertFalse(t.estaVazio());
		assertEquals("good",t.traduzir("bom"));		
	}
	
	@Test
	public void duasTraducoes(){
		t.adicionarTraducao("bom","good");
		t.adicionarTraducao("mau","bad");
		
		assertEquals("good",t.traduzir("bom"));			
		assertEquals("bad",t.traduzir("mau"));		
	}
	
	@Test
	public void duasTraducoesMesmaPalavra(){
		t.adicionarTraducao("bom","good");
		t.adicionarTraducao("bom","nice");
		
		assertEquals("good, nice",t.traduzir("bom"));			
	}

	@Test
	public void traduzirFrase(){
		t.adicionarTraducao("guerra","war");
		t.adicionarTraducao("e","is");		
		t.adicionarTraducao("ruim","bad");		

		assertEquals("war is bad",t.traduzirFrase("guerra e ruim"));		
	}
	

	@Test
	public void traduzirFraseComDuasPalavras(){
		t.adicionarTraducao("paz","peace");
		t.adicionarTraducao("e","is");		
		t.adicionarTraducao("bom","good");
		t.adicionarTraducao("bom","nice");
		
		assertEquals("peace is good",t.traduzirFrase("paz e bom"));		
	}
	
}
