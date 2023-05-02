/**
 * 
 */
package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

/**
 * @author marcodalbis
 *
 */
public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandi factory;
	private Comando comandoDiTest;
	private IO io;
	
	@Before
	public void setUp() {
		io = new IOConsole();
		factory = new FabbricaDiComandiFisarmonica(io);
	}
	
	@Test
	public void testCostruisciComandoAiuto() {
		comandoDiTest = factory.costruisciComando("aiuto");
		assertEquals("aiuto", comandoDiTest.getNome());
	}
	
	@Test
	public void testCostruisciComandoFine() {
		comandoDiTest = factory.costruisciComando("fine");
		assertEquals("fine", comandoDiTest.getNome());
	}
	
	@Test
	public void testCostruisciComandoGuarda() {
		comandoDiTest = factory.costruisciComando("guarda");
		assertEquals("guarda", comandoDiTest.getNome());
	}
	
	@Test
	public void testCostruisciComandoPosa() {
		comandoDiTest = factory.costruisciComando("posa");
		assertEquals("posa", comandoDiTest.getNome());
	}
	
	@Test
	public void testCostruisciComandoPrendi() {
		comandoDiTest = factory.costruisciComando("prendi");
		assertEquals("prendi", comandoDiTest.getNome());
	}
	
	@Test
	public void testCostruisciComandoVaiSenzaParametro() {
		comandoDiTest = factory.costruisciComando("vai");
		assertEquals("vai", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	
	@Test
	public void testCostruisciComandoVaiConParametro() {
		comandoDiTest = factory.costruisciComando("vai nord");
		assertEquals("vai", comandoDiTest.getNome());
		assertEquals("nord",comandoDiTest.getParametro());
	}
	

	

}
