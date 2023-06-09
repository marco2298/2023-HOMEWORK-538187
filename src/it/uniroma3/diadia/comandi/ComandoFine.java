package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
	
	private IO io;
	public final static String NOME = "fine";
	public static final String MESSAGGIO_FINE = "Grazie di aver giocato!";
	
	/**
	 * Comando "Fine".
	 */
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
	
	@Override
	public String getParametro() {
		return null;
	}

}
