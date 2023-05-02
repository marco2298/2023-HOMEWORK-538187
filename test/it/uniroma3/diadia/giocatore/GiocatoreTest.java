/**
 * 
 */
package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Marco
 *
 */
public class GiocatoreTest {

	private Giocatore giocatore;
	
	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
	}

	@Test
	public void testSetCfu() {
		this.giocatore.setCfu(15);
		assertEquals(15, this.giocatore.getCfu());
	}
	
	@Test
	public void testCfuNonFinitiInizioPartita() {
		assertNotEquals(0,this.giocatore.getCfu());
	}
	
	@Test
	public void testCfuIniziali() {
		assertEquals(Giocatore.CFU_INIZIALI, this.giocatore.getCfu());
	}

}
