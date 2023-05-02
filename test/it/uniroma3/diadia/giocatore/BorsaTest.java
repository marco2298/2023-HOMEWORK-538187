package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Marco
 *
 */

public class BorsaTest {

	private static final String ATTREZZO = "Attrezzo semplice";
	private Borsa borsa;
	private static final int PESO_MAX_BORSA = 20;



	@Before
	public void setUp () {
		this.borsa = new Borsa(PESO_MAX_BORSA);
	}

	@Test
	public void testAddAttrezzoSingolo () {
		Attrezzo attrezzo = creaAttrezzoEAggiungiInBorsa (this.borsa,ATTREZZO,1);
		assertEquals(attrezzo, this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testAddAttrezzoTroppoPesante () {
		Attrezzo attrezzoPesante = new Attrezzo("Attrezzo Pesante", PESO_MAX_BORSA+1);
		assertFalse(this.borsa.addAttrezzo(attrezzoPesante));
	}
	
	@Test
	public void testGetAttrezzoBorsaVuota () {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetPesoMax () {
		assertEquals(PESO_MAX_BORSA, this.borsa.getPesoMax());
	}
	
	@Test
	public void testRemoveAttrezzo() {
		creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 1);
		this.borsa.removeAttrezzo(ATTREZZO);
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoEsistente() {
		creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 1);
		assertTrue(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetPesoIniziale () {
		assertEquals(0, this.borsa.getPeso());
	}



	private Attrezzo creaAttrezzoEAggiungiInBorsa (Borsa borsa, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo (nomeAttrezzo,peso);
		borsa.addAttrezzo(attrezzo);
		return attrezzo;

	}

}