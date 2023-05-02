package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	private IO io;
	public final String NOME = "non_valido";

	@Override
	public void esegui(Partita partita) {

			io.mostraMessaggio("Comando sconosciuto");
		}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
