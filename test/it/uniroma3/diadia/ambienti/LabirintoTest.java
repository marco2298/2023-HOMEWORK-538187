package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;

public class LabirintoTest {
	Labirinto lab;
	Stanza biblioteca;
	Stanza DS1;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		lab = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
		
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", lab.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		lab.setStanzaCorrente(DS1);
		assertEquals(DS1, lab.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", lab.getStanzaCorrente().getNome());
	}

}
