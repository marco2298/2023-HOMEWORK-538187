package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoSconosciuto extends AbstractComando {

	private ReflectiveOperationException exception;

	public ComandoSconosciuto() {
	}
	
	public ComandoSconosciuto(ReflectiveOperationException e) {
		this.exception = e;
	}

	public ReflectiveOperationException getException() {
		return exception;
	}

	@Override
	public void esegui(Partita partita) {
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
