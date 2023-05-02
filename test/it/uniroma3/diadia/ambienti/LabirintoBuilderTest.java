package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class LabirintoBuilderTest {
	
	@Test
	public void testLabirintoMonolocale() {
		Labirinto monolocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto") // aggiunge una stanza, che sarà anche iniziale
				.addStanzaVincente("salotto") // specifica quala stanza sarà vincente
				.getLabirinto();
		assertEquals("salotto", monolocale.getStanzaIniziale().getNome());
		assertEquals("salotto", monolocale.getStanzaVincente().getNome());
	}
	
	@Test
	public void testLabirintoBilocale() {
		LabirintoBuilder bilocale = (LabirintoBuilder) new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanzaVincente("camera")
				.addAttrezzo("letto",10) // dove? fa riferimento all’ultima stanza aggiunta
				.addAdiacenza("salotto", "camera", "nord") // camera si trova a nord di salotto
				.getLabirinto();
		
		assertEquals("salotto", bilocale.getStanzaIniziale().getNome());
		assertEquals("camera", bilocale.getStanzaVincente().getNome());
		
		Stanza a = null;
		Iterator<Stanza> it = bilocale.getListaStanze().iterator();
		while(it.hasNext()) {
			a=it.next();
			if(a.getNome().equals("camera"))
				assertTrue(a.hasAttrezzo("letto"));
			if(a.getNome().equals("salotto"))
				assertEquals("camera", a.getStanzaAdiacente("nord").getNome());
		}
	}
	
	@Test
	public void testLabirintoTrilocale() {
		LabirintoBuilder trilocale = (LabirintoBuilder) new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto(); // restituisce il Labirinto così creato
		
		assertEquals("salotto", trilocale.getStanzaIniziale().getNome());
		assertEquals("camera", trilocale.getStanzaVincente().getNome());
		
		Stanza a = null;
		Iterator<Stanza> it = trilocale.getListaStanze().iterator();
		while(it.hasNext()) {
			a=it.next();
			if(a.getNome().equals("cucina")) {
				assertTrue(a.hasAttrezzo("pentola"));
				assertEquals("camera", a.getStanzaAdiacente("est").getNome());
			}
			if(a.getNome().equals("salotto"))
				assertEquals("cucina", a.getStanzaAdiacente("nord").getNome());
		}
	}
}
