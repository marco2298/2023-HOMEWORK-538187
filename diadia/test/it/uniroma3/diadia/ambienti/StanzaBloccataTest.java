/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.fixture.Fixture;

/**
 * @author marcodalbis
 *
 */
public class StanzaBloccataTest {
	
	private static final String STANZA_ADIACENTE_LIBERA = "stanzaAdiacenteLibera";
	private static final String STANZA_ADIACENTE_BLOCCATA = "stanzaAdiacenteBloccata";
	private static final String DIREZIONE_BLOCCATA = "dirBloccata";
	private static final String DIREZIONE_LIBERA = "dirLibera";
	private static final String CHIAVE_TEST = "chiaveTest";
	private static final String STANZA_BLOCCATA = "stanzaBloccata";

	private StanzaBloccata stanzaBloccata;
	
	@Before
	public void setUp () {
		StanzaBloccata stanzaBloccata = new StanzaBloccata (STANZA_BLOCCATA, CHIAVE_TEST, DIREZIONE_BLOCCATA);
		this.stanzaBloccata = stanzaBloccata;
	} 
	
	private void setStanzeAdiacenti (Stanza stanzaBloccata) {
		Stanza stanzaAdiacenteLibera = new Stanza (STANZA_ADIACENTE_LIBERA);
		Stanza stanzaAdiacenteBloccata = new Stanza (STANZA_ADIACENTE_BLOCCATA);
		stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaAdiacenteBloccata);
		stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_LIBERA, stanzaAdiacenteLibera);
	}
	
	
	@Test
	public void testGetStanzaAdiacenteBloccata() {
		setStanzeAdiacenti(this.stanzaBloccata);
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA));

	}
	
	@Test
	public void testGetStanzaAdiacenteSbloccata() {
		setStanzeAdiacenti(this.stanzaBloccata);
		Fixture.creaAttrezzoEAggiungiAStanza(this.stanzaBloccata,CHIAVE_TEST,1);
		assertEquals(STANZA_ADIACENTE_BLOCCATA, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA).getNome());

	}
	
	@Test
	public void testGetStanzaAdiacenteLibera() {
		setStanzeAdiacenti(this.stanzaBloccata);
		assertEquals(STANZA_ADIACENTE_LIBERA,this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_LIBERA).getNome());
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		Fixture.creaAttrezzoEAggiungiAStanza (this.stanzaBloccata,"attrezzoDiTest",1);
		assertNull(this.stanzaBloccata.getAttrezzo("inesistente"));
	}
	
//	@Test
//	public void testGetDescrizioneDirezioneSbloccata() {
//		stanzaBloccata.addAttrezzo(a);
//		assertEquals(stanzaBloccata.toString(), stanzaBloccata.getDescrizione());
//	}
//	
//	@Test
//	public void testGetDescrizioneDirezioneBloccata() {
//		String e = "Stanza bloccata nella direzione: ovest"+"\nPrendi il grimaldello e posalo nella stanza";
//		assertEquals(e, stanzaBloccata.getDescrizione());
//		
//	}

}