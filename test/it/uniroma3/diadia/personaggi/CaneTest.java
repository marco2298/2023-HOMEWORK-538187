package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaneTest {
	private Cane cane;
	private Partita partita;


	@Before
	public void setUp() throws Exception {
		Labirinto labirinto = new Labirinto("labirinto5.txt");
		this.partita = new Partita(labirinto);
		this.cane = new Cane("Cane", "Presentazione!");
	}

	@Test
	public void testAgisci() {
		this.partita.getGiocatore().setCfu(10);
		this.cane.agisci(this.partita);
		assertEquals(9, this.partita.getGiocatore().getCfu());
	}

	
	@Test
	public void testRiceviRegalo_Sbagliato() {
		Attrezzo ciboSbagliato = new Attrezzo("CiboSbagliato", 2);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(ciboSbagliato.getNome()));
		this.cane.riceviRegalo(ciboSbagliato, this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(ciboSbagliato.getNome()));
	}
	

}