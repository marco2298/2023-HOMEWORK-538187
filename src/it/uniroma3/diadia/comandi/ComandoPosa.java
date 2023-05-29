package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa extends AbstractComando {

	private IO io;
	public final String NOME = "posa";
	private String nomeAttrezzo;

	/**
	 * Cerca di posare un attrezzo dalla borsa nella stanza corrente, se non è presente stampa un messaggio di errore 
	 * altrimente rimuove l'attrezzo dalla borsa del giocatore e lo aggiunge alla stanza
	 */
	
	@Override
	public void esegui(Partita partita) {
			if (nomeAttrezzo==null) {
				io.mostraMessaggio("Non ho capito, Quale attrezzo devo posare ?");
				return;
			}
			Borsa borsa = partita.getGiocatore().getBorsa();
			Attrezzo attrezzoDaPosare = borsa.getAttrezzo(this.nomeAttrezzo);
			if(attrezzoDaPosare == null) {
				this.io.mostraMessaggio("Attrezzo "+ attrezzoDaPosare +" non presente nella borsa");
				return;
			}
			
			boolean attrezzoPosato = partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			if (!attrezzoPosato) {
				this.io.mostraMessaggio("Non c'e' piu' spazio nella stanza corrente");
				return;
			}
			
			borsa.removeAttrezzo(this.nomeAttrezzo);
			this.io.mostraMessaggio("Attrezzo "+ nomeAttrezzo + " posato!");
			

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
