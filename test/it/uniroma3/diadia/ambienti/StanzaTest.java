package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza n1;
	private Stanza n2;
	private Stanza n3;
	private Stanza n1nord;
	private Stanza n1sud;
	private Stanza n2est;
	private Stanza n3ovest;

	private Attrezzo bastone;
	private Attrezzo ascia;
	private Attrezzo fucile;

	@Before
	public void setUP(){
		this.n1 = new Stanza("N1");
		this.n2 = new Stanza("N2");
		this.n3 = new Stanza("N3");

		this.n1nord = new Stanza("N1nord");
		this.n1sud = new Stanza("N1sud");
		this.n2est = new Stanza("N2est");
		this.n3ovest = new Stanza("N3ovest");

		this.bastone = new Attrezzo("Bastone", 1);		
		this.ascia = new Attrezzo("Ascia", 5);
		this.fucile = new Attrezzo("Fucile", 10);		

		this.n1.addAttrezzo(bastone);
		this.n2.addAttrezzo(ascia);
		this.n3.addAttrezzo(fucile);

		this.n1.impostaStanzaAdiacente("nord", n1nord);
		this.n1.impostaStanzaAdiacente("sud", n1sud);
		this.n2.impostaStanzaAdiacente("est", n2est);
		this.n3.impostaStanzaAdiacente("ovest", n3ovest);
	}

	/*  
	 * test   getStanzaAdiacente()
	 * */

	@Test
	public void testStanzaNordN1() {
		assertEquals(n1nord, n1.getStanzaAdiacente("nord"));
	}

	@Test
	public void testStanzaSudN1() {
		assertEquals(n1sud, n1.getStanzaAdiacente("sud"));
	}

	@Test
	public void testStanzaEstN2() {
		assertEquals(n2est, n2.getStanzaAdiacente("est"));
	}

	@Test
	public void testStanzaOvestN3() {
		assertEquals(n3ovest, n3.getStanzaAdiacente("ovest"));
	}
	/*
	 * test getNome()
	 * 
	 */
	@Test
	public void testGetNomeN1() {
		assertEquals("N1", n1.getNome());
	}

	@Test
	public void testGetNomeN2Est() {
		assertEquals("N2est", n2est.getNome());
	}

	@Test
	public void testGetNomeN3Ovest() {
		assertEquals("N3ovest", n3ovest.getNome());
	}

	/*
	 * test hasAttrezzo()
	 * */
	@Test
	public void testN1PossiedeBastone() {
		assertTrue(this.n1.hasAttrezzo("Bastone"));
	}

	@Test
	public void testN2NonPossiedeFucile() {
		assertFalse(this.n2.hasAttrezzo("Fucile"));
	}

	@Test
	public void testN3PossiedeFucile() {
		assertTrue(this.n3.hasAttrezzo("Fucile"));
	}

	/*
	 * test addAttrezzo()
	 * */
	@Test
	public void testTrueBastone() {
		assertTrue(n1.addAttrezzo(bastone));
	}

	@Test
	public void testTrueAscia() {
		assertTrue(n1.addAttrezzo(ascia));
	}

	@Test
	public void testFalseTroppiOggetti() {
		assertFalse(
				this.n1.addAttrezzo(ascia) && this.n1.addAttrezzo(ascia) && 
				this.n1.addAttrezzo(ascia) && this.n1.addAttrezzo(ascia) && 
				this.n1.addAttrezzo(ascia) && this.n1.addAttrezzo(ascia) && 
				this.n1.addAttrezzo(ascia) && this.n1.addAttrezzo(ascia) && 
				this.n1.addAttrezzo(ascia) && this.n1.addAttrezzo(ascia));
	}
	
	@Test
	public void testNonContieneFucilePoiAggiungoEContiene() {
		assertFalse("N1 contiene fucile", this.n1.hasAttrezzo("Fucile"));
		this.n1.addAttrezzo(fucile);
		assertTrue("N1 non contiene fucile",this.n1.hasAttrezzo("Fucile"));
	}

	/*
	 * test getNome() su attrezzo in stanza
	 * */
	
	@Test
	public void testGetNomeBastone() {
		assertEquals("Bastone", this.n1.getAttrezzo("Bastone").getNome());
	}

	@Test
	public void testGetNomeAscia() {
		assertEquals("Ascia", this.n2.getAttrezzo("Ascia").getNome());
	}

	@Test
	public void testGetNomeFucile() {
		assertEquals("Fucile", this.n3.getAttrezzo("Fucile").getNome());
	}
	
	/*
	 * test removeAttrezzo() su attrezzo in stanza
	 * */
	@Test
	public void testRimuoviAttrezzoFucile() {
		this.n1.addAttrezzo(fucile);
		assertTrue("N1 non contiene fucile",this.n1.hasAttrezzo("Fucile"));
		this.n1.removeAttrezzo(fucile);
		assertFalse("N1 contiene fucile",this.n1.hasAttrezzo("Fucile"));
	}
}
