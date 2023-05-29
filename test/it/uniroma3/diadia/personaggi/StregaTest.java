package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StregaTest {
	private static final String STANZA_2_ATTREZZI = "N10";
	private Partita partita;
	private Strega strega;

	@Before
	public void setUp() throws Exception {
		Labirinto labirinto = new Labirinto("labirinto5.txt");
		this.partita = new Partita(labirinto);
		this.strega = new Strega("Morgana", "Presentazione");
	}

	
	@Test
	public void testAgisci_Saluta() {
		this.strega.saluta();
		this.strega.agisci(this.partita);
		assertEquals(STANZA_2_ATTREZZI, this.partita.getStanzaCorrente().getNome());
		
	}

	@Test
	public void testRiceviRegalo() {
		this.strega.riceviRegalo(new Attrezzo("test", 1), this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("test"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("test"));
	}
}