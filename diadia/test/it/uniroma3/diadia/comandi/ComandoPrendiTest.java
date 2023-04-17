package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {
	
	private static final String ATTREZZO_DA_PRENDERE = "AttrezzoDaPrendere";
	private ComandoPrendi comandoPrendi;
	private Partita partita;
	
	@Before
	public void setUp () throws Exception {
		this.comandoPrendi = new ComandoPrendi();
		this.comandoPrendi.setIO(new IOConsole());
		this.partita = new Partita();
		Attrezzo attrezzoNuovo = new Attrezzo(ATTREZZO_DA_PRENDERE, 1);
		this.partita.getStanzaCorrente().addAttrezzo(attrezzoNuovo);
		
	}
	
	@Test
	public void testEseguiAttrezzoPresente() {
		this.comandoPrendi.setParametro(ATTREZZO_DA_PRENDERE);
		this.comandoPrendi.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_PRENDERE));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_PRENDERE));
	}
	
	@Test
	public void testEseguiAttrezzoNonPresente() {
		String nonPresente = "attrezzoNonPresente";
		this.comandoPrendi.setParametro(nonPresente);
		this.comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(nonPresente));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_PRENDERE));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_PRENDERE));
	}
	
	@Test
	public void testEseguiBorsaPiena() {
		Borsa borsa = partita.getGiocatore().getBorsa();
		borsa.addAttrezzo(new Attrezzo("AttrezzoPesante", borsa.getPesoMax()));
		this.comandoPrendi.setParametro(ATTREZZO_DA_PRENDERE);
		this.comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_PRENDERE));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_PRENDERE));
	}

}
