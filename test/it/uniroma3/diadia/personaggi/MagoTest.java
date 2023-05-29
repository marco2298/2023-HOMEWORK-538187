package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class MagoTest {
	private Partita partita;
	private Mago mago;
	private Attrezzo regalo;

	@Before
	public void setUp() throws Exception {
		Labirinto labirinto = new Labirinto("labirinto5.txt");
		this.partita = new Partita(labirinto);
		this.regalo = new Attrezzo("clava", 2);
		this.mago = new Mago("Mago", "Merlino", this.regalo);
	}

	@Test
	public void testAgisci() {
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		this.mago.agisci(this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
	}
	
	@Test
	public void testAgisci_DueVolte() {
		assertFalse(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		this.mago.agisci(this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		this.partita.getStanzaCorrente().removeAttrezzo(this.regalo);
		this.mago.agisci(this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
	}

	@Test
	public void testRiceviRegalo() {
		this.mago.riceviRegalo(new Attrezzo("test", 1), this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("test"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("test"));
	}

}