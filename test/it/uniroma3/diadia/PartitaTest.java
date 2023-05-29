package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Classe di test per la classe Partita
 * 
 * @author Marco
 * 
 * */

public class PartitaTest {
	
	private Partita partita;
	private Labirinto lab;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		lab = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		this.partita = new Partita(lab);
	}

	@Test
	public void testGetStanzaVincenteNotNull() {
		assertNotNull(this.partita.getLabirinto().getStanzaVincente());
	}
	
	@Test
	public void testVintaSeStanzaCorrenteEVinente() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testNonVintaSeStanzaCorrenteNonEVincente() {
		this.partita.setStanzaCorrente(new Stanza("NonVincente"));		
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testNonVintaInizioPartita() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testFinitaSeVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinitaSeEsplicitamenteSettato() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinitaSeCFUFiniti() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testNonFinitaInizioPartita() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("N11", this.partita.getLabirinto().getStanzaVincente().getNome());
	}
	
}
