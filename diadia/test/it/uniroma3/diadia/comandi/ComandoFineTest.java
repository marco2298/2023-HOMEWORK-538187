package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoFineTest {
	
	List<String> righeDaLeggere;

	@Before
	public void setUp() throws Exception {
		righeDaLeggere = new ArrayList<>();
	}
	
	@Test
	public void testPartitaConComandoFineConListe() {
		List<String> righeDaLeggere = new ArrayList<>();
		righeDaLeggere.add(ComandoFine.NOME);
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE,io.nextMessaggio());
	}
	
}
