package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class ComandoVaiTest {
	
	private Comando comando;
	private Partita partita;
	private Labirinto lab;
	private IO io;
	
	
	@Before
	public void setUp() {
		this.partita = new Partita(lab);
		this.io = new IOConsole();
		this.partita.setLabirinto(lab);
		this.comando = new ComandoVai();
		this.comando.setParametro("sud");
		this.comando.setIO(io);
		this.comando.esegui(this.partita);
	}
	
	@Test
	public void testTornoVersoNordEMiTrovoInAtrio() {
		this.comando = new ComandoVai();
		this.comando.setParametro("nord");
		this.comando.setIO(this.io);
		this.comando.esegui(this.partita);
		assertEquals("Atrio", this.partita.getStanzaCorrente().getNome());
	}
	@Test
	public void testMiTrovoInN10() {
		this.comando.esegui(this.partita);
	}

	@Test
	public void testNomeVai() {
		assertEquals("vai", this.comando.getNome());
	}

	@Test
	public void testParametroSud() {
		assertEquals("sud", this.comando.getParametro());
	}
	
	
	
}
