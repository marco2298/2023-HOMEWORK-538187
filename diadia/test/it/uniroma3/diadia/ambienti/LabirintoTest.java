/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Marco
 *
 */
public class LabirintoTest {

	private Labirinto labirinto;

	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		labirinto.creaStanze();
	}

	@Test
	public void testGetStanzaIniziale() {
		assertNotNull(this.labirinto.getStanzaIniziale());
		assertEquals("Atrio", this.labirinto.getStanzaIniziale().getNome());
		
	}

	@Test
	public void testGetStanzaVincente() {
		assertNotNull(this.labirinto.getStanzaVincente());
		assertEquals("Biblioteca", this.labirinto.getStanzaVincente().getNome());
	}

}
